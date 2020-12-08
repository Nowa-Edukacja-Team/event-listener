package org.neweducation.domain.events.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.quarkus.mongodb.panache.MongoEntity;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

import java.time.LocalDateTime;
import java.util.Optional;

@MongoEntity(collection = "events")
public class EventEntity {

    //    @JsonProperty("_id")
    @JsonProperty("_id")
    public ObjectId _id;

    @JsonProperty("eventTime")
    public LocalDateTime eventTime;

    @JsonProperty("eventType")
    public String eventType;

    @JsonProperty("userId")
    public Long userId;

    @JsonProperty("userName")
    public String userName;

    public EventEntity() {
        // empty
    }

    private EventEntity(Builder builder) {
        _id = builder.id;
        eventTime = builder.eventTime;
        eventType = builder.eventType;
        userId = builder.userId;
        userName = builder.userName;
    }

    public String getId() {
        return Optional.ofNullable(_id)
                .map(ObjectId::toHexString)
                .orElse(null);
    }

    public String getEventType() {
        return eventType;
    }

    public LocalDateTime getEventTime() {
        return eventTime;
    }

    public Long getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private ObjectId id;
        private LocalDateTime eventTime;
        private String eventType;
        private Long userId;
        private String userName;

        private Builder() {
            // empty
        }

        public Builder withId(String id) {
            this.id = new ObjectId(id);
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

        public Builder withUserId(Long userId) {
            this.userId = userId;
            return this;
        }

        public Builder withUserName(String userName) {
            this.userName = userName;
            return this;
        }

        public EventEntity build() {
            return new EventEntity(this);
        }
    }
}
