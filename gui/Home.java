package gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import config.GameConfiguration;

/**
 * The class for the home page.
 */
public class Home extends JFrame {

    private final static Dimension preferredSize = new Dimension(GameConfiguration.WINDOW_WIDTH+2*GameConfiguration.JP_WIDTH, GameConfiguration.WINDOW_HEIGHT);

    public Home() {
        super("Dressage");
        
        JPanel panel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                Image img = new ImageIcon("./Pictures/dressage.png").getImage();
                g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), null);
            }
        };
        panel.setLayout(null); 

        JLabel playJLabel = new JLabel();
        playJLabel.setIcon(new ImageIcon("./Pictures/playbutton.png"));
        playJLabel.setBounds(525, 190, 300, 200); 
        playJLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                MainGUI nouvelleFrame = new MainGUI("Dressage");

                Thread gameThread = new Thread(nouvelleFrame);

                gameThread.start();
                
                nouvelleFrame.setVisible(true);
            }
        });
        JLabel parameterJLabel = new JLabel();
        parameterJLabel.setIcon(new ImageIcon("./Pictures/parameter.png"));
        parameterJLabel.setBounds(20, 350, 100, 100); 
        parameterJLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new Parameter();
            }
        });
        JLabel rulesJLabel = new JLabel();
        rulesJLabel.setIcon(new ImageIcon("./Pictures/rules.png"));
        rulesJLabel.setBounds(1020, 350, 100, 100); 
        rulesJLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new Rules();
            }
        });
        JLabel titleJLabel = new JLabel();
        titleJLabel.setIcon(new ImageIcon("./Pictures/title.png"));
        titleJLabel.setBounds(400, 20, 500, 100); 

        panel.add(playJLabel);
        panel.add(parameterJLabel);
        panel.add(rulesJLabel);
        panel.add(titleJLabel);

        setContentPane(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(preferredSize);
        setVisible(true);
        setLocationRelativeTo(null);
		setResizable(false);
    }

    

    public static void main(String[] args) {
        new Home();
    }
}
