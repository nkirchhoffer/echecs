package tests;

import jeu.*;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class RoiTest {

    @Test
    public final void isValidTest() {
        Echiquier plateau = new Echiquier();

        Roi roi = new Roi(Color.WHITE);

        assertTrue(roi.isValid(0, 0, 1, 1, plateau.getPlateau()));
        assertFalse(roi.isValid(0, 0, 1, 2, plateau.getPlateau()));
        assertFalse(roi.isValid(0, 0, -1, -1, plateau.getPlateau()));
    }

}
