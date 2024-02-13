package engine.Component;

import config.GameConfiguration;
import engine.map.Block;
import engine.process.ai.Node;

/**
 * The data class of the cat.
 */
public class Pet {
	private int x=350;
	private int y=0;
	private int width=GameConfiguration.PET_SIZE;
	private int height=GameConfiguration.PET_SIZE;	
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public void setPosition(int xp, int yp){
		if(x+xp+width < GameConfiguration.WINDOW_WIDTH && x+xp>0){
			this.x+=xp;
		}
		if( y+yp+height < GameConfiguration.WINDOW_HEIGHT && y+yp>0){
			this.y+=yp;
		}
	}

	public void setPosition(Node node){
		this.y=node.getCol();
		this.x=node.getRow();
	}
	
	public Block getPosition() {
		return new Block(x,y);
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getWidth() {
		return width;
	}
	public boolean isOnSouth(int py) {
		return (getY()+py > (GameConfiguration.WINDOW_HEIGHT - height));
	}
	
	public boolean isOnNorth(int py) {
		return (getY()+py < 0);
	}
	
	public boolean isOnEast(int px) {
		return (getX()+px < 0);
	}
	
	public boolean isOnWest(int px) {
		return (getX()+px > (GameConfiguration.WINDOW_WIDTH - width));
	}
}
