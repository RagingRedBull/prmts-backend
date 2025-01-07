package dev.prmts.floorms.floor;

import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED)
public interface FloorMapper {
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "sequence", target = "sequence"),
    })
    FloorDto toDto(Floor floor);

    @Mappings({
            @Mapping(target = "createDate", ignore = true),
            @Mapping(target = "updateDate", ignore = true),
    })
    Floor toEntity(FloorDto floorDto);

    List<Floor> toEntities(List<FloorDto> floorDtos);

    List<FloorDto> toDtos(List<Floor> floors);
}
