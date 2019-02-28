package jeu;

import java.awt.Color;
import java.io.*;

/**
 * Echiquier
 *
 * @author Nicolas Kirchhoffer
 */
public class Echiquier implements Serializable {

    private Piece[][] plateau;
    private Color tour;

    /**
     * Constructeur par défaut
     */
    public Echiquier() {
        this.plateau = new Piece[8][8];
        this.tour = Color.WHITE;

        this.plateau[0][0] = new Tour(Color.WHITE);
        this.plateau[4][0] = new Roi(Color.WHITE);
        this.plateau[7][0] = new Tour(Color.WHITE);

        this.plateau[0][7] = new Tour(Color.BLACK);
        this.plateau[4][7] = new Roi(Color.BLACK);
        this.plateau[7][7] = new Tour(Color.BLACK);

        for (int i = 0; i < 8; i++) {
            this.plateau[i][1] = new Pion(Color.WHITE);
            this.plateau[i][6] = new Pion(Color.BLACK);
        }
    }

    /**
     * Constructeur utilisant un fichier
     *
     * @param fichier chemin vers le fichier
     */
    public Echiquier(String fichier) {
        try {
            FileReader reader = new FileReader(fichier);
            BufferedReader buffer = new BufferedReader(reader);

            String data = buffer.readLine();

        } catch(FileNotFoundException e) {
            System.out.println("Fichier introuvable : " + e.getMessage());
        } catch(Exception e) {
            System.out.println("Erreur rencontrée : " + e.getMessage());
        }

        this.tour = Color.WHITE;
    }

    /**
     * Constructeur utilisant un plateau prédéfini
     * @param plateau plateau déjà défini
     */
    public Echiquier(Piece[][] plateau) {
        this.plateau = plateau;
        this.tour = Color.WHITE;
    }

    /**
     * Méthode permettant de stocker
     * @param fichier
     */
    public void sauver(String fichier) {
        try {
            FileOutputStream stream = new FileOutputStream(fichier);
            ObjectOutputStream save = new ObjectOutputStream(stream);
            save.writeObject(this);
            save.close();

            System.out.println("Partie sauvegardée dans le fichier " + fichier);
        } catch(Exception e) {
            System.out.println("Erreur rencontrée lors de la sauvegarde : " + e.getMessage());
        }
    }

    /**
     * Calcul et application du mouvement en fonction des coordonnées
     * @param x1 origine x
     * @param y1 origine y
     * @param x2 destination x
     * @param y2 destination y
     * @return vrai si le déplacement est effectué, faux sinon
     */
    public boolean mouvement(int x1, int y1, int x2, int y2) {
        if (x2 < 0 || x2 > 7 || y2 < 0 || y2 > 7) {
            return false;
        }

        Piece target = this.plateau[x2][y2];

        if (target != null) {
            if (target.getCouleur() == this.tour) {
                System.out.println("Pièce de même couleur : " + target.toString());
                return false;
            }
        }

        if (this.plateau[x1][y1] == null) {
            System.out.println("Case vide");
            return false;
        }

        Piece piece = this.plateau[x1][y1];

        if (!piece.isValid(x1, y1, x2, y2, this.plateau)) {
            System.out.println("Déplacement incorrect");
            return false;
        }

        this.plateau[x2][y2] = piece;
        this.plateau[x1][y1] = null;

        this.tour = (this.tour == Color.WHITE) ? Color.BLACK : Color.WHITE;
        return true;

    }

    /**
     * Setter permettant de faciliter les tests unitaires
     *
     * @param x coordonnée x
     * @param y coordonnée y
     * @param piece pièce à insérer sur le plateau
     */
    public void setPiece(int x, int y, Piece piece) {
        this.plateau[x][y] = piece;
    }

    /**
     * Récupérer le plateau
     *
     * @return plateau
     */
    public Piece[][] getPlateau() {
        return this.plateau;
    }

    /**
     * Affiche le plateau en représenation textuelle
     */
    public void affichage() {
        String current = this.tour == Color.WHITE ? "Blancs" : "Noirs";

        System.out.println("Tour actuel : " + current);

        for (Piece[] ligne : this.plateau) {
            for (int i = 0; i < this.plateau.length * 3; i++) {
                System.out.print('-');
            }

            System.out.print("- \n");

            for (Piece piece : ligne) {
                System.out.print("|");

                if (piece == null) {
                    System.out.print("  ");
                } else {
                    System.out.print(piece.toString());
                }
            }

            System.out.print("| \n");
        }
    }


}
