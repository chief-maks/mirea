package Pr_4W;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class LabExample extends JFrame
{
    int a = 0, b = 0;

    JLabel lbl1 = new JLabel(" Last scorer: N/A", SwingConstants.CENTER);
    JLabel lbl2 = new JLabel(" Winner: Draw", SwingConstants.CENTER);
    JLabel lbl3 = new JLabel("Result: 0 x 0", SwingConstants.CENTER);
    JButton button1 = new JButton("AC Milan");
    JButton button2 = new JButton("Real Madrid");
    Font fnt = new Font("Times new roman",Font.BOLD,20);
    LabExample()
    {
        super("Example");
        //setLayout(new FlowLayout());
        setLayout(new BorderLayout());
        setSize(600,550);
        add(button1,BorderLayout.EAST);
        add(button2,BorderLayout.WEST);
        add(lbl1,BorderLayout.SOUTH);
        add(lbl2, BorderLayout.CENTER);
        add(lbl3,BorderLayout.NORTH);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                b++;
                lbl3.setText("Result: " + a +" x " + b);
                lbl1.setText("Last scorer: AC Milan");
                if (a > b) {
                    lbl2.setText("Winner: Real Madrid");
                }
                if (a < b) {
                    lbl2.setText("Winner: AC Milan");
                }
                if (a == b) {
                    lbl2.setText("Winner: Draw");
                }
            }

        });
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                a++;
                lbl3.setText("Result: " + a +" x " + b);
                lbl1.setText("Last scorer: Real Madrid");
                if (a > b) {
                    lbl2.setText("Winner: Real Madrid");
                }
                if (a < b) {
                    lbl2.setText("Winner: AC Milan");
                }
                if (a == b) {
                    lbl2.setText("Winner: Draw");
                }
            }

        });
        setVisible(true);
    }
    public static void main(String[]args)
    {
        new LabExample();
    }
}