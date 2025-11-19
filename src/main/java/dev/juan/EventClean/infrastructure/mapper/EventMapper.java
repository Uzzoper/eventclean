package dev.juan.EventClean.infrastructure.mapper;

import dev.juan.EventClean.core.entities.Event;
import dev.juan.EventClean.infrastructure.dtos.EventDTO;
import org.springframework.stereotype.Component;

@Component
public class EventMapper {

    public Event toDomain(EventDTO eventDTO) {

        return new Event(
                eventDTO.id(),
                eventDTO.name(),
                eventDTO.description(),
                eventDTO.identifier(),
                eventDTO.startDate(),
                eventDTO.endDate(),
                eventDTO.location(),
                eventDTO.capacity(),
                eventDTO.organizer(),
                eventDTO.type()
                );
    }

    public EventDTO toDTO(Event event) {
        return new EventDTO(
                event.id(),
                event.name(),
                event.description(),
                event.identifier(),
                event.startDate(),
                event.endDate(),
                event.location(),
                event.capacity(),
                event.organizer(),
                event.type()
                );
    }
}
