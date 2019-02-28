package jeu;

import java.awt.*;

public class Pion extends Piece {

    public Pion(Color couleur) {
        super('P', couleur);
    }

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
