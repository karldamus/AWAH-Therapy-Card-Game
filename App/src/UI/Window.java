package UI;

import Components.Card;
import Constants.Constants;

import javax.swing.*;
import java.awt.*;

public class Window implements Constants {
    private static JFrame window;

    public static JFrame getWindow() { return window; }

    public Window() {
        this(Constants.SCREEN_SIZE);
    }

    public Window(Dimension d) {
        this(d.getWidth(), d.getHeight());
    }

    public Window(double width, double height) {
        this(width, height, "Untitled Program");
    }

    public Window(double width, double height, String programName) {
        width = width / 2;
        height = height / 2;

        window = new JFrame(programName);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize((int) width, (int) height);

//        displayBacksOfCards();

        window.setVisible(true);
    }

    public void displayBacksOfCards() {
        int numberOfCards = 8;
        Card[] cards = new Card[numberOfCards];

        for (int i = 0; i < numberOfCards; i += 1) {
            cards[i] = new Card("purple_back", false);
        }

        for (Card card : cards) {
            add(card);
        }
    }

    public void add(Card card) {
        window.getContentPane().add(card.getCard());
        SwingUtilities.updateComponentTreeUI(window);
    }
}
