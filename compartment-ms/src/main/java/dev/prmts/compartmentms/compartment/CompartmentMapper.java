package dev.prmts.compartmentms.compartment;

import dev.prmts.compartmentms.detectorunit.DetectorUnit;
import dev.prmts.compartmentms.konvaspec.KonvaSpecMapper;
import org.mapstruct.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING
        , uses = {KonvaSpecMapper.class}
)
public interface CompartmentMapper {
    @Mappings({
            @Mapping(source = "konvaSpec", target = "konvaSpecDto"),
            @Mapping(source = "detectorUnits", target = "detectorUnits", qualifiedByName = "detectorUnitDtoMapper")
    })
    CompartmentDto toDto(Compartment compartment);

    @Mappings({
            @Mapping(source = "konvaSpecDto", target = "konvaSpec"),
            @Mapping(source = "detectorUnits", target = "detectorUnits", qualifiedByName = "detectorUnitEntityMapper")
    })
    Compartment toEntity(CompartmentDto compartmentDto);

    List<CompartmentDto> toDto(List<Compartment> compartments);

    List<Compartment> toEntity(List<CompartmentDto> compartmentDtos);

    @Named("detectorUnitDtoMapper")
    default Set<String> mapDetectorUnitDto(Set<DetectorUnit> detectorUnits) {
        return detectorUnits.stream().map(DetectorUnit::getMacAddress).collect(Collectors.toSet());
    }

    @Named("detectorUnitEntityMapper")
    default Set<DetectorUnit> mapDetectorUnitEntity(Set<String> macAddresses) {
        return macAddresses.stream()
                .map(DetectorUnit::new)
                .collect(Collectors.toSet());
    }
}
