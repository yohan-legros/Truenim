package smartbot;

/**
 * GameState est la classe représentant l'état courant du jeu.
 * Elle est caractérisée par un tableau contenant les allumettes du plateau.
 */
public class GameState {

    /**
     * Tableau contenant les allumettes du plateau.
     *
     * @see GameState#GameState(int)
     */
    private int [] board;
    
    /**
     * Tableau contenant "graphiquement" les allumettes du plateau.
     * 
     * @see GameState#getStick(int[], int)
     * @see GameState#drawStick(int[], String[])
     */
    private String [] stick;
    
    /**
     * Constructeur GameState.
     * À la construction d'un objet GameState, le tableau est initialisé et contient les allumettes.
     *
     * @param lignes
     *              Nombre de lignes du tableau.
     */
    public GameState (int lignes) {
        int [] board = new int [lignes];
        this.board = board;
        for(int i=0 ; i<lignes ; i++) {
            board [i] = (2*i)+1;
        }
    }

    /**
     * Retourne le tableau d'allumettes.
     * @return Le tableau contenant les allumettes du plateau.
     */
    public int [] getBoard () {
        return board;
    }

    /**
     * Permet le fonctionnement et l'avancement du jeu.
     * @param plateau
     *              Plateau du jeu.
     * @param player
     *              Joueur humain.
     * @param bot
     *              Joueur IA.
     * @param configuration
     *              Ensemble des états accessibles pour l'IA.
     * @param n
     * 				Taille du tableau de String.
     *
     * @see Config
     * @see Board#auTourDe(int, HumanPlayer, IA)
     * @see Console#showBoard(int[])
     * @see Move
     * @see Console#getMove(String)
     * @see Console#restartMove(Move, int[], String)
     * @see Board#applyMove(Move, int[], Config)
     * @see IA#botMove(int[], Config)
     * @see Console#showWinner(String)
     * @see Board#winner(int, String, String)
     */
    public static void inGame (GameState plateau, HumanPlayer player, IA bot, Config configuration, int n) {
        int tours = 0;
        for (int i = 0; i < plateau.getBoard().length; i++) {
			String [] S = GameState.drawStick(plateau.getBoard(), plateau.getStick(n));
			while (plateau.getBoard()[i] != 0) {
				String playing_player = Board.auTourDe (tours, player, bot);
				Console.showBoard (S);
				if (playing_player == player.getName()) {
					Move move = Console.getMove (playing_player);
					move = Console.restartMove (move, plateau.getBoard(), playing_player);
                    Board.applyMove (move, plateau.getBoard(), configuration);
                } else {
                    Board.applyMove(IA.botMove (plateau.getBoard(), configuration), plateau.getBoard(), configuration);
                }
                tours++;
                S = GameState.drawStick(plateau.getBoard(), plateau.getStick(n));
            }
        }
        Console.showWinner (Board.winner (tours, player.getName(), bot.getName()));
    }
    
    /**
     * Initialise la taille du tableau de String.
     * @param n
     * 			Taille du plateau.
     * 			
     * @return Le tableau graphique des allumettes.
     */
    public String [] getStick (int n){
  		stick = new String [n];
  		return stick;
	}
    
    /**
     * Donne un rendu graphique des allumettes.
     * @param i
     * 			Nombre d'allumettes sur une ligne.
     * 
     * @return Graphiquement les allumettes.
     */
    public static String repeat (int i) {
		String j = "";
		if (i > 0) {
			return j+"|"+repeat(i-1);
		} else {
			return j;
		}
	}
    
    /**
     * Remplit le tableau String à partir du tableau d'entier.
     * @param board
     * 			Tableau contenant les allumettes du plateau.
     * @param stick
     * 			Tableau graphique des allumettes.
     * @return Le tableau graphique des allumettes.
     */
   	public static String [] drawStick (int [] board, String [] stick) {
   		for (int i = 0; i < board.length; i++) {
   			for (int j = 0; j < stick.length; j++) {
   				stick[i] = repeat(board[i]);
   			}
   		}
   		return stick;
   	}
}