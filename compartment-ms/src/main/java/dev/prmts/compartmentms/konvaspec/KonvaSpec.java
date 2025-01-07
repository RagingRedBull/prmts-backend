package dev.prmts.compartmentms.konvaspec;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
public class KonvaSpec implements Serializable {
    @Column(name = "konva_x")
    private Integer x;
    @Column(name = "konva_y")
    private Integer y;
    @Column(name = "konva_width")
    private Integer width;
    @Column(name = "konva_height")
    private Integer height;
}
