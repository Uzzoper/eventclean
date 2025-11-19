package dev.juan.EventClean.infrastructure.presentation;

import dev.juan.EventClean.core.entities.Event;
import dev.juan.EventClean.core.usecases.CreateEventUseCase;
import dev.juan.EventClean.infrastructure.dtos.EventDTO;
import dev.juan.EventClean.infrastructure.mapper.EventMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class EventController {

    private final CreateEventUseCase createEventUseCase;
    private final EventMapper eventMapper;

    public EventController(CreateEventUseCase createEventUseCase, EventMapper eventMapper) {
        this.createEventUseCase = createEventUseCase;
        this.eventMapper = eventMapper;
    }

    @PostMapping("/create")
    public EventDTO createEvent(@RequestBody EventDTO eventDTO) {
        Event newEvent = createEventUseCase.execute(eventMapper.toDomain(eventDTO));
        return eventMapper.toDTO(newEvent);
    }
}
