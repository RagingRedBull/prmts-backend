package dev.prmts.mcusimulator.log;

import java.util.Set;

public record McuLog(
        String macAddress,
        Set<SensorLog> sensorLogs
) {
}
