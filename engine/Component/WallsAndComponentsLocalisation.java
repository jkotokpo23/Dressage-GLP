package engine.Component;

import java.util.ArrayList;
import java.util.Arrays;

import config.GameConfiguration;
import engine.process.ai.SpecialNode;
/**
 * Manage the positions of the walls and other components.
 */
public class WallsAndComponentsLocalisation {
    
    private ArrayList<WallState> wallStates= new ArrayList<WallState>();

    private ArrayList<HouseElement> elements=new ArrayList<HouseElement>();
    
    public WallsAndComponentsLocalisation(){
        
        int blockSize=GameConfiguration.BLOCK_SIZE;

        wallStates.add(new WallState(30*blockSize, 35*blockSize, 30*blockSize, GameConfiguration.WINDOW_HEIGHT,1));
		wallStates.add(new WallState(30*blockSize, 70, 30*blockSize, 30*blockSize,1));
		wallStates.add(new WallState(30*blockSize, 7*blockSize, 45*blockSize,7*blockSize,0));
		wallStates.add(new WallState(50*blockSize,7*blockSize, GameConfiguration.WINDOW_WIDTH,7*blockSize,0));

		wallStates.add(new WallState(50*blockSize,50*blockSize, 50*blockSize,GameConfiguration.WINDOW_HEIGHT,1));
		wallStates.add(new WallState(500,35*blockSize, GameConfiguration.WINDOW_WIDTH,35*blockSize,0));
		wallStates.add(new WallState(50*blockSize,350, 50*blockSize,45*blockSize,1));

		wallStates.add(new WallState(30*blockSize,40*blockSize,45*blockSize,40*blockSize,0));
		wallStates.add(new WallState(45*blockSize,40*blockSize, 45*blockSize,45*blockSize,1));
		wallStates.add(new WallState(45*blockSize,50*blockSize,45*blockSize,GameConfiguration.WINDOW_WIDTH,1));

        elements.add(new HouseElement("Tv",305, 75,15*blockSize,4*blockSize));
        elements.add(new HouseElement("canape2", 345, 260,10*blockSize,4*blockSize));
        elements.add(new HouseElement("plante", 305, 250,4*blockSize,4*blockSize));
        elements.add(new HouseElement("lampe", 305, 120,3*blockSize,3*blockSize));
        elements.add(new HouseElement("tablesalon", 360, 160,8*blockSize,8*blockSize));
        elements.add(new HouseElement("kitchen1", 600, 73,20*blockSize,4*blockSize));
        elements.add(new HouseElement("frigo",550, 73,5*blockSize,4*blockSize));
        elements.add(new HouseElement("armoire",550, 309,27*blockSize,4*blockSize));

    }

    public boolean wallcollisideWithPet(int x,int y){
        Boolean bool=false;
        int index=0;
        while(index < wallStates.size() && bool.equals(false)){
            bool=wallStates.get(index).isIn(x, y);
            index++;
        }
        return bool;
    }

    public boolean HouseElementscollisideWithPet(int posx, int posy){
        Boolean bool=false;
        int index=0;
        while(index < elements.size() && bool.equals(false)){
            bool=elements.get(index).colliside(posx, posy);
            index++;
        }
        return bool;
    }

    public static  ArrayList<UnderLocation> getPlaces(){
       
        ArrayList<UnderLocation> list = new ArrayList<>();
        SpecialNode specialNode;

        //Lit
        UnderLocation ul0 = new UnderLocation(690, 420);
        specialNode = new SpecialNode(690, 420, 0,"Mimi joue sur le lit");
        specialNode.setCode("001");
        ul0.add(specialNode);
        list.add(ul0);

        //Table's kitchen
        UnderLocation ul2 = new UnderLocation(640, 200);
        specialNode = new SpecialNode(640, 200, 0,"Mimi saute sur la table\nde cuisine");
        specialNode.setCode("010");
        ul2.add(specialNode);
        list.add(ul2);

        //Tree
        UnderLocation ul3 = new UnderLocation(100, 500);
        specialNode = new SpecialNode(100, 500, 1,"Mimi joue et cours\ndans le jardin");
        specialNode.setCode("011");
        ul3.add(specialNode);
        list.add(ul3);
 
        //Living room sofa
        UnderLocation ul4 = new UnderLocation(320, 175);
        specialNode = new SpecialNode(320, 175, 0, "Mimi joue sur le\ncanapé salon");
        specialNode.setCode("010");
        ul4.add(specialNode);
        specialNode = new SpecialNode(320, 175, 0, "Mimi gratte le\ncanapé salon");
        specialNode.setCode("010");
        ul4.add(specialNode);
        list.add(ul4);

        //kitchen furniture
        UnderLocation ul5 = new UnderLocation(755, 115);
        specialNode = new SpecialNode(755, 115, 0,"Monter sur le meuble\nde cuisine");
        specialNode.setCode("010");
        ul5.add(specialNode);
        list.add(ul5);

        //Litière
        UnderLocation ul6 = new UnderLocation(305, 365);
        specialNode = new SpecialNode(305, 365, 1,"Mimi décide de faire ses\nbesoins dans la litière");
        specialNode.setCode("110");
        ul6.add(specialNode);
        list.add(ul6);

        //Baignoire
        UnderLocation ul7 = new UnderLocation(320, 500);
        specialNode = new SpecialNode(320, 500, 0,"Mimi joue dans dans la\nbaignoire");
        specialNode.setCode("010");
        ul7.add(specialNode);
        list.add(ul7);

        //Moquette de la chambre
        UnderLocation ul8 = new UnderLocation(660, 420);
        specialNode = new SpecialNode(660, 420, 0,"Mimi gratte la moquette\nde la chambre");
        specialNode.setCode("010");
        ul8.add(specialNode);
        list.add(ul8);

        //Poubelle cuisine 
        UnderLocation ul9 = new UnderLocation(760, 260);
        specialNode = new SpecialNode(760, 260, 0,"Mimi est entrain de\nfouiller dans la poubelle");
        specialNode.setCode("110");
        ul9.add(specialNode);
        list.add(ul9);

        //Gamelle
        UnderLocation ul10 = new UnderLocation(525, 325);
        specialNode = new SpecialNode(525, 325, 1,"Mimi va manger dans\nsa gamelle");
        specialNode.setCode("110");
        ul10.add(specialNode);
        specialNode = new SpecialNode(525, 325, 0,"Mimi a renversé\nsa gamelle");
        specialNode.setCode("110");
        ul10.add(specialNode);
        list.add(ul10);

        //Balle jardin 
        UnderLocation ul11 = new UnderLocation(175, 375);
        specialNode = new SpecialNode(175, 375, 1,"Mimi joue avec une balle\ndans le jardin");
        specialNode.setCode("011");
        ul11.add(specialNode);
        specialNode = new SpecialNode(175, 375, 0,"Mimi mordille la balle\n au lieu de jouer avec");
        specialNode.setCode("011");
        ul11.add(specialNode);
        list.add(ul11);
        return list;
    }

