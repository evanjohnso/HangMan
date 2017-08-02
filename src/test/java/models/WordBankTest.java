package models;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Guest on 8/2/17.
 */
public class WordBankTest {
    @Test
    public void newWordBank_instantiatesCorrectly() {
        WordBank testBank = new WordBank();
        assertEquals(true, testBank instanceof WordBank);
    }

    @Test
    public void newWordBank_givesRandomWord() {
        WordBank testBank = new WordBank();
        assertEquals("", testBank.randomWord());
   }
}