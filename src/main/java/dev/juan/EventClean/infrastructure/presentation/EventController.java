package dev.juan.EventClean.infrastructure.presentation;

import dev.juan.EventClean.core.entities.Event;
import dev.juan.EventClean.core.usecases.CreateEventUseCase;
import dev.juan.EventClean.core.usecases.FindAllEventsUseCase;
import dev.juan.EventClean.infrastructure.dtos.EventDTO;
import dev.juan.EventClean.infrastructure.mapper.EventMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class EventController {

    private final CreateEventUseCase createEventUseCase;
    private final FindAllEventsUseCase findAllEventsUseCase;
    private final EventMapper eventMapper;

    public EventController(CreateEventUseCase createEventUseCase, FindAllEventsUseCase findAllEventsUseCase, EventMapper eventMapper) {
        this.createEventUseCase = createEventUseCase;
        this.findAllEventsUseCase = findAllEventsUseCase;
        this.eventMapper = eventMapper;
    }

    @PostMapping("/events")
    public EventDTO createEvent(@RequestBody EventDTO eventDTO) {
        Event newEvent = createEventUseCase.execute(eventMapper.toDomain(eventDTO));
        return eventMapper.toDTO(newEvent);
    }

    @GetMapping("/events")
    public List<EventDTO> findAllEvents() {
        return findAllEventsUseCase.execute().stream()
                .map(eventMapper::toDTO)
                .toList();
    }
}
