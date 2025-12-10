package dev.juan.EventClean.infrastructure.presentation;

import dev.juan.EventClean.core.entities.Event;
import dev.juan.EventClean.core.usecases.CreateEventUseCase;
import dev.juan.EventClean.core.usecases.FindAllEventsUseCase;
import dev.juan.EventClean.core.usecases.FindEventByIdentifierUseCase;
import dev.juan.EventClean.infrastructure.dtos.EventDTO;
import dev.juan.EventClean.infrastructure.mapper.EventMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class EventController {

    private final CreateEventUseCase createEventUseCase;
    private final FindAllEventsUseCase findAllEventsUseCase;
    private final FindEventByIdentifierUseCase findEventByIdentifierUseCase;
    private final EventMapper eventMapper;

    public EventController(CreateEventUseCase createEventUseCase, FindAllEventsUseCase findAllEventsUseCase, FindEventByIdentifierUseCase findEventByIdentifierUseCase, EventMapper eventMapper) {
        this.createEventUseCase = createEventUseCase;
        this.findAllEventsUseCase = findAllEventsUseCase;
        this.findEventByIdentifierUseCase = findEventByIdentifierUseCase;
        this.eventMapper = eventMapper;
    }

    @PostMapping("/events")
    public ResponseEntity<Map<String, Object>> createEvent(@RequestBody EventDTO eventDTO) {
        Event newEvent = createEventUseCase.execute(eventMapper.toDomain(eventDTO));
        Map<String, Object> response = new HashMap<>();
        response.put("Message: ", "Event successfully registered.");
        response.put("Event data: ", eventMapper.toDTO(newEvent));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/events")
    public List<EventDTO> findAllEvents() {
        return findAllEventsUseCase.execute().stream()
                .map(eventMapper::toDTO)
                .toList();
    }

    @GetMapping("/events/{identifier}")
    public ResponseEntity<EventDTO> findEventByIdentifier(@PathVariable String identifier) {
        Event event = findEventByIdentifierUseCase.execute(identifier);
        return ResponseEntity.ok(eventMapper.toDTO(event));
    }
}
