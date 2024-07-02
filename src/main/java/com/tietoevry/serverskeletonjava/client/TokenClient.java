package com.tietoevry.serverskeletonjava.client;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestClient;

public class TokenClient {

    public String getToken(){
        /*RestTemplate template = new RestTemplate();
        String url = "http://localhost:8080/token";
        HttpHeader header = new HttpHeaders();
        String response = template.getForObject(url, String.class);
        System.out.println("Test");
    

        
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .header("Content-Type", "application/x-www-form-urlencoded")
            .POST(HttpRequest.BodyPublishers.ofString("username=Donald&password=Fantonald"))
            .build();
        String resposne = request.
        System.out.println(response);
        */
        Map<String, String> formData = new HashMap<>();
        formData.put("username", "Donald");
        formData.put("password", "Fantonald");

        RestClient restClient = RestClient.create();

        /*String result = restClient.get()
            .uri("localhost:8080/token")
            .retrieve()
            .body(String.class);*/
        String result = restClient.method(HttpMethod.GET).body(formData).toString();
        System.out.println(result);
        return result;
    }
}
