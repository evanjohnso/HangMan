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
        int guesses = 0;

        String image = "888                                                           \n" +
                "888                                                           \n" +
                "888                                                           \n" +
                "88888b.  8888b. 88888b.  .d88b. 88888b.d88b.  8888b. 88888b.  \n" +
                "888 \"88b    \"88b888 \"88bd88P\"88b888 \"888 \"88b    \"88b888 \"88b \n" +
                "888  888.d888888888  888888  888888  888  888.d888888888  888 \n" +
                "888  888888  888888  888Y88b 888888  888  888888  888888  888 \n" +
                "888  888\"Y888888888  888 \"Y88888888  888  888\"Y888888888  888 \n" +
                "                             888                              \n" +
                "                        Y8b d88P                              \n" +
                "                         \"Y88P\"                               ";

        while (programRunning) {
            try {
                System.out.println("Guess a letter!");
                System.out.println("******************");
                String input = bufferedReader.readLine().toLowerCase();
                if (input.equals(gameWord)) {
                    System.out.println("You win!!!!");
                    System.out.println(gameWord);
                    System.out.println(image);
                    programRunning = false;
                }
                if (!thisGame.containsLetter(input)) {
                    System.out.println("You suck!! Guess again!");
                }

                System.out.println("You have already guessed: " + thisGame.getGuessedLetters());

                if (thisGame.getWordAsArray().equals("finished")) {
                    System.out.println("Congratulations, you won!!! But you still stuck!");
                    System.out.println(image);
                    System.out.println(thisGame.getGameWord());
                    programRunning = false;
                } else {
                    guesses ++;
                    if (guesses < 10) {
                        System.out.println(thisGame.getWordAsArray());
                        System.out.println("Guesses left: " + (10 - guesses));
                    } else {
                        System.out.println("You're out of guesses!");
                        System.out.println(image);
                        programRunning = false;
                    }

                }
                System.out.println("******************");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
