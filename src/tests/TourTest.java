package tests;

import jeu.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.*;

public class TourTest {

    @Test
    public final void testIsValid() {
        Tour tour = new Tour(Color.WHITE);
        Piece[][] plateau = new Piece[8][8];

        // Tests des déplacements linéaires UNIQUEMENT
        // Pas de diagonale autorisée.
        assertTrue(tour.isValid(0, 0, 0, 7, plateau));
        assertTrue(tour.isValid(0, 1, 7, 1, plateau));
        assertFalse(tour.isValid(0, 1, 1, 7, plateau));

        plateau[0][3] = tour;
        plateau[3][0] = tour;

        // Tests des déplacements avec une pièce sur la case (0, 3)
        assertFalse(tour.isValid(0, 0, 0, 7, plateau));
        assertFalse(tour.isValid(0, 0, 7, 0, plateau));
    }

    @Test
    public final void testToString() {
        Tour tour = new Tour(Color.WHITE);

        assertEquals("Tb", tour.toString());

        tour = new Tour(Color.BLACK);

        assertEquals("Tn", tour.toString());
    }

}
