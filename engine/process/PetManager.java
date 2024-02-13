package engine.process;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import config.GameConfiguration;
import engine.Component.Pet;
import engine.Component.UnderLocation;
import engine.Component.WallsAndComponentsLocalisation;
import engine.map.Block;
import engine.map.Map;
import engine.process.ai.AStar;
import engine.process.ai.Node;
import engine.process.ai.SpecialNode;

/**
 * The class who control every aspect of the cat (movement, action, adaptation...).
 * The core of the game.
 */
public class PetManager extends Thread {

	private Pet pet;
	private AStar aStar ; 
	private ArrayList<SpecialNode> keyPlace;
	private SpecialNode initialNode, finalNode;
	private Boolean bool,gameOver=false,atEnd=false;
	private List<Node> path;
	private int lenght, size;
	private boolean running = true;
	private PetManager instance = this;
	private String code, infoText;
	private int dx=0,dy=0,dz=0,dress=0;
	private ArrayList<UnderLocation> ul = WallsAndComponentsLocalisation.getPlaces();
	private static final int UNITY = 6;
	private int speed;

	public PetManager(Map map) {
		speed = GameConfiguration.GAME_SPEED;
		infoText="";
		int index = (int)(Math.random() * ul.size());
		UnderLocation temp = ul.get(index);
		int ix = (int)(Math.random() * temp.size());
		finalNode = temp.get(ix); 
		keyPlace = WallsAndComponentsLocalisation.getSpecialNodes();
		this.pet= new Pet();
		initialNode = new SpecialNode(pet.getX(), pet.getY());
		while(initialNode == finalNode){		
			index = (int)(Math.random() * ul.size());
			temp = ul.get(index);
			ix = (int)(Math.random() * temp.size());
			finalNode = temp.get(ix); 
		}
        aStar = new AStar(initialNode, finalNode);
		path = aStar.findPath();
		lenght=path.size();
		size=keyPlace.size()+1;

	}
	
	public Block getPosition() {
		return pet.getPosition();
	}
	
	public Pet getPet() {
		return pet;
	}

	public int getDressability() {
		return dress;
	}

	public int getcleanness() {
		return dx;
	}

	public int getGame() {
		return dy;
	}

	public int getWisdom() {
		return dz;
	}

	public String getInfoText(){
		return infoText;
	}
	
	public void pathFinder(int index){
        if (index < lenght) {
			pet.setPosition(path.get(index));
        }
    }

	/**
	 * Increase the jauges values if the user made the good choice.
	 * @return void
	 */
	public void upJauge(String code, boolean action){
		//Proprete x - Sagesse z - Jeu y
		
		switch(code){
			case "001":
				if(dy+UNITY<=100) {dy += UNITY;}
				else{dy=100;}
			case "010":
				if(dz+UNITY<=100) {dz += UNITY;}
				else{dz=100;}
			case "011":
				if(dy+UNITY<=100) {dy += UNITY;}
				else{dy=100;}
				if(dz+UNITY<=100) {dz += UNITY;}
				else{dz=100;}
			case "110":
				if(dx+UNITY<=100) {dx += UNITY;}
				else{dx=100;}
		}
	}

	/**
	 * Decrease the jauges values if the user made the wrong choice.
	 */
	public void downJauge(String code, boolean action){
		//Proprete x - Sagesse z - Jeu y
		
		switch(code){
			case "001":
				if(dy+UNITY>=0) {dy -= UNITY;}
				else{dy=0;}
			case "010":
				if(dz+UNITY>=0) {dz -= UNITY;}
				else{dz=0;}
			case "011":
				if(dy+UNITY>=0) {dy -= UNITY;}
				else{dy=0;}
				if(dz+UNITY>=0) {dz -= UNITY;}
				else{dz=0;}
			case "110":
				if(dx+UNITY>=0) {dx -= UNITY;}
				else{dx=0;}
		}
	}

