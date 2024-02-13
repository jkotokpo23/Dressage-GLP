package engine.map;

/**
 * the data class of the Map.
 */
public class Map {
	private Block[][] blocks;

	private int lineCount;
	private int columnCount;

	public Map(int lineCount, int columnCount) {
		this.lineCount = lineCount;
		this.columnCount = columnCount;

		blocks = new Block[lineCount][columnCount];

		for (int lineIndex = 0; lineIndex < lineCount; lineIndex++) {
			for (int columnIndex = 0; columnIndex < columnCount; columnIndex++) {
				blocks[lineIndex][columnIndex] = new Block(lineIndex, columnIndex);
			}
		}
	}

	public Block[][] getBlocks() {
		return blocks;
	}

	public int getLineCount() {
		return lineCount;
	}

	public int getColumnCount() {
		return columnCount;
	}

	public Block getBlock(int line, int column) {
		return blocks[line][column];
	}

	public boolean isOnTop(Block block) {
		int line = block.getY();
		return line == 0;
	}

	public boolean isOnBottom(Block block) {
		int line = block.getY();
		return line == lineCount - 1;
	}

	public boolean isOnLeftBorder(Block block) {
		int column = block.getX();
		return column == 0;
	}

	public boolean isOnRightBorder(Block block) {
		int column = block.getX();
		return column == columnCount - 1;
	}

	public boolean isOnBorder(Block block) {
		return isOnTop(block) || isOnBottom(block) || isOnLeftBorder(block) || isOnRightBorder(block);
	}

}
