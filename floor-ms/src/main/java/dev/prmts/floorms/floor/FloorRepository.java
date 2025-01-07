package dev.prmts.floorms.floor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FloorRepository extends JpaRepository<Floor, String> {
    @Query("SELECT new dev.prmts.floorms.floor.FloorDto(f.id, f.sequence, f.name, f.fileName) FROM Floor f WHERE f.sequence = :sequence")
    FloorDto getFloorBySequence(@Param("sequence") Integer sequence);
}
