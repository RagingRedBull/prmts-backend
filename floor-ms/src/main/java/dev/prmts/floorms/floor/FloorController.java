package dev.prmts.floorms.floor;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/floors")
@RequiredArgsConstructor
@Log4j2
public class FloorController {
    private final FloorService floorService;
    private final FloorMapper floorMapper;

    @GetMapping
    public List<FloorDto> getAll() {
        return floorMapper.toDtos(floorService.findAll());
    }

    @GetMapping(path = "/{id}")
    public FloorDto getById(@PathVariable String id) {
     return floorService.findById(id)
             .map(floorMapper::toDto)
             .orElseThrow(() -> new RuntimeException(String.format("Floor with id %s not found", id)));
    }

    @GetMapping(params = {"sequence"})
    public FloorDto getBySequence(@RequestParam(value = "sequence") Integer sequence) {
        return floorService.getFloorBySequence(sequence);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FloorDto saveOne(@RequestBody FloorDto floorDto) {
        Floor entity = floorMapper.toEntity(floorDto);
        entity = floorService.save(entity);
        return floorMapper.toDto(entity);
    }
}
