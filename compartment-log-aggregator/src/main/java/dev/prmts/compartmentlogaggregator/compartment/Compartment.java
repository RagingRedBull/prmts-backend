package dev.prmts.compartmentlogaggregator.compartment;

import java.util.Set;

public record Compartment(
        String id,
        String floorId,
        Set<String> detectorUnits,
        KonvaSpec konvaSpec
) {
}
