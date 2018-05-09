package human;

/**
 * HumanPlayer est la classe représentant le joueur.
 * Elle est caractérisée par un nom.
 */
public class HumanPlayer {

    /**
     * Représente le nom du joueur.
     *
     * @see HumanPlayer#HumanPlayer()
     * @see HumanPlayer#HumanPlayer(String)
     * @see HumanPlayer#getName()
     * @see HumanPlayer#setName(String)
     */
    private String name;

    /**
     * Constructeur HumanPlayer.
     * À la construction d'un objet HumanPlayer, le nom est à "null".
     */
    public HumanPlayer() {
        this.name = null;
    }

    /**
     * Constructeur HumanPlayer.
     * À la construction d'un objet HumanPlayer, le nom est initialisé.
     * @param name
     *          Nouveau nom du joueur.
     */
    public HumanPlayer(String name) {
        this.name = name;
    }

    /**
     * Retourne le nom du joueur.
     * @return le nom du joueur.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Modifie le nom du joueur.
     * @param name
     *          Nouveau nom du joueur.
     */
    public void setName(String name) {
        this.name = name;
    }
}
