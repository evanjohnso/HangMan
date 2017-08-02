package models;

/**
 * Created by Guest on 8/2/17.
 */
public class HangMan {

    private String gameWord;
    private String wordInProgress;

    private char[] guessedLetters;

    public HangMan(String gameWord) {
        this.gameWord = gameWord;
        wordInProgress = gameWord.replaceAll( "[a-zA-Z]","_" );
    }
    public boolean containsLetter(String input) {
        boolean doesContain = gameWord.contains(input);
        return doesContain;
    }

    public int findLocation(String input) {
        int location = gameWord.indexOf(input);
        return location;
    }

    public String getGameWord() {
        return gameWord;
    }
    public String getWordInProgress() {
        return wordInProgress;
    }
}
