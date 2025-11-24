package dev.juan.EventClean.core.usecases;

import dev.juan.EventClean.core.entities.Event;
import dev.juan.EventClean.core.gateway.EventGateway;

public class CreateEventUseCaseImpl implements CreateEventUseCase {

    private final EventGateway eventGateway;

    public CreateEventUseCaseImpl(EventGateway eventGateway) {
        this.eventGateway = eventGateway;
    }

    @Override
    public Event execute(Event event) {
        return eventGateway.createEvent(event);
    }
}
