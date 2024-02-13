package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;

import config.GameConfiguration;
import engine.map.Map;
import engine.process.GameBuilder;
import engine.process.PetManager;

/**
 * Manage all the informations between every Panels.
 */
public class MainGUI extends JFrame implements Runnable {

	private static final long serialVersionUID = 1L;

	private Map map;

	private final static Dimension preferredSize = new Dimension(GameConfiguration.WINDOW_WIDTH, GameConfiguration.WINDOW_HEIGHT);

	private PetManager manager;

	private GameDisplay dashboard;

	private OperationZonePanel informationPanel;
	
	private InfZonePanel inf;

	private boolean running = false; 

	public MainGUI(String title) {
		super(title);
		init();
	}

	private void init() {
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());

		map = GameBuilder.buildMap();
		manager = GameBuilder.buildInitMobile(map);
		dashboard = new GameDisplay(map, manager);
		inf = new InfZonePanel(manager);
		
		informationPanel=new OperationZonePanel(manager.rewardAction(), manager.punishAction(),manager.speed_Down(),manager.speed_Up());

		dashboard.setPreferredSize(preferredSize);
		contentPane.add(dashboard, BorderLayout.CENTER);
		contentPane.add(informationPanel, BorderLayout.EAST);
		contentPane.add(inf, BorderLayout.WEST);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setBackground(Color.black);
		setVisible(true);
		setPreferredSize(preferredSize);
		setLocationRelativeTo(null);
		setResizable(false);
	}
	
	@Override
	public void run() {
		
		manager.start();
		
		while (!running) {
			
			try {
				Thread.sleep(GameConfiguration.GAME_SPEED);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
			dashboard.repaint();
			inf.repaint();			
		}
	}
}