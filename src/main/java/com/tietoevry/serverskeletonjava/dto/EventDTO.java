package com.tietoevry.serverskeletonjava.dto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @Data er en Lombok-annotation som genererer boilerplate-kode for gettere, settere, equals, hashCode og toString.
 * Du kan oppnå det samme med @Getter, @Setter, @ToString , @EqualsAndHashCode og @RequiredArgsConstructor annotasjoner.
 *
 * https://projectlombok.org/features/Data
 */

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
