package human;

import java.util.Scanner;

/**
 * <b>Console est la classe qui permet au joueur d'intéragir avec le programme.</b>
 * <p>
 *     Le joueur peut entrer son nom, choisir la taille du plateau, voir le plateau et effectuer un mouvement.
 *     La console vérifie les mouvements effectués et affiche le gagnant de la partie.
 * </p>
 */
public class Console {
    static Scanner in=new Scanner (System.in);

    /**
     * Le joueur peut entrer son nom.
     * @param i
     * 			Entier qui définit si un joueur est le joueur 1 ou 2.
     * 
     * @return Le nom du joueur.
     *      
     * @see HumanPlayer
     * @see Console#enterName()
     */
    public static String getPlayerName (int i) {
        HumanPlayer player = new HumanPlayer();
        System.out.print ("Joueur " + i + ", veuillez entrer votre nom : ");
        player.setName(Console.enterName());
        return player.getName();
    }

    /**
     * Le joueur choisit la taille du plateau.
     * @return Le nombre de lignes du plateau.
     */
    public static int getSize () {
        System.out.print ("\nSaisir le nombre de lignes du plateau (3 minimum) : ");
        int lignes_board = in.nextInt();
        while (lignes_board < 3) {
            System.out.print ("Erreur! Veuillez saisir un nombre de lignes valide (3 minimum) : ");
            lignes_board = in.nextInt();
        }
        return lignes_board;
    }

    /**
     * Permet au joueur d'entrer son nom.
     * @return Le nom du joueur.
     *
     * @see Console#getPlayerName(int)
     */
    public static String enterName () {
        String name;
        name = in.nextLine();
        return name;
    }

    /**
     * Affiche le plateau en jeu.
     * @param board
     *              Tableau graphique contenant les allumettes du plateau.
     */
    public static void showBoard (String [] stick) {
        System.out.println ("\nPlateau :");
        for (int i = 0 ; i < stick.length ; i++) {
            System.out.println (stick[i]);
        }
        System.out.println ();
    }

    /**
     * Le joueur entre le mouvement qu'il veut effectuer.
     * @param name
     *              Le nom du joueur.
     *
     * @return Le mouvement du joueur.
     *
     * @see Move
     */
    public static Move getMove (String name) {
        System.out.println (name + ", veuillez saisir la ligne puis le nombre d'allumettes à retirer : ");
        int ligne_move = in.nextInt();
        int nb_allumettes = in.nextInt();
        Move move = new Move(ligne_move, nb_allumettes);
        return move;
    }

    /**
     * Vérifie si le mouvement effectué par le joueur est valide.
     * @param move
     *          Mouvement effectué par le joueur.
     * @param board
     *          Tableau contenant les allumettes du plateau.
     *
     * @return True si invalide, sinon false.
     *
     * @see Move
     * @see GameState
     */
    public static boolean isInvalidMove (Move move, int [] board) {

        if (move.getLigne_move() < 1 || move.getLigne_move() > board.length) {
            System.out.println("Erreur : la ligne n'existe pas!");
            return true;
        }
        if (move.getNb_allumettes() < 1 || move.getNb_allumettes() > 3) {
            System.out.println("Erreur : le nombre d'allumettes est invalide!");
            return true;
        }
        if (board[move.getLigne_move()-1] < 1) {
            System.out.println("Erreur : la ligne est vide!");
            return true;
        }
        if (board [move.getLigne_move()-1] < move.getNb_allumettes()) {
            System.out.println("Erreur : le nombre d'allumettes choisi est supérieur au nombre d'allumettes restants sur la ligne!");
            return true;
        }
        return false;
    }

    /**
     * Recommence le mouvement si le mouvement précédent est invalide.
     * @param move
     *              Mouvement précédent du joueur.
     * @param board
     *              Tableau contenant les allumettes du plateau.
     * @param playing_player
     *              Joueur qui joue actuellement.
     *
     * @return Le nouveau mouvement du joueur.
     *
     * @see Move
     * @see GameState
     */
    public static Move restartMove (Move move, int [] board, String playing_player) {
        while (Console.isInvalidMove (move, board)) {
            move = Console.getMove (playing_player);
        }
        return move;
    }

    /**
     * Affiche le gagnant de la partie.
     * @param name
     *              Nom du gagnant.
     */
    public static void showWinner (String name) {
        System.out.println ("\nLe gagnant est " +  name + ". Bravo!");
    }
}
