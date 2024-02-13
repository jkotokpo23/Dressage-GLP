package engine.Component;

import engine.map.Block;

/**
 * The key places of the interacting elements.
 */
public class KeysPlace {
    
    private Block state ;

    public KeysPlace(int x, int y){
        state= new Block(x, y);
    }

    public int getX(){
        return state.getX();
    }

    public int getY(){
        return state.getY();
    }
}
