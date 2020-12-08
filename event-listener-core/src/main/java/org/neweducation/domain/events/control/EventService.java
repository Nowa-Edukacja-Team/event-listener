package org.neweducation.domain.events.control;

import org.neweducation.domain.events.entity.EventEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class EventService {

    @Inject
    EventRepository eventRepository;

    public List<EventEntity> getAll() {
        return eventRepository.listAll();
    }
}
