package models;

/**
 * Created by Guest on 8/2/17.
 */
public class HangMan {

    private String gameWord;
    private char[] guessedLetters;

    public HangMan(String gameWord) {
        this.gameWord = gameWord;

    }
    public boolean containsLetter(String input) {
        boolean doesContain = gameWord.contains(input);
        return doesContain;
    }

    public String getGameWord() {
        return gameWord;
    }
}
