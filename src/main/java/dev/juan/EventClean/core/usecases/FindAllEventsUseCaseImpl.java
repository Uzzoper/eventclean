package dev.juan.EventClean.core.usecases;

import dev.juan.EventClean.core.entities.Event;
import dev.juan.EventClean.core.gateway.EventGateway;

import java.util.List;

public class FindAllEventsUseCaseImpl implements FindAllEventsUseCase {

    private final EventGateway eventGateway;

    public FindAllEventsUseCaseImpl(EventGateway eventGateway) {
        this.eventGateway = eventGateway;
    }

    @Override
    public List<Event> execute() {
        return eventGateway.findAllEvents();
    }
}
