package dev.prmts.mculogger.logging;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;
import static org.springframework.data.mongodb.core.aggregation.ConvertOperators.ToDecimal.toDecimal;

@Repository
@RequiredArgsConstructor
public class LogRepository {
    private final MongoTemplate mongoTemplate;

    public void save(McuLog log) {
        mongoTemplate.save(log);
    }

    public McuLog findByIdAndLatest(String macAddress) {
        Query q = new Query();
        q.addCriteria(Criteria.where("macAddress").is(macAddress));
        q.with(Sort.by(Sort.Direction.DESC, "timeCreated"));
        return mongoTemplate.findOne(q, McuLog.class);
    }

    public List<CompartmentLog> findCompartmentLogByMacAddresses(Set<String> macAddresses) {
        Aggregation aggregation = Aggregation.newAggregation(
                match(new Criteria("macAddress").in(macAddresses)),
                sort(Sort.by(Sort.Direction.DESC, "timeCreated")),
                group("macAddress")
                        .first("sensorLogs").as("sensorLogs"),
                unwind("sensorLogs"),
                group("sensorLogs.type")
                        .first("sensorLogs.type").as("type")
                        .avg(toDecimal("$sensorLogs.value")).as("value")
        );
        AggregationResults<CompartmentLog> ar = mongoTemplate.aggregate(aggregation, "mcu_log", CompartmentLog.class);
        return ar.getMappedResults();
    }
}
