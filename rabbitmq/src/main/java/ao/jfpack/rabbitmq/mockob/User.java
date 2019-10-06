package ao.jfpack.rabbitmq.mockob;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

    @JsonProperty
    public String fullname;

    public User(String fullname) {
        this.fullname = fullname;
    }
}
