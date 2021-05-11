package UI;

import Components.Card;
import Constants.Constants;

import javax.swing.*;
import java.awt.*;

public class Window implements Constants {
    private static JFrame window;
    private static JPanel cardsPanel;
    private static Card displayCard;

    public static JFrame getWindow() { return window; }

    public Window() { this(Constants.SCREEN_SIZE); }

    public Window(Dimension d) { this(d.getWidth(), d.getHeight()); }

    public Window(double width, double height) { this(width, height, Constants.APP_NAME); }

    /**
     * Create a new JFrame (window) to display to the screen and host the application.
     * @param width the width of the frame
     * @param height the height of the frame
     * @param programName the name of the program
     */
    public Window(double width, double height, String programName) {
        width = width / 1.1;
        height = height / 1.1;

        window = new JFrame(programName);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize((int) width, (int) height);
        window.setMinimumSize(Constants.MIN_SIZE);
        window.setLayout(new GridLayout(2, Constants.NUMBER_OF_CARDS));

        window.setVisible(true);
    }

    /**
     * Display a random card to the screen. Used when a card is selected with mouseListeners.
     * @see Card
     */
    public static void displayRandomCard() {
        if (displayCard == null) {
            displayCard = null;
            updateWindow();
        }
        displayCard = new Card(Card.generateRandomCard(), true);
    }

    /**
     * Display all playing cards face down.
     */
    public void displayBacksOfCards() {
        cardsPanel = new JPanel();
        cardsPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        window.add(cardsPanel, new GridBagConstraints());

        for (int i = 0; i < Constants.NUMBER_OF_CARDS; i += 1) {
            add(new Card("purple_back", false));
        }
        updateWindow();
    }

    /**
     * Display in-game buttons
     */
    public void displayButtons() {
        // shuffle button
        JButton shuffle = new JButton("Shuffle");
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridBagLayout());
        buttonPanel.add(shuffle);

        GridBagConstraints gbc = new GridBagConstraints();
        window.add(buttonPanel, gbc);
        updateWindow();
    }

    /**
     * Add a Card object to the {@link #cardsPanel}.
     * @param card the {@link Card} to add
     */
    public void add(Card card) {
        cardsPanel.add(card.getCard());
    }

    /**
     * Update the {@link #window} to display all added components thus far.
     */
    private static void updateWindow() {
        SwingUtilities.updateComponentTreeUI(window);
    }
}
