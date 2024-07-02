package com.tietoevry.serverskeletonjava.client;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TokenClientTest {
    @Test
    void testGetToken() {
        var client = new TokenClient();
        String result  = client.getToken();
        Assertions.assertNotEquals("", result);
    }
}
