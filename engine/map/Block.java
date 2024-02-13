package engine.map;

/**
 * A Block represent the position of an element.
 */
public class Block {
	private int y;
	private int x;

	public Block(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getY() {
		return this.y;
	}

	public int getX() {
		return this.x;
	}

	@Override
	public String toString() {
		return "Block [line=" + y + ", column=" + x + "]";
	}

}
