package gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import config.GameConfiguration;
import config.PicConstruction;
import engine.map.Block;
import engine.map.Map;
import engine.process.PetManager;
import java.awt.image.BufferedImage;

/**
 * The class that show every elements on the dashbord.
 */
public class PaintStrategy {
	
	private BufferedImage parquet,grassTile,floorbed,carreaux,cat,bathtub,bed,carpet,tablesalleamanger,ball,catBed,trash;
	private BufferedImage tv, tablesalon, lampe, plante,canape,canape2,kitchen1,kitchen2,frigo,armoire,tree,niche,trr,gamelle; 
	

	public void paintMap(Map map, Graphics graphics) {
		
		BasicStroke thickness = new BasicStroke(5.0f);
		((Graphics2D) graphics).setStroke(thickness);
		graphics.setColor(Color.darkGray);
		int blockSize = GameConfiguration.BLOCK_SIZE;
		grassTile = PicConstruction.grass();parquet = PicConstruction.parquet();
		carreaux = PicConstruction.carreaux();cat = PicConstruction.cat();
		bathtub=PicConstruction.bathtub();bed=PicConstruction.bed();
		carpet=PicConstruction.carpet();floorbed=PicConstruction.floorbed();
		tv=PicConstruction.tv();tablesalon=PicConstruction.tablesalon();
		lampe=PicConstruction.lampe();plante=PicConstruction.plante();
		canape=PicConstruction.canape();canape2=PicConstruction.canape2();
		kitchen1=PicConstruction.kitchen1();kitchen2=PicConstruction.kitchen2();
		tablesalleamanger=PicConstruction.tablesalleamanger();frigo=PicConstruction.frigo();
		armoire=PicConstruction.armoire();
		tree=PicConstruction.tree();niche=PicConstruction.niche();
		trash=PicConstruction.trash();ball=PicConstruction.ball();
		trr=PicConstruction.terre();
		gamelle=PicConstruction.gamelle();
		catBed=PicConstruction.catBed();
		
		
		//Lawn of the house
		for (int lineIndex = 0; lineIndex < map.getLineCount(); lineIndex++) {
			for (int columnIndex = 0; columnIndex < map.getColumnCount(); columnIndex++) {
				((Graphics2D) graphics).drawImage(grassTile, columnIndex * blockSize, lineIndex * blockSize,blockSize, blockSize, null);
			}
		}

		((Graphics2D) graphics).drawImage(trr, 0 * blockSize, 35 * blockSize, 25 *blockSize, 20*blockSize, null);
				
		//Floor of house
		for (int lineIndex = 7; lineIndex < map.getLineCount(); lineIndex++) {
			for (int columnIndex = 30; columnIndex < map.getColumnCount(); columnIndex++) {
				((Graphics2D) graphics).drawImage(parquet, columnIndex * blockSize, lineIndex * blockSize,blockSize,blockSize, null);
			}
		}
		
		
		//Bathroom tile
		for (int lineIndex = 40; lineIndex < map.getLineCount(); lineIndex++) {
			for (int columnIndex = 30; columnIndex <45; columnIndex++) {
				((Graphics2D) graphics).drawImage(carreaux, columnIndex * blockSize, lineIndex * blockSize,blockSize,blockSize, null);
			}
		}
		
		//Floor of bedroom
		for (int lineIndex = 35; lineIndex < map.getLineCount(); lineIndex++) {
			for (int columnIndex = 50; columnIndex < map.getColumnCount(); columnIndex++) {
				((Graphics2D) graphics).drawImage(floorbed, columnIndex * blockSize, lineIndex * blockSize,blockSize,blockSize, null);
			}
		}
		
		//Outline of the house
		graphics.drawLine(30*blockSize, 35*blockSize, 30*blockSize, GameConfiguration.WINDOW_HEIGHT);
		graphics.drawLine(30*blockSize, 70, 30*blockSize, 30*blockSize);
		graphics.drawLine(30*blockSize, 7*blockSize, 45*blockSize,7*blockSize);
		graphics.drawLine(50*blockSize,7*blockSize, GameConfiguration.WINDOW_WIDTH,7*blockSize);
		
		//Outline of the house
		graphics.drawLine(50*blockSize,50*blockSize, 50*blockSize,GameConfiguration.WINDOW_HEIGHT);
		graphics.drawLine(50*blockSize,35*blockSize, GameConfiguration.WINDOW_WIDTH,35*blockSize);
		graphics.drawLine(50*blockSize,350, 50*blockSize,45*blockSize);
	
		//Outlines of bathroom
		graphics.drawLine(30*blockSize,40*blockSize,45*blockSize,40*blockSize);
		graphics.drawLine(45*blockSize,40*blockSize, 45*blockSize,45*blockSize);
		graphics.drawLine(45*blockSize,50*blockSize,45*blockSize,GameConfiguration.WINDOW_WIDTH);
		
		//Drawing TV
		((Graphics2D) graphics).drawImage(tv, 305, 75,15*blockSize,4*blockSize, null);
		
		//Drawing canape
		((Graphics2D) graphics).drawImage(canape, 305, 150,4*blockSize,10*blockSize, null);
		
		//Drawing 2nd canape
		((Graphics2D) graphics).drawImage(canape2, 345, 260,10*blockSize,4*blockSize, null);
		
		//Drawing plante
		((Graphics2D) graphics).drawImage(plante, 305, 250,4*blockSize,4*blockSize, null);
		
		//Drawing lampe
		((Graphics2D) graphics).drawImage(lampe, 305, 120,3*blockSize,3*blockSize, null);
		
		//Drawing table salon
		((Graphics2D) graphics).drawImage(tablesalon, 360, 160,8*blockSize,8*blockSize, null);

		//Drawing kitchen
		((Graphics2D) graphics).drawImage(kitchen1, 600, 73,20*blockSize,4*blockSize, null);
		((Graphics2D) graphics).drawImage(kitchen2, 755, 113,5*blockSize,12*blockSize, null);

		//Drawing bathtub
		((Graphics2D) graphics).drawImage(bathtub, 297, 44*blockSize,5*blockSize,12*blockSize, null);

		//Drawing bed
		((Graphics2D) graphics).drawImage(carpet,660, 395,14*blockSize,12*blockSize,null);
		((Graphics2D) graphics).drawImage(bed, 665, 390,14*blockSize,12*blockSize, null);
		
		//Table salle à manger
		((Graphics2D) graphics).drawImage(tablesalleamanger,590, 150,12*blockSize,12*blockSize,null);

		//Drawing fridge
		((Graphics2D) graphics).drawImage(frigo,550, 73,5*blockSize,4*blockSize,null);

		//Drawing armoire
		((Graphics2D) graphics).drawImage(armoire,550, 309,27*blockSize,4*blockSize,null);

		//Drawing ball
		((Graphics2D) graphics).drawImage(ball, 180, 390,2*blockSize,2*blockSize,null);
		((Graphics2D) graphics).drawImage(ball, 525, 360,2*blockSize,2*blockSize,null);

		//Drawing kennel
		((Graphics2D) graphics).drawImage(niche,10, 50,10*blockSize,10*blockSize,null);

		//Drawing tree
		((Graphics2D) graphics).drawImage(tree,0, 340,16*blockSize,19*blockSize,null);
		
		//Drawing trash
		((Graphics2D) graphics).drawImage(trash,760, 230,4*blockSize,4*blockSize,null);

		//Drawing gamelle
		((Graphics2D) graphics).drawImage(gamelle,522, 322,3*blockSize,3*blockSize,null);

		
		//Drawing catBed
		((Graphics2D) graphics).drawImage(catBed,305, 365,3*blockSize,3*blockSize,null);
		
		
	}

	public void printPet(Graphics2D g2, PetManager petManager) {
		Block position= petManager.getPosition();
		g2.drawImage(cat, position.getX(), position.getY(), petManager.getPet().getHeight(), petManager.getPet().getWidth(), null);
	}

}