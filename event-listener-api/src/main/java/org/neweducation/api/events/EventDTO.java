package org.neweducation.api.events;

import org.neweducation.api.users.UserDTO;

import java.time.LocalDateTime;

public class EventDTO {

    private String id;
    private LocalDateTime eventTime;
    private String eventType;
    private UserDTO user;

    private EventDTO() {
        // empty for deserialization
    }

    private EventDTO(Builder builder) {
        id = builder.id;
        eventTime = builder.eventTime;
        eventType = builder.eventType;
        user = builder.user;
    }

    public String getId() {
        return id;
    }

    public String getEventType() {
        return eventType;
    }

    public LocalDateTime getEventTime() {
        return eventTime;
    }

    public UserDTO getUser() {
        return user;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private String id;
        private LocalDateTime eventTime;
        private String eventType;
        private UserDTO user;

        private Builder() {
            // empty
        }

        public Builder withId(String id) {
            this.id = id;
            return this;
        }

        public Builder withEventTime(LocalDateTime eventTime) {
            this.eventTime = eventTime;
            return this;
        }

        public Builder withEventType(String eventType) {
            this.eventType = eventType;
            return this;
        }

        public Builder withUser(UserDTO user) {
            this.user = user;
            return this;
        }

        public EventDTO build() {
            return new EventDTO(this);
        }
    }
}
