package dev.prmts.mculogger.logging;

import java.math.BigDecimal;

public record CompartmentLog(
        String type,
        BigDecimal value
) {
}
