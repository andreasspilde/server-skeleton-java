package com.tietoevry.serverskeletonjava.dto;
import com.fasterxml.jackson.annotation.JsonProperty;

public class EventDTOwithperson  implements IEventDTO{
    @JsonProperty("socSecNum")
    private String socSecNum;
    @JsonProperty("eventType")
    private String eventType;
    @JsonProperty("value")
    private PersonDTO value;
    @JsonProperty("sequenceNumber")
    private String sequenceNumber;//: 14"
    @JsonProperty("timestamp")
    private String timestamp;//: "2024-06-28T08:00:13"

    public EventDTOwithperson(){

    }

    public EventDTOwithperson(String socSecNum, String eventType, PersonDTO value, String sequenceNumber, String timestamp){
    
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
    public PersonDTO getValue(){
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
    public void setValue(PersonDTO value){
        this.value = value;
    }
    public void setSequenceNumber(String sequenceNumber){
        this.sequenceNumber = sequenceNumber;
    }
    public void setTimestamp(String timestamp){
        this.timestamp = timestamp;
    }
    @Override 
    public String toString(){
        return socSecNum + " \n" + eventType + " \n" + value + " \n" + sequenceNumber + " \n" + timestamp;
    }
}
