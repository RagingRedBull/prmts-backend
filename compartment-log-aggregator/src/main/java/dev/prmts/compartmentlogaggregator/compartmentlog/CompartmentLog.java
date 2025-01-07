package dev.prmts.compartmentlogaggregator.compartmentlog;

import dev.prmts.compartmentlogaggregator.compartment.KonvaSpec;
import dev.prmts.compartmentlogaggregator.log.SensorLog;

import java.util.Set;

public record CompartmentLog(
        String id,
        KonvaSpec konvaSpec,
        Set<String> macAddresses,
        Set<SensorLog> sensorLogs
) {
}