	/**
	 * Find a path between 2 special nodes by using aStar.
	 * @return void
	 */
	public void findState2(){

		if(!ul.isEmpty()){
			int index = (int)(Math.random() * ul.size());
			UnderLocation temp = ul.get(index);
			if(!temp.isEmpty()){
				int ix = (int)(Math.random() * temp.size());
				finalNode = temp.get(ix);
				initialNode = new SpecialNode(pet.getX(), pet.getY());   
				aStar = new AStar(initialNode, finalNode);
				path=aStar.findPath();
				size=1;
			}
		}else{
			gameOver=true;
		}
	}

	/**
	 * Increase the game speed
	 * @return void
	 */
	public void speed_up(){
		if(speed -- > 7){
			speed --;
		}
	}

	
	/**
	 * Decrease the game speed
	 * @return void
	 */
	public void speed_down(){
		if(speed ++ < 15){
			speed ++;
		}
	}

	/**
	 * Class which implements an actionListener to increase the speed game. 
	 */
	public class Speed_up implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (running) {
				speed_up();
			}
		}
	}

	/**
	 * Class which implements an actionListener to decrease the speed game. 
	 */
	public class Speed_down implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (running) {
				speed_down();
			}
		}
	}

	/**
	 * Class which implements an actionListener to punish the cat. 
	 */
	public class PunitionClass implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (!running && !bool  && !gameOver) {
				infoText= ("Bonne décision, \nMimi a été puni" );
				running = true;
				upJauge(code, bool);
				setDress();
				Thread gameThread = new Thread(instance);
				gameThread.start();
			}
			if (!running && bool  && !gameOver) {
				infoText = ("C'est une bonne action,\nMimi doit etre récompenser");
				running = true;
				downJauge(code, bool);
				setDress();
				Thread gameThread = new Thread(instance);
				gameThread.start();
			}
		}
	}

	/**
	 * Class which implements an actionListener to reward the cat. 
	 */
	public class RewardClass implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if (!running && bool  && !gameOver) {
				infoText = ("Bonne décision, \nMimi a été récompensé");
				running = true;
				upJauge(code, bool);
				setDress();
				Thread gameThread = new Thread(instance);
				gameThread.start();
			}
			if (!running && !bool && !gameOver) {
				infoText = ("C'est une mauvaise action ,\nil doit etre puni");
				downJauge(code, bool);
				setDress();
				running = true;
				Thread gameThread = new Thread(instance);
				gameThread.start();
			}
		}
	}

	public RewardClass rewardAction(){
		return new RewardClass();
	}
	public PunitionClass punishAction(){
		return new PunitionClass();
	}
	public Speed_down speed_Down(){
		return new Speed_down();
	}
	public Speed_up speed_Up(){
		return new Speed_up();
	}

	/**
	 * Calculate if the cat should or not do an action.
	 * @return int
	 */
	public int inteligence(){
		double range;
		if(dress>90){
			range=2;
		}
		else if(dress>75){
			range=3;
		}
		else if(dress>50){
			range=5;
		}
		else if(dress>25){
			range=8;
		}
		else{
			range=10;
		}
		int bool=(int)( Math.random() * range)+1;
		return bool;
	}

	/**
	 * Calculate the global value of the dressage
	 * @return void
	 */
	public void setDress(){
		//Proprete x - Sagesse z - Jeu y
		dress=((dx*5)+(dy*2)+(dz*3))/10;
	}

		/**
	 * 
	 */
	public void run() {
		int i=0;
		
		while(size>0 && running==true){
			
			while((atEnd==false && i<lenght) && running==true && gameOver==false) {

				try {
					Thread.sleep(speed);
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
				}
				pathFinder(i);
				i++;
			}
			i=0;

			if(inteligence()==1){
				infoText= "Mimi est resté sage.";
				code = finalNode.getCode();
				bool = true;
			}
			else{
				infoText= finalNode.getText();
				code = finalNode.getCode();
				bool = finalNode.getAction();
			}
			findState2();
			lenght = path.size();	
			running = false;			
		}

	}
}