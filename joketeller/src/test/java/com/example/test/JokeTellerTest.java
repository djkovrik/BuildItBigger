package com.example.test;

import com.example.JokeTeller;

import org.junit.Test;

public class JokeTellerTest {

    @Test
    public void test() {

        int iterations = 100;

        JokeTeller jokeTeller = new JokeTeller();

        for (int i = 0; i < iterations; i++) {
            String joke = jokeTeller.getJoke();
            assert joke.length() != 0;
        }
    }
}
