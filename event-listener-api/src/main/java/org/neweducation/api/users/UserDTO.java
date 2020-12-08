package org.neweducation.api.users;

public class UserDTO {

    private Long userId;
    private String userName;

    private UserDTO() {
        // empty for deserialization
    }

    public UserDTO(Builder builder) {
        userId = builder.userId;
        userName = builder.userName;
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

        private Long userId;
        private String userName;

        private Builder() {
            // empty
        }

        public Builder withId(Long userId) {
            this.userId = userId;
            return this;
        }

        public Builder withUserName(String userName) {
            this.userName = userName;
            return this;
        }

        public UserDTO build() {
            return new UserDTO(this);
        }
    }
}
