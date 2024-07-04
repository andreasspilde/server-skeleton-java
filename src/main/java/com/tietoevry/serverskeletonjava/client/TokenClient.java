package com.tietoevry.serverskeletonjava.client;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;



public class TokenClient {


    public String getToken() {
           
            //Method for when GET was the method with a body
            /*WebClient webClient = WebClient.create("http://localhost:8080");


            Mono<ClientResponse> resultMono =  webClient.method(HttpMethod.GET)
                .uri("/token")
                .contentType(APPLICATION_FORM_URLENCODED)
                .body(BodyInserters.fromFormData("username", "Donald")
                    .with("password","Fantonald"))
                .exchange();
            
            ClientResponse response = resultMono.block();
            String result = response.bodyToMono(String.class).block();
            System.out.println("Token : " + result);
        */
        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        formData.add("username", "Donald");
        formData.add("password","Fantonald");

        WebClient webClient = WebClient.create("http://localhost:8080");

        Mono<String> resultMono = webClient.post()
            .uri("/token")
            .header("Content-Type", "application/x-www-form-urlencoded")
            .bodyValue(formData)
            .retrieve()
            .bodyToMono(String.class);

        String result = resultMono.block();
        //System.out.println("Token : " + result);
        
        return result;
    }
}
