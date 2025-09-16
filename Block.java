public class Block {
    int x,y;
    char symbol;
    public Block(int x, int y, int symbol){
        this.x = x;
        this.y = y;
        this.symbol = (char) ('0'+symbol);
    }

}
