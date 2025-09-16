# Brick Breaker (Console Edition)

A simple console-based brick breaker style game built in **Java**.  
The ball moves **straight up**, **diagonally left-up**, or **diagonally right-up**, depending on the user’s input.  
Blocks inside the grid have **numeric durability** values, and hitting them reduces their value until destroyed.  


##  How to Play
- The play area is a **7x7 grid**:
  - `w` → walls  
  - `g` → ground  
  - `b` → ball  
  - numbers (`1–9`) → blocks with durability  
  - space → empty cell  

- You have **5 chances** to control the ball.  
- Each chance, enter one of the following moves:
  - `st` → straight up  
  - `l` → diagonal left-up  
  - `r` → diagonal right-up  

- When the ball hits:
  - A **block** → block’s number decreases by `1`. If it reaches `0`, the block disappears.  
  - A **wall** → the ball bounces in a different direction.  
  - The **ground (`g`)** → ball rests at bottom row.  



##  Win / Lose Conditions
- **Win**: Destroy all blocks before you run out of chances.  
- **Lose**: If chances run out and blocks remain.  


## Running the Game
1. Compile all `.java` files:
   javac Main.java Ball.java Block.java Brick.java
2. Run:
    java Main

## 📘 Classes & Methods

### `Ball.java`
Handles ball movement and collision logic.  

- `moveUp(Brick brick)` → moves ball straight upward.  
- `moveDown(Brick brick)` → moves ball downward (after bounce).  
- `moveDiagLeftUp(Brick brick)` → moves ball diagonally left-up.  
- `moveDiagRightUp(Brick brick)` → moves ball diagonally right-up.  
- `moveDiagLeftDown(Brick brick)` → moves ball diagonally left-down.  
- `moveDiagRightDown(Brick brick)` → moves ball diagonally right-down.  
- `restoreGround(Brick brick)` → restores `g` when ball leaves ground.  
- `dropToGround(Brick brick)` → forces ball to bottom row.  

---

### `Block.java`
Represents a block inside the play area.  

- `Block(int x, int y, int symbol)` → constructor for block with coordinates and durability.  

---

### `Brick.java`
Handles the game board.  

- `Brick()` → initializes the board with walls + ground.  
- `Brick(int x, int y)` → places ball at given coordinates.  
- `addBlock(Block[] blocks)` → adds blocks into the grid.  
- `display()` → prints the current play area.  
- `clearScreen()` → clears console output.  

---

### `Main.java`
Entry point for the game.  

- `main(String[] args)` → runs the game loop with 5 chances.  

## Demo

![Screen Recording 2025-09-16 at 21 50 36](https://github.com/user-attachments/assets/5513f2d3-fda2-4770-93b4-e2b4012a8745)
