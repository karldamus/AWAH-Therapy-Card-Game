package Components;

import Constants.Constants;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Card implements Constants {
    private static JLabel card;

    public static JLabel getCard() { return card; }

    public Card(String cardName, boolean isFaceCard) {
        String FILE_PATH;
        if (isFaceCard) { FILE_PATH = "Img/Cards/" + cardName + ".png"; }
        else { FILE_PATH = "Img/Backs/" + cardName + ".png"; }

        card = new JLabel();
        card.setSize((int)Constants.SCREEN_SIZE.getWidth() / 4, (int) Constants.SCREEN_SIZE.getHeight() / 4);

        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(FILE_PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Image dimg = img.getScaledInstance(card.getWidth(), card.getHeight(), Image.SCALE_SMOOTH);
//        imageIcon

        card.setIcon(new ImageIcon(new ImageIcon (FILE_PATH).getImage().getScaledInstance(200, 300, Image.SCALE_DEFAULT) ));

//        card = new JLabel(new ImageIcon(FILE_LOCATION + cardName + ".png"));
//        card.setSize((int)Constants.SCREEN_SIZE.getWidth() / 4, (int) Constants.SCREEN_SIZE.getHeight() / 4);
    }
}
