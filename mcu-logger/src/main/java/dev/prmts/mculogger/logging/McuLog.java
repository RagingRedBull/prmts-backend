package dev.prmts.mculogger.logging;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.OffsetDateTime;
import java.util.Set;

@Document(collection = "mcu_log")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class McuLog {
    @Id
    private String id;
    private String macAddress;
    @CreatedDate
    @Indexed(direction = IndexDirection.DESCENDING)
    private OffsetDateTime timeCreated;
    private Set<SensorLog> sensorLogs;
}
