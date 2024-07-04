package com.tietoevry.serverskeletonjava.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @Data er en Lombok-annotation som genererer boilerplate-kode for gettere, settere, equals, hashCode og toString.
 * Du kan oppnå det samme med @Getter, @Setter, @ToString , @EqualsAndHashCode og @RequiredArgsConstructor annotasjoner.
 */

@Data
public class PersonDTO {
    @JsonProperty("name")
    private String name;
    @JsonProperty("socSecNum")
    private String socSecNum;
    @JsonProperty("address")
    private String address;
    @JsonProperty("email")
    private String email;
    @JsonProperty("phone")
    private String phone;
}
