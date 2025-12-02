package dev.juan.EventClean.core.usecases;

import dev.juan.EventClean.core.entities.Event;
import dev.juan.EventClean.core.gateway.EventGateway;

import java.util.List;

public class FindEventUseCaseImpl implements FindEventUseCase {

    private final EventGateway eventGateway;

    public FindEventUseCaseImpl(EventGateway eventGateway) {
        this.eventGateway = eventGateway;
    }

    @Override
    public List<Event> execute() {
        return eventGateway.findAllEvents();
    }
}
