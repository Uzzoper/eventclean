package dev.juan.EventClean.core.gateway;

import dev.juan.EventClean.core.entities.Event;

import java.util.List;

public interface EventGateway {

    Event createEvent(Event event);

    List<Event> findAllEvents();
}
