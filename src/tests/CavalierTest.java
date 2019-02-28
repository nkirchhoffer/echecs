package tests;

import jeu.*;
import org.junit.jupiter.api.Test;

import java.awt.Color;

import static org.junit.jupiter.api.Assertions.*;

public class CavalierTest {

    @Test
    public final void testIsValid() {
        Cavalier cavalier = new Cavalier(Color.WHITE);
        Piece[][] plateau = new Piece[8][8];

        assertTrue(cavalier.isValid(0, 0, 1, 2, plateau));
        assertTrue(cavalier.isValid(0, 0, 2, 1, plateau));
        assertFalse(cavalier.isValid(0, 0, 1, 1, plateau));
        assertFalse(cavalier.isValid(0, 0, 2, 2, plateau));
        assertTrue(cavalier.isValid(4, 5, 6, 6, plateau));
    }

    @Test
    public final void testToString() {
        Cavalier cavalier = new Cavalier(Color.WHITE);
        Cavalier cavalier2 = new Cavalier(Color.BLACK);

        assertEquals(cavalier.toString(), "Cb");
        assertEquals(cavalier2.toString(), "Cn");
    }

}
