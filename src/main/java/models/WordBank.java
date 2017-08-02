package models;

import java.util.Random;

/**
 * Created by Guest on 8/2/17.
 */
public class WordBank {

    Random random = new Random();

    String[] bank = {"homies","pickles","juice","oranges","grapes"};

    public String randomWord() {
        String randomWord = bank[random.nextInt(5)];
        return randomWord;
}
}
