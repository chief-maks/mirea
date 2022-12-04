package Lab_5;

import javax.swing.*;
import java.awt.*;

public class ImageComponent extends JPanel {
    private Image image;
    public ImageComponent(Image image) {
        this.image = image;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 50, 50, null);
    }
}