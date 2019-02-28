package tests;

import jeu.*;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class PionTest {

    @Test
    public final void isValidTest() {
        Piece[][] plateau = new Piece[8][8];

        Pion pion = new Pion(Color.WHITE);
        Tour tour = new Tour(Color.BLACK);

        plateau[1][1] = pion;
        plateau[2][2] = tour;
        plateau[2][3] = tour;

        assertTrue(pion.isValid(1, 1, 2, 2, plateau));
        assertFalse(pion.isValid(1, 1, 2, 3, plateau));
        assertFalse(pion.isValid(2, 2, 2, 4, plateau));
        assertFalse(pion.isValid(1, 1, 2, 3, plateau));
    }
}
