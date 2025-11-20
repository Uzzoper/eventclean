package dev.juan.EventClean.core.gateway;

import dev.juan.EventClean.core.entities.Event;

public interface EventGateway {

    Event createEvent(Event event);
}
