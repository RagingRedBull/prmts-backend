package dev.prmts.mcusimulator.log;

import lombok.RequiredArgsConstructor;
import org.instancio.Instancio;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.instancio.Select.field;

@Component
public class SendJob implements Job {
    private static final List<String> macAddress = List.of("6E:F5:FE:1B:71:51", "74:2B:AD:59:B7:05", "74:F8:A6:16:95:9B",
            "5E:A0:64:E2:74:56", "34:A5:CE:2F:7F:CA", "74:74:4A:A6:D7:6E", "8C:F4:48:73:24:F7",
            "C6:D2:B5:31:C8:1E", "12:35:67:5F:DB:CF", "42:F9:64:1E:B6:DB");
    @Autowired
    private SimProcessor simProcessor;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        int idx = jobExecutionContext.getJobDetail().getJobDataMap().getInt("INDEX");
        McuLog mcuLog = new McuLog(macAddress.get(idx), getSensorLogs());
        simProcessor.send(mcuLog);
    }

    private Set<SensorLog> getSensorLogs() {
        return Stream.of("DHT11", "DHT22", "MQ2", "MQ5", "MQ7")
                .map(s -> Instancio.of(SensorLog.class)
                        .set(field(SensorLog::type), s)
                        .generate(field(SensorLog::value), gen -> gen.math()
                                .bigDecimal()
                                .scale(2)
                                .range(new BigDecimal(20), new BigDecimal(40)))
                        .create())
                .collect(Collectors.toSet());
    }
}
