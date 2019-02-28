package jeu;

import java.awt.Color;

/**
 * Roi
 */
public class Roi extends Piece {

    /**
     * Constructeur par défaut
     * @param couleur instance de Color
     */
    public Roi(Color couleur) {
        super('R', couleur);
    }

    /**
     * Vérification du mouvement du Roi avec les coordonnées passées et futures
     *
     * @param x1 origine x
     * @param y1 origine y
     * @param x2 destination x
     * @param y2 destination y
     * @param plateau plateau
     * @return true ou false
     */
    public boolean isValid(int x1, int y1, int x2, int y2, Piece[][] plateau) {

        boolean valid = false;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }

                int cx = x1 + i;
                int cy = y1 + j;

                if ((cx < 0 || cx > 7) || (cy < 0 || cy > 7)) {
                    continue;
                }

                if (x2 == cx && y2 == cy) {
                    valid = true;
                }

            }
        }

        return valid;
    }

}
