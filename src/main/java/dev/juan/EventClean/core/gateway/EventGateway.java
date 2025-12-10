package dev.juan.EventClean.core.gateway;

import dev.juan.EventClean.core.entities.Event;

import java.util.List;
import java.util.Optional;

public interface EventGateway {

    Event createEvent(Event event);

    List<Event> findAllEvents();

    boolean existsByIdentifier(String identifier);

    Optional<Event> findEventByIdentifier(String identifier);
}
