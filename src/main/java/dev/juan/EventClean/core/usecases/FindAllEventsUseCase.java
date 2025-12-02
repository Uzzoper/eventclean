package dev.juan.EventClean.core.usecases;

import dev.juan.EventClean.core.entities.Event;

import java.util.List;

public interface FindEventUseCase {

    public List<Event> execute();
}
