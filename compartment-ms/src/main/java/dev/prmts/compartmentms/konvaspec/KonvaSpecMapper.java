package dev.prmts.compartmentms.konvaspec;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface KonvaSpecMapper {
    KonvaSpecDto toDto(KonvaSpec konvaSpec);
    KonvaSpec toEntity(KonvaSpecDto konvaSpecDto);
}
