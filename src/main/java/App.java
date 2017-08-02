import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;
import models.HangMan;
import models.WordBank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Guest on 8/2/17.
 */
public class App {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        boolean programRunning = true;

        WordBank rando = new WordBank();
        String gameWord = rando.randomWord();

        HangMan thisGame = new HangMan(gameWord);
        System.out.println("Hey, lets play Hangman!!!!");
        System.out.println("Here is your word!");

        while (programRunning) {
            try {
                System.out.println("Guess a letter!");
                System.out.println("******************");
                String input = bufferedReader.readLine().toLowerCase();
                if (thisGame.containsLetter(input)) {
                    thisGame.changeLetters(input);
                } else {
                    System.out.println("You suck!! Guess again!");
                }
                System.out.println("You have already guessed: " + thisGame.getGuessedLetters());

                if (thisGame.getWordAsArray().equals("finished")) {
                    System.out.println("Congratulations, you won!!! But you still stuck!");
                    System.out.println(thisGame.getGameWord());
                    programRunning = false;
                } else {
                    System.out.println(thisGame.getWordAsArray());
                }

                System.out.println("******************");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
