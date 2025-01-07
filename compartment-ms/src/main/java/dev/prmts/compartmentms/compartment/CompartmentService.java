package dev.prmts.compartmentms.compartment;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CompartmentService {
    private final CompartmentRepository compartmentRepository;

    public List<CompartmentDto> getAllCompartmentsByFloorId(String floorId) {
        return compartmentRepository.findAllByFloorId(floorId);
    }

    public Compartment create(Compartment compartment) {
        return compartmentRepository.save(compartment);
    }

    public Compartment getById(String id) {
        return compartmentRepository.findById(id)
                .orElse(null);
    }
}
