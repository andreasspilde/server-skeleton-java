package com.tietoevry.serverskeletonjava.client;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EventClientTest {
    @Test
    void getEvents(){
        var getEvents = new EventClient();
        String events = getEvents.getEvents();
        System.out.println("Test : " + events);
        Assertions.assertNotEquals("", events);
    }
    @Test
    void getEventWithNumber(){
        var getEvent = new EventClient();
        String event = getEvent.getEvent(21);
        System.out.println("Test2 : " + event);
        Assertions.assertNotEquals("", event);
    }
    @Test
    void getEventsWithNmbr(){
        var getEvent = new EventClient();
        String event = getEvent.getEventsFrom(26);
        System.out.println("test3 : " + event);
        Assertions.assertNotEquals("", event);
    }
}
