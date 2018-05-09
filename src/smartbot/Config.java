package smartbot;

/**
 * <b>Config est la classe représentant l'ensemble des états accessibles de jeu pour l'IA.</b>
 * Elle est caractérisée par une liste.
 * <p>
 * Elle initialise et modifie l'ensemble des configurations possibles.
 * </p>
 */
public class Config {

    /**
     * Représente la tête de la liste.
     *
     * @see Config#getTete()
     * @see Config#setTete(Noeud)
     * @see Config#Config()
     */
    private Noeud tete;

    /**
     * Constructeur Config.
     * À la construction d'un objet Config, la tête est à "null" donc la liste est vide.
     *
     * @see Config#tete
     */
    public Config () {
        tete = null;
    }

    /**
     * Retourne la tête de la liste.
     * @return Le premier élément de la liste.
     */
    public Noeud getTete() {
        return tete;
    }

    /**
     * Modifie la tête de la liste.
     * @param tete
     *              Le nouveau noeud à mettre en tête.
     *
     * @see Noeud
     */
    public void setTete(Noeud tete) {
        this.tete = tete;
    }

    /**
     * Remplit la liste de configurations.
     * @param e
     *          Dernier élément du plus grand noeud.
     *
     * @see Noeud
     * @see Config#ajouterEnTete(int)
     */
    public void remplirConfig (int e) {
        int compteur = 1;
        while (compteur <= e) {
            this.ajouterEnTete(compteur);
            compteur++;
        }
    }

    /**
     * Ajoute un nouveau noeud en tête de liste.
     * @param e
     *          Element du noeud à ajouter en tête.
     *
     * @see Noeud
     */
    public void ajouterEnTete (int e) {
        if (e == 1) {
            this.tete = new Noeud (1, true, null);
        } else {
            Noeud n = new Noeud(e, e % 4 == 1, this.tete);
            this.tete = n;
        }
    }

    /**
     * Supprime le ou les noeuds pour lesquelles leur élément est supérieur au nombre total d'allumettes.
     * @param total_allumettes
     *          Nombre total d'allumettes présents sur le plateau.
     *
     * @see Noeud
     */
    public void supprNoeud (int total_allumettes) {
        while (tete.getElement() != total_allumettes && total_allumettes > 0 && tete.getSuivant() != null) {
            tete = tete.suivant;
        }
    }
}

