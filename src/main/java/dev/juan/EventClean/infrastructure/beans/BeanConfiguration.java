package dev.juan.EventClean.infrastructure.beans;

import dev.juan.EventClean.core.entities.Event;
import dev.juan.EventClean.core.gateway.EventGateway;
import dev.juan.EventClean.core.usecases.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;

@Configuration
public class BeanConfiguration {

    @Bean
    public CreateEventUseCase createEventUseCase(EventGateway eventGateway) {
        return new CreateEventUseCaseImpl(eventGateway);
    }

    @Bean
    public FindAllEventsUseCase findAllEventsUseCase(EventGateway eventGateway) {
        return new FindAllEventsUseCaseImpl(eventGateway);
    }

    @Bean
    public FindEventByIdentifierUseCase findEventByIdentifierUseCase(EventGateway eventGateway) {
        return new FindEventByIdentifierUseCaseImpl(eventGateway);
    }
}
