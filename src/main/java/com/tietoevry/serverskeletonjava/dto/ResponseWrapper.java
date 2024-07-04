package com.tietoevry.serverskeletonjava.dto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseWrapper {
    @JsonProperty("id")
    private String id;
    @JsonProperty("event")
    private String event;
    @JsonProperty("data")
    private EventDTO data;

    // Getters and setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public Object getData() {
        return data;
    }

    public void setData(EventDTO data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseWrapper{" +
                "id=" + id +
                ", event='" + event + '\'' +
                ", data=" + data +
                '}';
    }
}
