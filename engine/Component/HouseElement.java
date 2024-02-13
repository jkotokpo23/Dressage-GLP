package engine.Component;

import config.GameConfiguration;
import engine.map.Block;

/**
 * Manages the visual elements of the house and their collision with the cat.  
 */
public class HouseElement {
	private String name;
	private int x;
	private int y;
	private int height;
	private int width;

	/**
	 * Place the elements of the house on the dashbord.
	 * @param name Name of the element
	 * @param x x position
	 * @param y y position
	 * @param width	width of the element
	 * @param height height of the element
	 */
	public HouseElement(String name, int x, int y, int width, int height) {
		this.name =name;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Manages the collisions between the cat and the elements of the house. 
	 * @param xp x position of the cat
	 * @param yp y position of the cat
	 * @return boolean (Yes/No if there is a collision) 
	 */
	public boolean colliside(int xp, int yp){
		
		int petsize=GameConfiguration.PET_SIZE;

		int x1=x, x2=x+width, y1=y, y2=y+height;
		
		return (xp+petsize>=x1 && xp<=x2 && yp+petsize>=y1 && yp<=y2);
	}

	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	public void setPosition(Block block) {
		this.x=block.getX();
		this.y=block.getY();
	}
	
	public void setPosition(int x, int y) {
		this.x=x;
		this.y=y;
	}
	
	
	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}	
}