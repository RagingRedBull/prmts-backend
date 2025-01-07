package dev.prmts.compartmentms.detectorunit;

import dev.prmts.compartmentms.compartment.Compartment;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "detector_unit")
@Getter
@Setter
@NoArgsConstructor
public class DetectorUnit {
    @Id
    @Column(name = "mac_address")
    private String macAddress;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "compartment_id", nullable = false)
    private Compartment compartment;

    public DetectorUnit(String macAddress) {
        this.macAddress = macAddress;
    }
}
