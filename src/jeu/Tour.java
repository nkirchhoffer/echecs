package jeu;

import java.awt.Color;

/**
 * Tour
 */
public class Tour extends Piece {

    /**
     * Constructeur par défaut
     * @param couleur instance de Color
     */
    public Tour(Color couleur) {
        super('T', couleur);
    }

    /**
     * Vérification de la validité du mouvement de la Tour
     * @param x1 origine x
     * @param y1 origine y
     * @param x2 destination x
     * @param y2 destination y
     * @param plateau plateau
     * @return true ou false
     */
    public boolean isValid(int x1, int y1, int x2, int y2, Piece[][] plateau) {
        if ((x2 != x1) && (y2 != y1)) {
            return false;
        }

        if (x2 > x1) {
            for (int i = x1 + 1; i < x2; i++) {
                if (plateau[i][y1] != null) {
                    return false;
                }
            }
        } else if (x2 < x1) {
            for (int i = x1 - 1; i > x2; i--) {
                if (plateau[i][y1] != null) {
                    return false;
                }
            }
        } else if (y2 > y1) {
            for (int i = y1 + 1; i < y2; i++) {
                if (plateau[x1][i] != null) {
                    return false;
                }
            }
        } else if (y2 < y1) {
            for (int i = y1 - 1; i > y2; i++) {
                if (plateau[x1][i] != null) {
                    return false;
                }
            }
        }

        return true;
    }

}
