package dev.prmts.floorms.floor;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class FloorService {
    private final FloorRepository floorRepository;

    public List<Floor> findAll() {
        return floorRepository.findAll(Sort.by(Sort.Direction.ASC, "sequence"));
    }

    public Floor save(Floor floor) {
        return floorRepository.save(floor);
    }

    public Optional<Floor> findById(String id) {
        return floorRepository.findById(id);
    }

    public FloorDto getFloorBySequence(Integer sequence) {
        return floorRepository.getFloorBySequence(sequence);
    }
}
