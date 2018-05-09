package bot;
import java.util.Scanner;

import bot.Console;
import bot.GameState;


/**
 * Main est la classe principale représentant les configurations/paramètres effectuées avant le début de la partie.
 * Elle permet au joueur de rejouer s'il le souhaite.
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);

        int rejouer = 1;
        HumanPlayer player = new HumanPlayer (Console.getPlayerName());
        IA bot = new IA ();
        do {
        	int n = Console.getSize();
            GameState plateau = new GameState(n);
            GameState.inGame(plateau, player, bot, n);
            System.out.println("Voulez-vous rejouer? (Oui : 1 / Non : 0)");
            do {
                rejouer = in.nextInt();
            } while (rejouer < 0 || rejouer > 1);
        } while (rejouer == 1);
        System.out.println("\nMerci d'avoir joué!");
    }
}