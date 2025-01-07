package dev.prmts.compartmentms.compartment;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.prmts.compartmentms.konvaspec.KonvaSpec;
import dev.prmts.compartmentms.konvaspec.KonvaSpecDto;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CompartmentDto {
    private String id;
    private String floorId;
    private Set<String> detectorUnits;
    @JsonProperty("konvaSpec")
    private  KonvaSpecDto konvaSpecDto;

    public CompartmentDto() {
    }

    public CompartmentDto(String id, KonvaSpec konvaSpec) {
        this.id = id;
        this.konvaSpecDto = new KonvaSpecDto(konvaSpec.getX(), konvaSpec.getY(),
                konvaSpec.getWidth(), konvaSpec.getHeight());
    }

    public CompartmentDto(String id, String floorId, Set<String> detectorUnits, KonvaSpecDto konvaSpecDto) {
        this.id = id;
        this.floorId = floorId;
        this.detectorUnits = detectorUnits;
        this.konvaSpecDto = konvaSpecDto;
    }
}
