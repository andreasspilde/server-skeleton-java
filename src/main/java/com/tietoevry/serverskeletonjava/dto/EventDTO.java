package com.tietoevry.serverskeletonjava.dto;
import com.fasterxml.jackson.annotation.JsonProperty;

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

    public EventDTO(){

    }

    public EventDTO(String socSecNum, String eventType, String value, String sequenceNumber, String timestamp){
    
        this.socSecNum = socSecNum;
        this.eventType = eventType;
        this.value = value;
        this.sequenceNumber = sequenceNumber;
        this.timestamp = timestamp;
    }
    public String getSocSecNum(){
        return socSecNum;
    }
    public String getEventType(){
        return eventType;
    }
    public Object getValue(){
        return value;
    }
    public String getSequenceNumber(){
        return sequenceNumber;
    }
    public String getTimestamp(){
        return timestamp;
    }
    public void setSocSecNum(String socSecNum){
        this.socSecNum = socSecNum;
    }
    public void setEventType(String eventType){
        this.eventType = eventType;
    }
    public void setValue(Object value){
        this.value = value;
    }
    public void setSequenceNumber(String sequenceNumber){
        this.sequenceNumber = sequenceNumber;
    }
    public void setTimestamp(String timestamp){
        this.timestamp = timestamp;
    }
    @Override
    public String toString() {
        return "EventDTO{" +
                "socSecNum='" + socSecNum + '\'' +
                ", eventType='" + eventType + '\'' +
                ", value=" + value +
                ", sequenceNumber=" + sequenceNumber +
                ", timestamp='" + timestamp + '\'' +
                '}';
        }
    }
