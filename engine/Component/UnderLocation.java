package engine.Component;

import java.util.ArrayList;

import engine.process.ai.SpecialNode;

/**
 * Contains the special nodes.
 */
public class UnderLocation extends KeysPlace{

    private ArrayList<SpecialNode> nodes;
   
    public UnderLocation(int x, int y) {
        super(x, y);
        nodes = new ArrayList<>();
    }
    
    public void add(SpecialNode node){
        nodes.add(node);
    }

    public SpecialNode get(int index){
        return nodes.get(index);
    }

    public void remove(int index){
        nodes.remove(index);
    }

    public int size(){
        return nodes.size();
    }

    public Boolean isEmpty(){
        return nodes.isEmpty();
    }
}
