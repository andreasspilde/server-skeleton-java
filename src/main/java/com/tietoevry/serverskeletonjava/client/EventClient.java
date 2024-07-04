package com.tietoevry.serverskeletonjava.client;


import java.util.Iterator;
import java.util.List;

import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tietoevry.serverskeletonjava.dao.EventDAO;
import com.tietoevry.serverskeletonjava.dao.PersonDAO;
import com.tietoevry.serverskeletonjava.dto.EventDTO;
import com.tietoevry.serverskeletonjava.dto.PersonDTO;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class EventClient {

    public static enum eventType{
        PERSON_CREATED,
        NAME_CHANGE,
        SOCSECNUM_CHANGE,
        ADDRESS_CHANGE,
        EMAIL_CHANGE,
        PHONE_CHANGE
    }
    //For one event
    public String getEvent(long sequenceNumber){
        var tokenGen = new TokenClient();
        String token = tokenGen.getToken();
        token = token.substring(10);
        token = token.substring(0, token.length()-2);
        String webToken = "Bearer " + token;
        String result = "";
        WebClient web = WebClient.create("http://localhost:8080/");
        Mono<EventDTO> test = web.get()
            .uri("events/" + sequenceNumber)
            .header("Authorization", webToken)
            .retrieve()
            .bodyToMono(EventDTO.class);


        EventDTO resultat = test.block();
        
        result = resultat.toString();
        return result;
    }
    //For all events
    public String getEvents(){
        var tokenGen = new TokenClient();
        String token = tokenGen.getToken();
        token = token.substring(10);
        token = token.substring(0, token.length()-2);
        String result = "";

        String webToken = "Bearer " + token;
        WebClient web = WebClient.create("http://localhost:8080");
        Flux<EventDTO> response = web.get()
         .uri("/events")
         .header("Authorization", webToken)
         .retrieve()
         .bodyToFlux(EventDTO.class);

        List<EventDTO> eventList = response.collectList().block();
        EventDAO eventTable = new EventDAO();
        PersonDAO personTable = new PersonDAO();
        for ( EventDTO a : eventList){
            eventTable.insertEvent(a);
            //TODO add the changes, 
            /*switch (a.getEventType()) {
                case "PERSON_CREATED":
                    personTable.insertPerson((PersonDTO) a.getValue());
                    break;
                case "NAME_CHANGE":
                    personTable.in
                default:
                    break;
            }
            if(a.getEventType().equals("PERSON_CREATED")){
            }*/
        }
        //System.out.println("Response : " + eventList);
        //System.out.println("database entry 1  : " + eventTable.returnEventDTO("1"));
        result = eventList.toString();
        return result;
    }
    //Geteventstest
    public String getEventsTest(){
        var tokenGen = new TokenClient();
        String token = tokenGen.getToken();
        token = token.substring(10);
        token = token.substring(0, token.length()-2);
        String result = "";

        String webToken = "Bearer " + token;
        WebClient web = WebClient.create("http://localhost:8080");
        Flux<String> response = web.get()
         .uri("/events")
         .header("Authorization", webToken)
         .retrieve()
         .bodyToFlux(String.class);

        List<String> eventList = response.collectList().block();
        
        System.out.println("Response : " + eventList);
        result = eventList.toString();
        return result;
    }
    //For all events from a given point
    public String getEventsFrom(long sequenceNumber){
        var tokenGen = new TokenClient();
        String token = tokenGen.getToken();
        token = token.substring(10);
        token = token.substring(0, token.length()-2);

        String webToken = "Bearer " + token;
        WebClient web = WebClient.create("http://localhost:8080");
        Flux<EventDTO> response = web.get()
         .uri("/events/from/" + sequenceNumber)
         .header("Authorization", webToken)
         .retrieve()
         .bodyToFlux(EventDTO.class);

        List<EventDTO> result = response.collectList().block();

        //System.out.println("Response : " + eventList);
        String results = result.toString();
        return results;
    }
}
