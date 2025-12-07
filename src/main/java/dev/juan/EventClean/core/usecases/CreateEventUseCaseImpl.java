package dev.juan.EventClean.core.usecases;

import dev.juan.EventClean.core.entities.Event;
import dev.juan.EventClean.core.gateway.EventGateway;
import dev.juan.EventClean.infrastructure.exception.DuplicateEventException;

public class CreateEventUseCaseImpl implements CreateEventUseCase {

    private final EventGateway eventGateway;

    public CreateEventUseCaseImpl(EventGateway eventGateway) {
        this.eventGateway = eventGateway;
    }

    @Override
    public Event execute(Event event) {

        if (eventGateway.existsByIdentifier(event.identifier())) {
            throw new DuplicateEventException("The identifier "+ event.identifier() + " is already used.");
        }
        return eventGateway.createEvent(event);
    }
}
