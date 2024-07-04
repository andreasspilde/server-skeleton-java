package com.tietoevry.serverskeletonjava.dao;

import java.util.HashMap;
import java.util.Map;

import com.tietoevry.serverskeletonjava.dto.EventDTO;

public class EventDAO {
    Map<String, EventDTO> eventTable = new HashMap<>();

    public EventDAO(){

    }
    public void insertEvent(EventDTO event){
        eventTable.put(findId(), event);
    }
    public String findId(){
        Integer id = 1;
        if(eventTable.isEmpty()){
            return id.toString();
        }
        else{
            id = eventTable.size() + 1;
        }
        return id.toString();
    }
    public EventDTO returnEventDTO(String id){
        return eventTable.get(id);
    }
}
