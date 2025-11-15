package dev.juan.EventClean.core.usecases;

import dev.juan.EventClean.core.entities.Event;

public interface CreateEventUseCase {

    public Event execute(Event event);
}
