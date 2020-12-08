package org.neweducation.domain.events.boundary;

import org.neweducation.api.events.EventDTO;
import org.neweducation.api.users.UserDTO;
import org.neweducation.domain.events.entity.EventEntity;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EventDTOMapper {

    public EventEntity toEntity(EventDTO eventDTO) {
        return EventEntity.builder()
//                .withId(eventDTO.getId())
                .withEventTime(eventDTO.getEventTime())
                .withEventType(eventDTO.getEventType())
                .withUserId(eventDTO.getUser().getUserId())
                .withUserName(eventDTO.getUser().getUserName())
                .build();
    }

    public EventDTO toDTO(EventEntity eventEntity) {
        return EventDTO.builder()
                .withId(eventEntity.getId())
                .withEventTime(eventEntity.getEventTime())
                .withEventType(eventEntity.getEventType())
                .withUser(UserDTO.builder()
                        .withId(eventEntity.getUserId())
                        .withUserName(eventEntity.getUserName())
                        .build())
                .build();
    }
}
