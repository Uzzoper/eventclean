package dev.juan.EventClean.core.usecases;

import dev.juan.EventClean.core.entities.Event;
import dev.juan.EventClean.core.gateway.EventGateway;
import dev.juan.EventClean.infrastructure.exception.NotFoundEventException;

import java.util.Optional;

public class FindEventByIdentifierUseCaseImpl implements FindEventByIdentifierUseCase{

    private final EventGateway eventGateway;

    public FindEventByIdentifierUseCaseImpl(EventGateway eventGateway) {
        this.eventGateway = eventGateway;
    }

    @Override
    public Event execute(String identier) {
        return eventGateway.findEventByIdentifier(identier)
                .orElseThrow(() -> new NotFoundEventException("Event with identifier "+ identier + " not found."));
    }
}
