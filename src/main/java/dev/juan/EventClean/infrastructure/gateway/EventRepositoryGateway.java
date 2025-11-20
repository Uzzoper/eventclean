package dev.juan.EventClean.infrastructure.gateway;

import dev.juan.EventClean.core.entities.Event;
import dev.juan.EventClean.core.gateway.EventGateway;
import dev.juan.EventClean.infrastructure.persistence.EventRepository;
import org.springframework.stereotype.Component;

@Component
public class EventRepositoryGateway implements EventGateway {

    private final EventRepository eventRepository;

    public EventRepositoryGateway(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public Event createEvent(Event event) {
        return eventRepository.save(Event);
    }
}
