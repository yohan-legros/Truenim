package smartbot;

/**
 * <b>Board est la classe représentant le plateau de jeu.</b>
 * Elle réunit les differents éléments d'un jeu : les joueurs et l'état courant.
 * <p>
 *     À partir de cette classe, on peut savoir quel joueur doit jouer son tour.
 *     Elle calcule le nombre d'allumettes restants sur le plateau, applique le mouvement du joueur et désigne le gagnant.
 * </p>
 */
public class Board {

    /**
     * Désigne le joueur qui doit jouer son tour.
     * @param tours
     *              Le nombre de tours de jeu en cours.
     * @param player
     *              Le joueur humain.
     * @param bot
     *              Le joueur IA.
     *
     * @return Le nom du joueur qui doit jouer.
     */
    public static String auTourDe (int tours, HumanPlayer player, IA bot) {
        if (tours % 2 == 0) {
            return player.getName();
        } else {
            return bot.getName();
        }
    }

    /**
     * Applique le mouvement du joueur sur le plateau et modifie l'ensemble des configurations.
     * @param move
     *              Mouvement effectué par le joueur ou l'IA.
     * @param board
     *              Tableau contenant les allumettes du plateau.
     * @param configuration
     *              Ensemble des états accessibles pour l'IA.
     *
     * @see GameState#board
     * @see Config#tete
     */
    public static void applyMove (Move move, int [] board, Config configuration) {
        board [move.getLigne_move()-1] -= move.getNb_allumettes();
        configuration.supprNoeud(total_allumettes(board));
    }

    /**
     * Désigne le gagnant de la partie.
     * @param tours
     *              Le nombre de tours de jeu en cours.
     * @param player1
     *              Le nom du premier joueur.
     * @param player2
     *              Le nom du deuxième joueur.
     *
     * @return Le nom du gagnant.
     */
    public static String winner (int tours, String player1, String player2) {
        if (tours % 2 == 0)
            return player1;
        else
            return player2;
    }

    /**
     * Calcule le nombre total d'allumettes présents sur le plateau.
     * @param board
     *              Tableau contenant les allumettes du plateau.
     *
     * @return Le nombre total d'allumettes présents sur le plateau.
     *
     * @see GameState#board
     */
    public static int total_allumettes (int [] board) {
        int total = 0;
        for (int i = 0; i < board.length; i++) {
            total += board[i];
        }
        return total;
    }
}