package com.tietoevry.serverskeletonjava.dto;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

import com.tietoevry.serverskeletonjava.dto.ResponseWrapper;

public class ResponseWrapperDeserializer extends StdDeserializer<ResponseWrapper> {

    public ResponseWrapperDeserializer() {
        this(null);
    }

    public ResponseWrapperDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public ResponseWrapper deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        JsonNode node = jp.getCodec().readTree(jp);

        ResponseWrapper responseWrapper = new ResponseWrapper();
        responseWrapper.setId(node.get("id").asText());
        System.out.println("Kommer hit");
        responseWrapper.setEvent(node.get("event").asText());
        

        JsonNode dataNode = node.get("data");
        //ObjectMapper mapper = (ObjectMapper) jp.getCodec();
        EventDTO eventDTO = new EventDTODeserializer().deserialize(dataNode.traverse(jp.getCodec()), ctxt);
        responseWrapper.setData(eventDTO);


        return responseWrapper;
    }
}
