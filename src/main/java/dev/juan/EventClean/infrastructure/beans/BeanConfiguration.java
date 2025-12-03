package dev.juan.EventClean.infrastructure.beans;

import dev.juan.EventClean.core.gateway.EventGateway;
import dev.juan.EventClean.core.usecases.CreateEventUseCase;
import dev.juan.EventClean.core.usecases.CreateEventUseCaseImpl;
import dev.juan.EventClean.core.usecases.FindAllEventsUseCase;
import dev.juan.EventClean.core.usecases.FindAllEventsUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
}
