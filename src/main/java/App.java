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
                System.out.println(thisGame.getWordAsArray());
                System.out.println("Guess a letter!");
                String input = bufferedReader.readLine().toLowerCase();
                thisGame.changeLetters(input);
                System.out.println(thisGame.getWordAsArray());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
