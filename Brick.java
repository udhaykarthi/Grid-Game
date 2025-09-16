public class Brick {
    int size = 7;
    char[][] playArea = new char[size][size];

    public Brick() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == 0 || i == size - 1 || j == 0 || j == size - 1) {
                    playArea[i][j] = 'w'; 
                }
                else {
                    playArea[i][j] = ' ';  
                } 
                if (i == size - 1 && j > 0 && j < size - 1) {
                    playArea[i][j] = 'g';  
                } 
            }
        }
    }
    public Brick(int x,int y){
        playArea[x][y] = 'b';
    }

    public void addBlock(Block[] blocks){
        for(Block block : blocks){
            playArea[block.x][block.y] = block.symbol;
        }
    }

    public void display() {
        clearScreen();
        try{
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(playArea[i][j]+" ");
            }
            System.out.println();
        }
        Thread.sleep(500);
        
    }catch(Exception e){}
    }

    public static void clearScreen() {
    for (int i = 0; i < 50; i++) {
        System.out.println();
    }
}

}
