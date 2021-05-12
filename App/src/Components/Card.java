package Components;

import Constants.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import UI.Window;

public class Card implements Constants {
    private static String[] ranks = new String[] { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A" };
    private static String[] suits = new String[] { "C", "S", "D", "H" };

    private static JLabel card;
    private static boolean faceUp;

    public static JLabel getCard() { return card; }
    public static boolean isFaceUp() { return faceUp; }

    /**
     * Create a Card object that is displayable to the screen.
     * @param cardName the name of the card, corresponds to the filename
     * @param isFaceUp if the card is face up or not
     */
    public Card(String cardName, boolean isFaceUp) {
        // set corresponding filePath
        String FILE_PATH;
        if (isFaceUp) {
            FILE_PATH = "Img/Cards/" + cardName + ".png";
            faceUp = true;
        }
        else {
            faceUp = false;
            FILE_PATH = "Img/Backs/" + cardName + ".png";
        }

        // set up card as JLabel
        card = new JLabel();
        card.setSize((int)Constants.SCREEN_SIZE.getWidth() / 4, (int) Constants.SCREEN_SIZE.getHeight() / 4);

        // add image to card
        card.setIcon(new ImageIcon(new ImageIcon (FILE_PATH).getImage().getScaledInstance(200, 300, Image.SCALE_DEFAULT) ));

        // mouse listeners
        card.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) { Window.displayRandomCard(); }
            @Override
            public void mousePressed(MouseEvent e) {

            }
            @Override
            public void mouseReleased(MouseEvent e) {

            }
            @Override
            public void mouseEntered(MouseEvent e) {

            }
            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        card.updateUI();
    }

    /**
     * Generate a random string representation of a card
     * @return String value of a card: {@link Img.Cards}
     */
    public static String generateRandomCard() {
        Random rand = new Random();
        int rank = rand.nextInt(ranks.length);
        int suit = rand.nextInt(suits.length);

        return ranks[rank] + suits[suit];
    }
}
