package org.neweducation.domain.events.control;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import org.bson.types.ObjectId;
import org.neweducation.domain.events.entity.EventEntity;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EventRepository implements PanacheMongoRepository<EventEntity> {

    public EventEntity getById(String id) {
        return findByIdOptional(new ObjectId(id))
                .orElseThrow(() -> new IllegalStateException("No Event with id: " + id));
    }

    public void save(EventEntity eventEntity) {
        persist(eventEntity);
    }
}
