package models;

/**
 * Created by Guest on 8/2/17.
 */
public class HangMan {
    private String gameWord;
    private String wordInProgress;
    private char[] wordAsArray;

    public HangMan(String gameWord) {
        this.gameWord = gameWord;
        wordInProgress = gameWord.replaceAll( "[a-zA-Z]","_" );
        wordAsArray = wordInProgress.toCharArray();
    }

    public boolean containsLetter(String input) {
        boolean doesContain = gameWord.contains(input);
        return doesContain;
    }
    //We don't actually need this
    public int findLocation(char input) {
        int location = gameWord.indexOf(input);
        wordAsArray[location] = input;
        return location;
    }
    public void changeLetters(String input) {
        char inputChar = input.charAt(0);
        for (int i = 0; i < gameWord.length(); i++) {
            if (gameWord.charAt(i) == inputChar) {
                wordAsArray[i] = inputChar;
            }
        }
    }
    //GETTERS
    public String getGameWord() {
        return gameWord;
    }
    public String getWordInProgress() {
        return wordInProgress;
    }
    public String getWordAsArray() {
        String output = new String(wordAsArray);
        return output;
    }
}
