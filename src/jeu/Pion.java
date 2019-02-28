package jeu;

import java.awt.*;

/**
 * Pion
 */
public class Pion extends Piece {

    /**
     * Constructeur par défaut
     * @param couleur instance de Color
     */
    public Pion(Color couleur) {
        super('P', couleur);
    }

    /**
     * Vérification de la validité
     * @param x1 origine x
     * @param y1 origine y
     * @param x2 destination x
     * @param y2 destination y
     * @param plateau plateau
     * @return vrai ou faux
     */
    public boolean isValid(int x1, int y1, int x2, int y2, Piece[][] plateau) {
        if ((y1 != 1 && y2 > (y1 + 1)) || (y1 == 1 && y2 > (y1 + 2))) {
            return false;
        }

        if (y2 == y1 + 2 && x2 != x1) {
            return false;
        }

        if (y2 <= y1) {
            return false;
        }

        if (y2 == y1 + 1 && (x2 == x1 - 1 || x2 == x1 + 1)) {
            Piece target = plateau[x2][y2];

            if (target == null) {
                return false;
            } else if (target.getCouleur() == this.couleur) {
                return false;
            }
        } else if (x2 > x1 + 1 || x2 < x1 - 1) {
            return false;
        }

        return true;
    }

}
