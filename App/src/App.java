import Components.Card;
import UI.Window;

import java.util.Random;
import Constants.Constants;

public class App implements Constants {
    private static String[] ranks = new String[] {
        "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"
    };
    private static String[] suits = new String[] {
        "C", "S", "D", "H"
    };
    private static Random rand = new Random();

    public static void main(String[] args) {
        Window window = new Window();
        Card card = new Card(generateRandomCard(), true);

//        window.add(card);
    }

    private static String generateRandomCard() {
        int rank = rand.nextInt(ranks.length);
        int suit = rand.nextInt(suits.length);

        return ranks[rank] + suits[suit];
    }
}
