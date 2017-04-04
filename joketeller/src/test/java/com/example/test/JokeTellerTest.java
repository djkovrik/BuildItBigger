package com.example.test;

import com.example.JokeTeller;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.Matchers.not;

public class JokeTellerTest {

    @Test
    public void test() {

        int iterations = 100;

        JokeTeller jokeTeller = new JokeTeller();

        for (int i = 0; i < iterations; i++) {
            String joke = jokeTeller.getJoke();
            assertThat(joke, not(isEmptyOrNullString()));
        }
    }
}
