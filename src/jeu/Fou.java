package jeu;

import java.awt.Color;

public class Fou extends Piece {

    public Fou(Color couleur) {
        super('F', couleur);
    }

    public boolean isValid(int x1, int y1, int x2, int y2, Piece[][] plateau) {
        return false;
    }

}
