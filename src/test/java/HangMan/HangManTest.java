package HangMan;

import models.HangMan;
import org.junit.Test;

import static org.junit.Assert.*;

public class HangManTest {
    @Test
    public void newHangMan_instantiatesCorrectly() {
        HangMan testHangMan = new HangMan("hello");
        assertEquals(true, testHangMan instanceof HangMan);
    }
    @Test
    public void newHangMan_getGameWordWorks() {
        HangMan testHangMan = new HangMan("hello");
        assertEquals("hello", testHangMan.getGameWord());
    }
    @Test
    public void newHangMan_doesContain() {
        HangMan testHangMan = new HangMan("hello");
        assertEquals(true, testHangMan.containsLetter("o"));
    }
    @Test
    public void newHangMan_createGameWord() {
        HangMan testHangMan = new HangMan("hel");
        assertEquals("___", testHangMan.getWordInProgress() );
    }
    @Test
    public void newHangMan_changeLetters() {
        HangMan testHangMan = new HangMan("helloo");
        testHangMan.changeLetters("l");
        testHangMan.changeLetters("l");
        assertEquals("__ll__", testHangMan.getWordAsArray() );
    }
}