package ao.jfpack.rabbitmq.mockob;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Book {

    @JsonProperty
    public String title;

    @JsonProperty
    public String synopses;

    @JsonProperty
    public User author;

    public Book(String title, String synopses, User author) {
        this.title = title;
        this.synopses = synopses;
        this.author = author;
    }
}
