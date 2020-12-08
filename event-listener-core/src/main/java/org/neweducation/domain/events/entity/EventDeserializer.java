package org.neweducation.domain.events.entity;

import io.quarkus.kafka.client.serialization.ObjectMapperDeserializer;
import org.neweducation.api.events.EventDTO;

public class EventDeserializer extends ObjectMapperDeserializer<EventDTO> {
    public EventDeserializer() {
        super(EventDTO.class);
    }
}