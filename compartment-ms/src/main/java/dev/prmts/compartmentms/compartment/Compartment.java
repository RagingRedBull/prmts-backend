package dev.prmts.compartmentms.compartment;

import dev.prmts.compartmentms.detectorunit.DetectorUnit;
import dev.prmts.compartmentms.konvaspec.KonvaSpec;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.Set;

@Entity
@Table(name = "compartment")
@Getter
@Setter
@NoArgsConstructor
public class Compartment {
    @Id
    @Column(name = "compartment_id")
    @UuidGenerator
    private String id;
    @Embedded
    private KonvaSpec konvaSpec;
    @Column(name = "floor_id", nullable = false)
    private String floorId;
    @OneToMany(mappedBy = "compartment",fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @Setter(AccessLevel.NONE)
    private Set<DetectorUnit> detectorUnits;

    public void setDetectorUnits(Set<DetectorUnit> detectorUnits) {
        this.detectorUnits = detectorUnits;
        this.detectorUnits.forEach(o -> o.setCompartment(this));
    }
}
