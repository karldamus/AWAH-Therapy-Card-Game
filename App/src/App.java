/**
 * App.java
 * The entry point for this application.
 * @author Karl Damus
 */

import UI.Window;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import Constants.Constants;

public class App implements Constants {

    public static void main(String[] args) {
        Window window = new Window();
        window.displayBacksOfCards();
        window.displayButtons();

//        displayWindowSize(window);
    }

    // testing

    public static void displayWindowSize(Window window) {
        while (true) {
            System.out.println(window.getWindow().getSize());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
