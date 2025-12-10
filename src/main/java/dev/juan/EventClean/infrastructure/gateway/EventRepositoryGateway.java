package dev.juan.EventClean.infrastructure.gateway;

import dev.juan.EventClean.core.entities.Event;
import dev.juan.EventClean.core.gateway.EventGateway;
import dev.juan.EventClean.infrastructure.mapper.EventEntityMapper;
import dev.juan.EventClean.infrastructure.persistence.EventEntity;
import dev.juan.EventClean.infrastructure.persistence.EventRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EventRepositoryGateway implements EventGateway {

    private final EventRepository eventRepository;
    private final EventEntityMapper eventEntityMapper;

    public EventRepositoryGateway(EventRepository eventRepository, EventEntityMapper eventEntityMapper) {
        this.eventRepository = eventRepository;
        this.eventEntityMapper = eventEntityMapper;
    }

    @Override
    public Event createEvent(Event event) {
        EventEntity eventEntity = eventEntityMapper.toEntity(event);
        EventEntity newEvent = eventRepository.save(eventEntity);
        return eventEntityMapper.toDomain(newEvent);
    }
    
    @Override
    public List<Event> findAllEvents() {
        return eventRepository.findAll().stream()
                .map(eventEntityMapper::toDomain)
                .toList();
    }

    @Override
    public boolean existsByIdentifier(String identifier) {
        return eventRepository.findAll().stream()
                .anyMatch(event -> event.getIdentifier().equalsIgnoreCase(identifier));
    }

    @Override
    public Optional<Event> findEventByIdentifier(String identifier) {
        return eventRepository.findEventByIdentifier(identifier);
    }
}
