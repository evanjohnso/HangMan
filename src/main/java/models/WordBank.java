package models;

import java.util.Random;

/**
 * Created by Guest on 8/2/17.
 */
public class WordBank {

    Random random = new Random();

    private String[] easyBank = {"homies","pickles","juice","oranges","grapes"};
    private String[] mediumBank = {"designer","university","foolish","football","sleeve"};
    private String[] hardBank = {"superfluous","extraordinary","regurgitate","pretentious","obstinate"};

    public String randomWord(String input) {
        if (input.equals("easy")) {
            return easyBank[random.nextInt(easyBank.length)];
        } else if (input.equals("medium")) {
            return mediumBank[random.nextInt(mediumBank.length)];
        } else if (input.equals("hard")) {
            return hardBank[random.nextInt(hardBank.length)];
        } else return "null";
    }
}
