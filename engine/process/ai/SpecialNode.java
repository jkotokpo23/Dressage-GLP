package engine.process.ai;

/**
 * This class is for the interative elements which have a special texte and action associate with.
 */
public class SpecialNode extends Node {

    //1 for reward and 0 for punishment for action

    //Proprete - Sagesse - Jeu
    private int action;
    private String text;
    private String code;

    public SpecialNode(int row, int col, int action, String text) {
        super(row, col);
        this.text=text;
        this.action=action;
    }

    public SpecialNode(int row, int col, int action, String text, String code) {
        super(row, col);
        this.text = text;
        this.action = action;
        this.code = code;
    }
    
    public SpecialNode(int row, int col) {
        super(row, col);
        this.text="defaut";
        this.action=0;
    }

    public boolean getAction() {
        if(this.action == 1){
            return true;
        }
        else
            return false;
    }
    public String getText() {
        return text; 
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
