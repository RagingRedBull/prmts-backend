package dev.prmts.mculogger.logging;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class SensorLog {
    private Sensor type;
    private BigDecimal value;
}
