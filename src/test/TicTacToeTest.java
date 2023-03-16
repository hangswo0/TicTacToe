package test;

import main.TicTacToe;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TicTacToeTest {

    @Test
    public void testAddTic() {
        TicTacToe field = new TicTacToe(3);
        field.addTic(0, 0);
        field.addTic(1, 2);
        field.addTic(2, 0);
        assertEquals("x", field.getState(0, 0));
        assertEquals("x", field.getState(1, 2));
        assertEquals("x", field.getState(2, 0));
        assertEquals("-", field.getState(1, 1));
    }

    @Test
    public void testAddTac() {
        TicTacToe field = new TicTacToe(3);
        field.addTac(2, 1);
        field.addTac(0, 1);
        field.addTac(2, 2);
        assertEquals("o", field.getState(2, 1));
        assertEquals("o", field.getState(0, 1));
        assertEquals("o", field.getState(2, 2));
        assertEquals("-", field.getState(0, 0));
    }

    @Test
    public void testRemoveCell() {
        TicTacToe field = new TicTacToe(3);
        field.addTac(2, 1);
        field.addTic(1, 2);
        field.addTac(0, 1);
        field.removeCell(2, 1);
        field.removeCell(1, 2);
        field.removeCell(0, 1);
        assertEquals("-", field.getState(2, 1));
        assertEquals("-", field.getState(1, 2));
        assertEquals("-", field.getState(0, 1));
    }

    @Test
    public void longestSequenceTic() {
        TicTacToe field = new TicTacToe(3);
        field.addTic(0, 0);
        field.addTic(0, 2);
        field.addTic(1, 0);
        field.addTic(2, 1);
        field.addTic(2, 2);
        field.addTac(0, 1);
        field.addTac(1, 1);
        field.addTac(1, 2);
        field.addTac(2, 0);
        assertEquals(2, field.longestSequenceTic());
    }

    @Test
    public void longestSequenceTac() {
        TicTacToe field = new TicTacToe(3);
        field.addTic(0, 0);
        field.addTic(0, 1);
        field.addTic(2, 1);
        field.addTac(1, 1);
        field.addTac(0, 2);
        field.addTac(2, 0);
        assertEquals(3, field.longestSequenceTac());
    }
}
