package dev.prmts.mcusimulator.log;

import lombok.Data;

import java.math.BigDecimal;

public record SensorLog (
        String type,
        BigDecimal value
) {

}
