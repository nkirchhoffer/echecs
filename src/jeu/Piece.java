package jeu;

import java.awt.Color;

/**
 * Implémentation des pièces
 * Class utilisée comme "trait"
 */
public class Piece {

    private char nom;
    protected Color couleur;

    public Piece(char nom, Color couleur) {
        this.nom = nom;
        this.couleur = couleur;
    }

    public String toString() {
        return this.nom + (this.couleur.equals(Color.WHITE) ? "b" : "n");
    }

    public Color getCouleur() { return this.couleur; }

    public boolean isValid(int x1, int y1, int x2, int y2, Piece[][] plateau){ return true; }

}
