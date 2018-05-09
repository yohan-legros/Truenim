package smartbot;

/**
 * Noeud est la classe représentant les différentes configurations du jeu.
 * <p>
 * Elle est caracterisée par trois informations :
 * <ul>
 *     <li>Une valeur représentant un nombre d'allumettes.</li>
 *     <li>Le noeud peut être un noyau ou non.</li>
 *     <li>Elle peut pointer sur un autre noeud.</li>
 * </ul>
 * </p>
 */
public class Noeud {

    /**
     * Représente un nombre d'allumettes.
     *
     * @see Noeud#Noeud(int, boolean, Noeud)
     * @see Noeud#getElement()
     */
    private int element;

    /**
     * Le noeud peut être définit comme un noyau selon la valeur de l'élément.
     *
     * @see Noeud#Noeud(int, boolean, Noeud)
     * @see Noeud#isNoyau()
     */
    private boolean noyau;

    /**
     * Représente le noeud suivant.
     *
     * @see Noeud#Noeud(int, boolean, Noeud)
     * @see Noeud#getSuivant()
     */
    Noeud suivant;

    /**
     * Constructeur Noeud.
     * À partir de la construction d'un objet Noeud, l'élément, le noyau et le noeud suivant sont initialisés.
     * @param e
     *          Elément du noeud.
     * @param n
     *          Si le noeud est un noyau.
     * @param s
     *          Nouveau noeud sur lequel il va pointer.
     */
    public Noeud (int e, boolean n, Noeud s) {
        element = e;
        noyau = n;
        suivant = s;
    }

    /**
     * Retourne l'élément du noeud.
     * @return La valeur de l'élément du noeud.
     */
    public int getElement() {
        return element;
    }

    /**
     * Indique si le noeud est un noyau.
     * @return True si le noeud est un noyau, sinon false.
     */
    public boolean isNoyau() {
        return noyau;
    }

    /**
     * Retourne le noeud suivant.
     * @return Le noeud suivant.
     */
    public Noeud getSuivant() {
        return suivant;
    }
}
