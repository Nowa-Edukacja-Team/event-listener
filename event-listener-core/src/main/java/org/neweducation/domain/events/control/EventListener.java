package org.neweducation.domain.events.control;

import io.smallrye.reactive.messaging.annotations.Blocking;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.neweducation.api.events.EventDTO;
import org.neweducation.domain.events.boundary.EventDTOMapper;
import org.neweducation.domain.events.entity.EventEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@ApplicationScoped
class EventListener {

    @Inject
    private EventRepository eventRepository;

    @Inject
    private EventDTOMapper eventDTOMapper;

    @Incoming("event-topic")
    @Blocking
    @Transactional
    public void consumeEventDTO(EventDTO eventDTO) {
        if(eventDTO == null) {
            throw new IllegalStateException("EventDTO is null");
        }
        EventEntity entity = eventDTOMapper.toEntity(eventDTO);
        eventRepository.save(entity);
    }
}
