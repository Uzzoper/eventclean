package dev.juan.EventClean.core.usecases;

import dev.juan.EventClean.core.entities.Event;

import java.util.Optional;

public class FindEventByIdentifierUseCaseImpl implements FindEventByIdentifierUseCase{

    @Override
    public Optional<Event> execute(String identier) {
        return Optional.empty();
    }
}
