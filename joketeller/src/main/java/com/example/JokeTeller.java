package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class JokeTeller {

    private static final List<String> jokes = new ArrayList<>();
    private static final Random rand = new Random();

    static {
        jokes.add("When Chuck Norris enters the room, even the chairs are standing up.");
        jokes.add("Chuck Norris doesn't ever call the wrong number. You just answer the wrong phone.");
        jokes.add("Chuck Norris tried to lose weight. But Chuck Norris NEVER loses.");
        jokes.add("When Chuck Norris walks across the meadow, he doesn’t smell the flowers. The flowers smell him.");
        jokes.add("Chuck Norris has been to Mars already; he’s the reason there are no signs of life.");
        jokes.add("How many push-ups did Chuck Norris do? He did them all.");
        jokes.add("Chuck Norris once won a tennis match against a wall.");
        jokes.add("Chuck Norris was once bitten by a black mamba. After three days of agony, the black mamba died.");
        jokes.add("If you seek a list of Chuck Norris' enemies, try checking the extinct species list.");
        jokes.add("Chuck Norris donates blood every month. Just not his own.");
    }

    public String getJoke() {
        int index = rand.nextInt(jokes.size());
        return jokes.get(index);
    }
}
