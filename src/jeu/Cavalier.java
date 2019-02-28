package jeu;

import java.awt.Color;

/**
 * Cavalier
 */
public class Cavalier extends Piece {

    /**
     * Constructeur par défaut
     * @param couleur instance de Color
     */
    public Cavalier(Color couleur) {
        super('C', couleur);
    }

    /**
     * Vérification de la validité du déplacement du cavalier
     * Utilise une caractéristique du jeu via Pythagore
     * @param x1 x d'origine de la pièce
     * @param y1 y d'origine de la pièce
     * @param x2 x destination de la pièce
     * @param y2 y destination de la pièce
     * @param plateau plateau de jeu
     * @return true ou false
     */
    public boolean isValid(int x1, int y1, int x2, int y2, Piece[][] plateau) {
        if (Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2) == 5) {
            return true;
        }

        return false;
    }

}
