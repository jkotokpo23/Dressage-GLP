package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

/**
 * The class which generate the Frame containing all the parameters.
 */
public class Parameter extends JFrame {

    private boolean musicPlaying = false;

    public Parameter() {
        super("Parameter : Dressage");
        JPanel panel = new JPanel();
        JLabel musicLabel = new JLabel("Musique : ");
       
        JLabel parameterLabel = new JLabel("Paramètre");
        Font font = new Font("Arial", Font.BOLD, 16);
        parameterLabel.setFont(font);
        panel.add(musicLabel);
        JToggleButton toggleButtonMusic = new JToggleButton("On/Off");
    
        toggleButtonMusic.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (musicPlaying) {
                    musicPlaying = false;
                    System.out.println("Musique arrêtée");
                } else {
                    musicPlaying = true;
                    System.out.println("Musique démarrée");
                }
            }
        });
        panel.add(toggleButtonMusic);
        panel.add(parameterLabel);
        musicLabel.setBounds(110, 125, 100, 30);
        toggleButtonMusic.setBounds(175, 125, 100, 30);
        parameterLabel.setBounds(175, 10, 100, 30);

        panel.setLayout(null);
        this.setContentPane(panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 300);
        this.setVisible(true);
    }
}
