package config;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * This class reads the different pictures of the game.
 */
public class PicConstruction {
	
	private static BufferedImage pic=null;

	public static BufferedImage grass() {
		try {
			pic=ImageIO.read(new File("./Pictures/grass.png"));
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pic;
	}

	public static BufferedImage trash() {
		try {
			pic=ImageIO.read(new File("./Pictures/poubelle.png"));
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pic;
	}
	
	public static BufferedImage floorbed() {
		try {
			pic=ImageIO.read(new File("./Pictures/floor.png"));
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pic;
	}
	
	public static BufferedImage salon() {
		try {
			pic=ImageIO.read(new File("./Pictures/salon.png"));
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pic;
	}
	
	public static BufferedImage bed() {
		try {
			pic=ImageIO.read(new File("./Pictures/bed.png"));
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pic;
	}
	
	public static BufferedImage carpet() {
		try {
			pic=ImageIO.read(new File("./Pictures/carpet.jpg"));
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pic;
	}
	
	public static BufferedImage bathtub() {
		try {
			pic=ImageIO.read(new File("./Pictures/baignoire.png"));
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pic;
	}
	
	public static BufferedImage parquet() {
		try {
			pic=ImageIO.read(new File("./Pictures/ground.png"));
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pic;
	}
	
	public static BufferedImage cat() {
		try {
			pic=ImageIO.read(new File("./Pictures/cat.png"));
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pic;
	}
	
	public static BufferedImage carreaux() {
		try {
			pic=ImageIO.read(new File("./Pictures/carreaux.png"));
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pic;
	}

	public static BufferedImage canape () {
		try {
			pic=ImageIO.read(new File("./Pictures/canape.png"));
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pic;
	}

	public static BufferedImage canape2 () {
		try {
			pic=ImageIO.read(new File("./Pictures/canape2.png"));
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pic;
	}

	public static BufferedImage lampe() {
		try {
			pic=ImageIO.read(new File("./Pictures/lampe.png"));
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pic;
	}

	public static BufferedImage plante() {
		try {
			pic=ImageIO.read(new File("./Pictures/plante.png"));
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pic;
	}

	public static BufferedImage gamelle() {
		try {
			pic=ImageIO.read(new File("./Pictures/gamelle.png"));
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pic;
	}
	public static BufferedImage catBed() {
		try {
			pic=ImageIO.read(new File("./Pictures/catBed.png"));
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pic;
	}

	public static BufferedImage tablesalon() {
		try {
			pic=ImageIO.read(new File("./Pictures/tablesalon.png"));
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pic;
	}

	public static BufferedImage tv() {
		try {
			pic=ImageIO.read(new File("./Pictures/tv.png"));
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pic;
	}

	public static BufferedImage kitchen1() {
		try {
			pic=ImageIO.read(new File("./Pictures/kitchen1.png"));
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pic;
	}

	public static BufferedImage kitchen2() {
		try {
			pic=ImageIO.read(new File("./Pictures/kitchen2.png"));
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pic;
	}

	public static BufferedImage tablesalleamanger() {
		try {
			pic=ImageIO.read(new File("./Pictures/tablesalleamanger.png"));
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pic;
	}

	public static BufferedImage frigo() {
		try {
			pic=ImageIO.read(new File("./Pictures/frigo.png"));
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pic;
	}

	public static BufferedImage armoire() {
		try {
			pic=ImageIO.read(new File("./Pictures/armoire.png"));
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pic;
	}
	
	public static BufferedImage cross() {
		try {
			pic=ImageIO.read(new File("./Pictures/cross.png"));
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pic;
	}

	public static BufferedImage tree() {
		try {
			pic=ImageIO.read(new File("./Pictures/tree.png"));
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pic;
	}

	public static BufferedImage niche() {
		try {
			pic=ImageIO.read(new File("./Pictures/niche.png"));
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pic;
	}

	public static BufferedImage ball() {
		try {
			pic=ImageIO.read(new File("./Pictures/ball.png"));
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pic;
	}

	public static BufferedImage terre() {
		try {
			pic=ImageIO.read(new File("./Pictures/trr.png"));
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pic;
	}

}