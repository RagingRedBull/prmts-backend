package dev.prmts.compartmentlogaggregator.log;

import java.math.BigDecimal;

public record SensorLog(
        String type,
        BigDecimal value
) {
}
