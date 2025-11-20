package dev.juan.EventClean.infrastructure.mapper;

import dev.juan.EventClean.core.entities.Event;
import dev.juan.EventClean.infrastructure.persistence.EventEntity;
import org.springframework.stereotype.Component;

@Component
public class EventEntityMapper {

    public EventEntity toEntity(Event event) {
        return new EventEntity(
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

    public Event toDomain(EventEntity eventEntity) {
        return new Event(
                eventEntity.getId(),
                eventEntity.getName(),
                eventEntity.getDescription(),
                eventEntity.getIdentifier(),
                eventEntity.getStartDate(),
                eventEntity.getEndDate(),
                eventEntity.getLocation(),
                eventEntity.getCapacity(),
                eventEntity.getOrganizer(),
                eventEntity.getType()
        );
    }
}