    public static ArrayList<SpecialNode> getSpecialNodes(){

        ArrayList<SpecialNode> keyPlace = new ArrayList<>();
        keyPlace.add(new SpecialNode(690, 420, 0,"Mimi joue sur le lit")); //lit
		keyPlace.add(new SpecialNode(640, 200, 0,"Mimi saute sur la table\nde cuisine")); //table cuisine
		keyPlace.add(new SpecialNode(45, 110, 0,"Niche ")); //niche
		keyPlace.add(new SpecialNode(100, 500, 1,"Mimi joue et cours dehors")); //arbre 
		keyPlace.add(new SpecialNode(320, 175, 0, "Mimi joue sur le\ncanapé salon")); //canape salon 
		keyPlace.add(new SpecialNode(755, 115, 0,"Monter sur le meuble de cuisine")); //Monter sur le meuble de cuisine
		keyPlace.add(new SpecialNode(320, 500, 0,"Mimi joue dans dans la\nbaignoire")); //baignoire
		keyPlace.add(new SpecialNode(305, 365, 1,"Mimi décide de faire ses\nbesoins dans la litière")); //Litiere : Faire ses besoins
		keyPlace.add(new SpecialNode(660, 420, 0,"Mimi gratte la moquette de la chambre")); 
		keyPlace.add(new SpecialNode(760, 260, 0,"Mimi est entrain de\nfouiller dans la poubelle"));
		keyPlace.add(new SpecialNode(510, 360, 0,"Mimi est entrain de\n jouer avec la balle\n dans la chambre"));
		keyPlace.add(new SpecialNode(525, 325, 1,"Mimi va manger dans\nsa gamelle")); //Manger
        keyPlace.add(new SpecialNode(175, 375, 1,"Mimi joue avec une balle\ndans le jardin"));
        return keyPlace;
	
    }
    
    public int[][] blocksArray() {
        int width = GameConfiguration.WINDOW_WIDTH;
        int height = GameConfiguration.WINDOW_HEIGHT;
        int x = 0;
        int[][] tab = new int[width * height][2];
        for (int i = 0; i <= width; i++) {
            for (int j = 0; j <= height; j++) {
                if (wallcollisideWithPet(i, j) || HouseElementscollisideWithPet(i, j)) {
                    tab[x][0] = i;
                    tab[x][1] = j;
                    x++;
                }
            }
        }
        return Arrays.copyOf(tab, x);
    }
    
    
    public class WallState{
        
        //Oreintation : 1 for Horizontal walls and 0 for Vertical walls
        private int x1;
        private int y1;
        private int x2;
        private int y2;
        private int orientation;

        public WallState(int x1, int y1, int x2, int y2, int x){
            this.x1=x1;
            this.x2=x2;
            this.y1=y1;
            this.y2=y2;
            this.orientation=x;
        }

        public boolean isIn(int x, int y){

            int petsize=GameConfiguration.PET_SIZE;

            if(orientation==GameConfiguration.VERTICAL_WALLS){
                if ((x+petsize>=x1 && x-petsize<=x2  && y==y1 ) || (x+petsize>=x1 && x-petsize<=x2  && y+petsize==y1) ){
                    return true;
                }
                else{
                    return false;
                }
            }
            
            else{
                if((x1==x+petsize && y+petsize<=y2 && y>=y1) || (x==x1 && y+petsize<=y2 && y>=y1) || (x1==x+petsize && y<=y2 && y+petsize>=y1) || (x==x1 && y<=y2 && y>=y1)){
                    return true;
                }
                else{
                    return false;
                }
            }
        }
    }
}