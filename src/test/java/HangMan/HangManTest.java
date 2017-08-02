package HangMan;

import models.HangMan;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Guest on 8/2/17.
 */
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
    public void newHangMan_findLocations() {
        HangMan testHangMan = new HangMan("hello");
        assertEquals(1, testHangMan.findLocation("e"));
    }
    @Test
    public void newHangMan_findLocationsIfMoreThanOne() {
        HangMan testHangMan = new HangMan("hello");
        assertEquals(1,2, testHangMan.findLocation("l"));
    }
    @Test
    public void newHangMan_createGameWord() {
        HangMan testHangMan = new HangMan("hel");
        assertEquals("___", testHangMan.getWordInProgress() );
    }
}