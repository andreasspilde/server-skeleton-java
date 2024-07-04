package com.tietoevry.serverskeletonjava.dao;

import java.util.HashMap;
import java.util.Map;

import com.tietoevry.serverskeletonjava.dto.PersonDTO;

public class PersonDAO {

    Map<String, PersonDTO> eventTable = new HashMap<>();
    //TODO add inserts for specific 
    public PersonDAO(){
    }
    public PersonDAO(PersonDTO event){
        eventTable.put(event.getSocSecNum(), event);
    }
    public void insertPerson(PersonDTO event){
        eventTable.put(event.getSocSecNum() , event);
    }
    public void insertChangeSocSecNum(PersonDTO person){
        eventTable.put(person.getSocSecNum() , person);
    }
    public void insertChangeName(PersonDTO person){
        eventTable.put(person.getSocSecNum(), person);
    }
    public PersonDTO getPerson(PersonDTO socSecNum){
        return eventTable.get(socSecNum);
    }
}
