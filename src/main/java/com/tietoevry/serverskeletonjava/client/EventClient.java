package com.tietoevry.serverskeletonjava.client;


import java.util.List;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import com.tietoevry.serverskeletonjava.dto.EventDTO;
import com.tietoevry.serverskeletonjava.dto.EventDTOwithperson;
import com.tietoevry.serverskeletonjava.dto.IEventDTO;
import com.tietoevry.serverskeletonjava.dto.ResponseWrapper;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class EventClient {
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
        //result= event.toString();
        //System.out.println(event);
        //System.out.println(event.get("eventType"));
        //System.out.println(event.get("value"));
        //Map pers;
        //pers = event.get("value");
        /*if(event.get("eventType").toString().equals("PERSON_CREATED")){
            PersonDTO person = new PersonDTO();
            person.setName(pers.get("name").toString());
            person.setSocSecNum(pers.get("socSecNum").toString());
            person.setAddress(pers.get("address").toString());
            person.setEmail(pers.get("email").toString());
            person.setPhone(pers.get("phone").toString());
            System.out.println("Her " + person);
        }
        else{
            System.out.println("whut?");
        }
            */
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
        Flux<ResponseWrapper> response = web.get()
         .uri("/events")
         .header("Authorization", webToken)
         .retrieve()
         .bodyToFlux(ResponseWrapper.class);

        List<ResponseWrapper> eventList = response.collectList().block();
    
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
        Flux<ResponseWrapper> response = web.get()
         .uri("/events/from/" + sequenceNumber)
         .header("Authorization", webToken)
         .retrieve()
         .bodyToFlux(ResponseWrapper.class);

        List<ResponseWrapper> result = response.collectList().block();

        //System.out.println("Response : " + eventList);
        String results = result.toString();
        return results;
    }
}
