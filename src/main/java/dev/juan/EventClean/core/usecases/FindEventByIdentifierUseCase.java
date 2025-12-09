package dev.juan.EventClean.core.usecases;

import dev.juan.EventClean.core.entities.Event;

import java.util.Optional;

public interface FindEventByIdentifierUseCase {

    public Optional<Event> execute(String identier);
}
