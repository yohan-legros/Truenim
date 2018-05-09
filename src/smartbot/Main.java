package smartbot;
import java.util.Scanner;

/**
 * Main est la classe principale représentant les configurations/paramètres effectuées avant le début de la partie.
 * Elle permet au joueur de rejouer s'il le souhaite.
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);

        int restart = 1;
        HumanPlayer player = new HumanPlayer (Console.getPlayerName());
        IA bot = new IA ();
        do {
        	int n = Console.getSize();
            GameState plateau = new GameState(n);
            Config configuration = new Config();
            configuration.remplirConfig(Board.total_allumettes(plateau.getBoard()));
            GameState.inGame(plateau, player, bot, configuration, n);
            System.out.println("Voulez-vous rejouer? (Oui : 1 / Non : 0)");
            do {
                restart = in.nextInt();
            } while (restart < 0 || restart > 1);
        } while (restart == 1);
        System.out.println("\nMerci d'avoir joué!");
    }
}