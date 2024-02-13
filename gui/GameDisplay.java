package gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import engine.map.Map;
import engine.process.PetManager;

/**
 * This class generate the gaming area.
 */
public class GameDisplay extends JPanel {

	private static final long serialVersionUID = 1L;

	private Map map;
	private PaintStrategy paintStrategy = new PaintStrategy();
	private PetManager manager=new PetManager(map);

	public GameDisplay(Map map, PetManager manager) {
		this.map = map;
		this.manager=manager;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		paintStrategy.paintMap(map, g);
		
		Graphics2D g2=(Graphics2D)g;
		
		paintStrategy.printPet(g2, manager);
	}
}