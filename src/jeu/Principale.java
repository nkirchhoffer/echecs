package jeu;

import java.awt.*;

/**
 * Point d'entrée du projet
 *
 * @author Nicolas Kirchhoffer
 * @version 1.0
 */
public class Principale {

    public static void main(String[] args) {
        System.out.println("running");
        Echiquier echiquier = new Echiquier();

        echiquier.setPiece(6, 2, new Tour(Color.BLACK));
        echiquier.mouvement(4, 1, 3, 2);
        echiquier.affichage();
    }

}
