package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.border.Border;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import config.GameConfiguration;
import engine.process.PetManager;

/** 
 * The class who manage all the progressBar and the JFreeChart.
 */
public class InfZonePanel extends JPanel {

    private static final long serialVersionUID = 1L;
    private static final Dimension preferredSize = new Dimension(180,150) ;

   
    private PetManager manager;

	private JProgressBar barDressage =new JProgressBar(0,100);
	private JProgressBar barProprete = new JProgressBar(0,100);
	private JProgressBar barSagesse = new JProgressBar(0,100);
	private JProgressBar barJeu = new JProgressBar(0,100);

    private JFreeChart chart;

    private DefaultPieDataset dataset = new DefaultPieDataset();

	private JTextArea infoTexte = new JTextArea();

	private JLabel dressageLabel = new JLabel("Jauge de dressage");
	private JLabel propreteLabel = new JLabel("Jauge de propreté");
	private JLabel sagesseLabel = new JLabel("Jauge de sagesse");
	private JLabel jeuLabel = new JLabel("Jauge de jeu");
	private JLabel nameLabel = new JLabel("Nom: "+GameConfiguration.PETNAME);
    private int dress=0, nodress=100,x=0,y=0,z=0; 

	public final static Dimension size=new Dimension(180,20);

    public InfZonePanel(PetManager manager){
		this.manager=manager;
        setLayout(new FlowLayout(FlowLayout.CENTER,20,10));
        setBackground(Color.WHITE);

		barSagesse.setValue(z);
		barJeu.setValue(y);
		barProprete.setValue(x);

        add(nameLabel);
		add(dressageLabel);
		add(barDressage);

		add(propreteLabel);
		add(barProprete);

		add(sagesseLabel);
		add(barSagesse);

		add(jeuLabel);
		add(barJeu);

		setPreferredSize(size);
        
		dataset.setValue("Dressé", dress);
		dataset.setValue("Non dressée", nodress);
		
		chart = ChartFactory.createPieChart("Etat de dréssage", dataset, true, true, false);
		
		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(preferredSize);
		add(chartPanel);

		Border border= BorderFactory.createLineBorder(Color.black, 2);
		Font font = infoTexte.getFont();
		infoTexte.setFont(font.deriveFont(font.getSize()+3.0f));
		infoTexte.setAlignmentX(Component.CENTER_ALIGNMENT);
		infoTexte.setAlignmentY(Component.CENTER_ALIGNMENT);
		infoTexte.setPreferredSize(new Dimension(170, 120));
		infoTexte.setBorder(border);
		
		infoTexte.setBackground(Color.white);
		add(infoTexte);

    }
    
    public void setDress(int xi){
        dress=xi;
        nodress=100-dress;
		barDressage.setValue(dress);
    }

	public void setCleanness(int xi){
        x=xi;
		barProprete.setValue(x);

    }

	public void setGame(int xi){
        y=xi;
		barJeu.setValue(y);
    }

	public void setWisdom(int xi){
        z=xi;
		barSagesse.setValue(z);
	}

	public void setInfo(String text){
		infoTexte.setText(text);
	}

    public void paintComponent(Graphics g) {
		super.paintComponent(g);
		setDress(manager.getDressability());
		setWisdom(manager.getWisdom());
		setCleanness(manager.getcleanness());
		//
		setDress(manager.getDressability());
		
		setGame(manager.getGame());
        dataset.setValue("Dressé", dress);
		dataset.setValue("Non dressée", nodress);
		setInfo(manager.getInfoText());
	}
}
