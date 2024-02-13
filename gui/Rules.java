package gui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * The class which generate the Frame containing all the rules
 */
public class Rules extends JFrame {

    public Rules() {
        super("Rules : Dressage");
        JPanel panel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                Image img = new ImageIcon("./Pictures/rulespaper.png").getImage();
                g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), null);
            }
        };
        this.setContentPane(panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setVisible(true);
    }
}

