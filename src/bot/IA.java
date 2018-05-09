package bot;

/**
 * IA est la classe représentant le joueur bot du jeu.
 * Elle est caractérisée par un nom fixe.
 * <p>
 *     L'IA calcule un coup aléatoire à jouer au prochain tour.
 * </p>
 */
public class IA {

    /**
     * Le nom de l'IA.
     *
     * @see IA#getName()
     */
    private String name = "le bot";

    /**
     * Retourne le nom de l'IA.
     * @return le nom de l'IA.
     */
    public String getName() {
        return name;
    }

    /**
     * L'IA joue aléatoirement.
     * @param board
     *          Tableau d'allumettes du plateau.
     * @return
     *          Mouvement joué par l'IA.
     */
    public static Move botMove (int [] board) {
        System.out.println ("Au tour du bot de jouer : ");
        int ligne_move;
        int nb_allumettes;
        do {
            ligne_move = (int) (Math.random()*board.length+1);
            nb_allumettes = (int) (Math.random()*3+1);
        } while (board [ligne_move-1] == 0 || board [ligne_move-1] < nb_allumettes);
        System.out.println ("Ligne : " + ligne_move + "\nNombre d'allumettes : " + nb_allumettes);
        return new Move (ligne_move, nb_allumettes);
    }
}
