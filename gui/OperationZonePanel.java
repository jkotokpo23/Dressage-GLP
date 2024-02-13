package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;


import javax.swing.JPanel;
import javax.swing.JButton;
import engine.process.PetManager.*;

/**
 * The class which create the Panel every buttons.
 */
public class OperationZonePanel extends JPanel{
	
	private JButton up = new JButton("Accelerer");

	private JButton down = new JButton("Ralentir");

	private JButton recompenseButton = new JButton("Recompense");

	private JButton punitionButton = new JButton("Punition");

	private Font font = new Font(Font.MONOSPACED, Font.BOLD, 15);
	public final static Dimension size=new Dimension(180,20);
	private static final long serialVersionUID = 1L;
	
	public OperationZonePanel(RewardClass reward, PunitionClass punish, Speed_down speeddown, Speed_up speedup ) {
		setLayout(new FlowLayout(FlowLayout.CENTER,5,30));

		recompenseButton.setFont(font);
		punitionButton.setFont(font);
		up.setFont(font);
		down.setFont(font);

		setBackground(Color.WHITE);

		add(recompenseButton);
		add(punitionButton);
		add(up);
		add(down);

		recompenseButton.addActionListener(reward);
		punitionButton.addActionListener(punish);
		up.addActionListener(speedup);
		down.addActionListener(speeddown);

		this.setPreferredSize(size);
	}
}
