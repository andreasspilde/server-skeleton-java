package com.tietoevry.serverskeletonjava.dto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class EventDTO implements IEventDTO{
    @JsonProperty("socSecNum")
    private String socSecNum;
    @JsonProperty("eventType")
    private String eventType;
    @JsonProperty("value")
    private Object value;
    @JsonProperty("sequenceNumber")
    private String sequenceNumber;
    @JsonProperty("timestamp")
    private String timestamp;
}
