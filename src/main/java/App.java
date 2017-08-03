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
        /* Create new random word */
        WordBank rando = new WordBank();

        System.out.println("Hey, lets play Hangman!!!!");

        int guesses = 0;
        int tries;

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
                System.out.println("Easy, Medium, or Hard?");
                String difficulty = bufferedReader.readLine().toLowerCase();
                if ("easy".equals(difficulty) || "medium".equals(difficulty) || "hard".equals(difficulty)) {
                    //if valid input create game
                    //Game works just fine if you create using valid inputs. having issues with
                    //the while loops starting over at the proper time
                    //also want a better choice of how many tries the user gets than just +3 word length
                    //issue is be with the 'break' word and program running = false;
                    String gameWord = rando.randomWord(difficulty);
                    tries = gameWord.length() + 3;
                    HangMan thisGame = new HangMan(gameWord);

                    while (guesses < tries) {
                        System.out.println("Guess a letter!");
                        String input = bufferedReader.readLine().toLowerCase();
                        System.out.println(" ");

                        //If user guesses word, game is over
                        if (input.equals(gameWord)) {
                            System.out.println("You win!!!!");
                            System.out.println(image);
                            programRunning = false;
                            break;
                        } else if (!thisGame.containsLetter(input)) {
                            System.out.println("Guess again!");
                        }


                        if (thisGame.getWordAsArray().equals("finished")) {
                            System.out.println("Congratulations, you won!!!");
                            System.out.println(image);
                            programRunning = false;
                            System.out.println("Play again? 'Y' or 'N'");
                            String again = bufferedReader.readLine().toUpperCase();
                            if ("Y".equals(again)) {
                                programRunning = true;
                            } else {
                                System.out.println("See ya later!");
                            }
                        } else {
                            guesses++;
                            if (guesses < tries) {
                                System.out.println(thisGame.getWordAsArray());
                                System.out.println("Letters: " + thisGame.getGuessedLetters());
                                System.out.println("Guesses left: " + (tries - guesses));
                            } else {
                                System.out.println("You're out of guesses!");
                                System.out.println("The word was: " + gameWord);
                                programRunning = false;
                            }
                        }
                        System.out.println(" ");
                    }
                } else {
                    System.out.println("Enter a valid input");
                    programRunning = false;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
