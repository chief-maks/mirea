package Lab_5W;

import javax.swing.*;
import java.awt.*;

public class TestWindow extends JFrame {
    Image img1 = (new ImageIcon("src/Lab_5W/imagesBird/bird1.png")).getImage();
    Image img2 = (new ImageIcon("src/Lab_5W/imagesBird/bird2.png")).getImage();
    Image img3 = (new ImageIcon("src/Lab_5W/imagesBird/bird3.png")).getImage();
    Image img4 = (new ImageIcon("src/Lab_5W/imagesBird/bird4.png")).getImage();
    Image img5 = (new ImageIcon("src/Lab_5W/imagesBird/bird5.png")).getImage();
    Image img6 = (new ImageIcon("src/Lab_5W/imagesBird/bird6.png")).getImage();
    Image img7 = (new ImageIcon("src/Lab_5W/imagesBird/bird7.png")).getImage();
    Image img8 = (new ImageIcon("src/Lab_5W/imagesBird/bird8.png")).getImage();
    Image img9 = (new ImageIcon("src/Lab_5W/imagesBird/bird9.png")).getImage();

    public TestWindow(String name) throws InterruptedException {
        setTitle(name);
        setSize(500, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        while(true) {
            add(new ImageComponent(img1));
            setVisible(true);
            Thread.sleep(100);

            add(new ImageComponent(img2));
            setVisible(true);
            Thread.sleep(100);

            add(new ImageComponent(img3));
            setVisible(true);
            Thread.sleep(100);

            add(new ImageComponent(img4));
            setVisible(true);
            Thread.sleep(100);

            add(new ImageComponent(img5));
            setVisible(true);
            Thread.sleep(150);

            add(new ImageComponent(img6));
            setVisible(true);
            Thread.sleep(170);

            add(new ImageComponent(img7));
            setVisible(true);
            Thread.sleep(160);

            add(new ImageComponent(img8));
            setVisible(true);
            Thread.sleep(150);

            add(new ImageComponent(img9));
            setVisible(true);
            Thread.sleep(150);
        }
    }
}