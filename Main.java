import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Brick brick = new Brick();
        Ball ball = new Ball(brick.size - 1, brick.size / 2); // place ball at bottom center
        brick.playArea[ball.x][ball.y] = 'b';

        // Add some blocks
        Block[] blocks = {
            new Block(2, 2, 3),
            new Block(2, 4, 2),
            new Block(3, 3, 1),
            new Block(2,3,1)
        };
        brick.addBlock(blocks);

        brick.display();

        int chances = 5;
        while (chances > 0) {
            System.out.println("Enter move (st = straight, l = left diag, r = right diag): ");
            String move = sc.nextLine().trim();

            if (move.equalsIgnoreCase("st")) {
                ball.moveUp(brick);
            } else if (move.equalsIgnoreCase("l")) {
                ball.moveDiagLeftUp(brick);
            } else if (move.equalsIgnoreCase("r")) {
                ball.moveDiagRightUp(brick);
            } else {
                System.out.println("Invalid input! Try again.");
                continue;
            }

            chances--;
            System.out.println("Chances left: " + chances);
        }

        System.out.println("Game Over!");
        sc.close();
    }
}
