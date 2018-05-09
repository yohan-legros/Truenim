package smartbot;

/**
 * IA est la classe représentant le joueur bot du jeu.
 * Elle est caractérisée par un nom fixe.
 * <p>
 *     L'IA calcule le prochain coup qu'elle doit jouer en fonction des configurations et de la répartition des
 *     allumettes sur les lignes du plateau.
 * </p>
 *
 * @see Config
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
     * L'IA détermine le mouvement qu'elle va effectuer.
     * @param board
     *          Tableau d'allumettes du plateau.
     * @param c
     *          Ensemble des états accessibles du jeu pour l'IA.
     * @return
     *          Mouvement joué par l'IA.
     *
     * @see Config
     * @see Noeud
     * @see Board#total_allumettes(int[])
     * @see IA#findLine(int[], int)
     */
    public static Move botMove (int [] board, Config c) {
        System.out.println ("Au tour du bot de jouer!");
        int nb_allumettes = 1;
        Config copie = c;
        while (copie.getTete().isNoyau() == false) {
            copie.setTete(copie.getTete().getSuivant());
        }
        if (copie.getTete().getElement()+3 >= Board.total_allumettes(board) && Board.total_allumettes(board)-copie.getTete().getElement() != 0) {
            nb_allumettes = Board.total_allumettes(board)-copie.getTete().getElement();
            if (findRow(board, nb_allumettes) == 0) {
                nb_allumettes = 1;
            }
        }
        System.out.println ("Ligne : " + findRow(board, nb_allumettes) + "\nNombre d'allumettes : " + nb_allumettes);
        return new Move (findRow(board, nb_allumettes), nb_allumettes);
    }

    /**
     * L'IA trouve la ligne sur laquelle elle doit enlever les allumettes.
     * @param board
     *              Tableau d'allumettes du plateau.
     * @param nb_allumettes
     *              Nombre d'allumettes que l'IA doit enlever.
     *
     * @return La ligne sur laquelle l'IA joue, sinon 0 si elle ne trouve pas.
     */
    public static int findRow (int [] board, int nb_allumettes) {
        for (int i = 0; i < board.length; i++) {
            if (board [i] >= nb_allumettes) {
                return i+1;
            }
        }
        return 0;
    }
}
