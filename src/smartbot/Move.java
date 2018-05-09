package smartbot;

/** Move est la classe représentant un coup joué par le joueur.
 * Elle est caractérisée par une ligne et un nombre d'allumettes.
 */
public class Move {

    /**
     * Représente la ligne sur laquelle le joueur va effectuer son coup.
     *
     * @see Move#Move(int, int)
     * @see Move#getLigne_move()
     */
    private int ligne_move;

    /**
     * Représente le nombre d'allumettes que le joueur souhaite retirer.
     * @see Move#Move(int, int)
     * @see Move#getNb_allumettes()
     */
    private int nb_allumettes;

    /**
     * Constructeur Move.
     * À la construction d'un objet Move, la ligne et le nombre d'allumettes sont initialisés.
     * @param ligne_move
     *          Ligne sur laquelle le joueur va jouer.
     * @param nb_allumettes
     *          Nombre d'allumettes à retirer.
     */
    public Move (int ligne_move, int nb_allumettes) {
        this.ligne_move = ligne_move;
        this.nb_allumettes = nb_allumettes;
    }

    /**
     * Retourne la ligne sur laquelle jouer.
     * @return La ligne sur laquelle jouer.
     */
    public int getLigne_move () {
        return ligne_move;
    }

    /**
     * Retourne le nombre d'allumettes du mouvement.
     * @return le nombre d'allumettes à retirer.
     */
    public int getNb_allumettes () {
        return nb_allumettes;
    }

}

