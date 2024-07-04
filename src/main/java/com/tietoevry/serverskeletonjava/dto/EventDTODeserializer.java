package com.tietoevry.serverskeletonjava.dto;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

import com.tietoevry.serverskeletonjava.dto.EventDTO;
import com.tietoevry.serverskeletonjava.dto.PersonDTO;

public class EventDTODeserializer extends StdDeserializer<EventDTO> {

    public EventDTODeserializer() {
        this(null);
    }

    public EventDTODeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public EventDTO deserialize(JsonParser jp, DeserializationContext ctxt) 
      throws IOException, JsonProcessingException {
        JsonNode node = jp.getCodec().readTree(jp);

        EventDTO eventDTO = new EventDTO();
        eventDTO.setSocSecNum(node.get("socSecNum").asText());
        eventDTO.setEventType(node.get("eventType").asText());
        eventDTO.setSequenceNumber(node.get("sequenceNumber").asText());
        eventDTO.setTimestamp(node.get("timestamp").asText());

        // Deserialize value field
        JsonNode valueNode = node.get("value");
        ObjectMapper mapper = (ObjectMapper) jp.getCodec();
        if (valueNode.isTextual()) {
            eventDTO.setValue(valueNode.asText());
        } else {
            System.out.println("Her og tuller");
            eventDTO.setValue(mapper.treeToValue(valueNode, PersonDTO.class));
        }

        return eventDTO;
    }
}
