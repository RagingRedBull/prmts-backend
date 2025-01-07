package dev.prmts.compartmentms.compartment;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/compartments")
@RequiredArgsConstructor
public class CompartmentController {
    private final CompartmentService compartmentService;
    private final CompartmentMapper compartmentMapper;

    @GetMapping(path = "/{id}")
    public CompartmentDto getCompartmentById(@PathVariable("id") String id) {
        return compartmentMapper.toDto(compartmentService.getById(id));
    }

    @GetMapping(params = "floorId")
    public List<CompartmentDto> getAllCompartments(String floorId) {
        return compartmentService.getAllCompartmentsByFloorId(floorId);
    }


    @PostMapping
    public CompartmentDto createCompartment(@RequestBody CompartmentDto compartmentDto) {
        Compartment c = compartmentService.create(compartmentMapper.toEntity(compartmentDto));
        return compartmentMapper.toDto(c);
    }
}
