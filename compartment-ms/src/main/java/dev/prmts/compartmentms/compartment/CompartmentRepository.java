package dev.prmts.compartmentms.compartment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompartmentRepository extends JpaRepository<Compartment, String> {

    @Query("SELECT new dev.prmts.compartmentms.compartment.CompartmentDto(c.id, c.konvaSpec) FROM Compartment c WHERE c.floorId = :floorId")
    List<CompartmentDto> findAllByFloorId(@Param("floorId") String floorId);
}
