public class Ball {
    int x, y;

    public Ball(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void moveUp(Brick brick) {
        while (true) {
            if (x - 1 < 0) break;

            if (brick.playArea[x - 1][y] == 'w') {
                moveDown(brick);
                break;
            } else if (Character.isDigit(brick.playArea[x - 1][y])) {
                char temp = brick.playArea[x - 1][y];
                int newVal = Character.getNumericValue(temp) - 1;
                brick.playArea[x - 1][y] = (newVal == 0) ? ' ' : (char) ('0' + newVal);

                brick.display();
                moveDown(brick);
                break;
            } else {
                restoreGround(brick);
                x = x - 1;
                brick.playArea[x][y] = 'b';
                brick.display();
            }
        }
    }

    public void moveDown(Brick brick) {
        while (true) {
            if (x + 1 >= brick.size) break;

            if (brick.playArea[x + 1][y] == 'g') {
                restoreGround(brick);
                x = x + 1;
                brick.playArea[x][y] = 'b';
                brick.display();
                break;
            } else if (Character.isDigit(brick.playArea[x + 1][y])) {
                char temp = brick.playArea[x + 1][y];
                int newVal = Character.getNumericValue(temp) - 1;
                brick.playArea[x + 1][y] = (newVal == 0) ? ' ' : (char) ('0' + newVal);

                brick.display();
                break;
            } else {
                restoreGround(brick);
                x = x + 1;
                brick.playArea[x][y] = 'b';
                brick.display();
            }
        }
    }

    public void moveDiagLeftUp(Brick brick) {
        while (true) {
            if (x - 1 < 0 || y - 1 < 0) break;

            if (brick.playArea[x - 1][y - 1] == 'w') {
                if (x - 1 == 0 && y - 1 == 0) {
                    brick.display();
                    moveDiagRightDown(brick);
                } else if (y - 1 == 0) {
                    brick.display();
                    moveDiagRightUp(brick);
                } else if (x - 1 == 0) {
                    brick.display();
                    moveDiagLeftDown(brick);
                }
                break;
            } else if (Character.isDigit(brick.playArea[x - 1][y - 1])) {
                char temp = brick.playArea[x - 1][y - 1];
                int newVal = Character.getNumericValue(temp) - 1;
                brick.playArea[x - 1][y - 1] = (newVal == 0) ? ' ' : (char) ('0' + newVal);
                brick.display();
                moveDown(brick);
                break;
            }

            restoreGround(brick);
            x = x - 1;
            y = y - 1;
            brick.playArea[x][y] = 'b';
            brick.display();
        }
    }

    public void moveDiagRightUp(Brick brick) {
        while (true) {
            if (x - 1 < 0 || y + 1 >= brick.size) break;

            if (brick.playArea[x - 1][y + 1] == 'w') {
                if (x - 1 == 0 && y + 1 == brick.size - 1) {
                    brick.display();
                    moveDiagLeftDown(brick);
                } else if (y + 1 == brick.size - 1) {
                    brick.display();
                    moveDiagLeftUp(brick);
                } else if (x - 1 == 0) {
                    brick.display();
                    moveDiagRightDown(brick);
                }
                break;
            } else if (Character.isDigit(brick.playArea[x - 1][y + 1])) {
                char temp = brick.playArea[x - 1][y + 1];
                int newVal = Character.getNumericValue(temp) - 1;
                brick.playArea[x - 1][y + 1] = (newVal == 0) ? ' ' : (char) ('0' + newVal);
                brick.display();
                moveDown(brick);
                break;
            }

            restoreGround(brick);
            x = x - 1;
            y = y + 1;
            brick.playArea[x][y] = 'b';
            brick.display();
        }
    }
    public void moveDiagLeftDown(Brick brick) {
        while (true) {
            if (x + 1 >= brick.size || y - 1 < 0) break;

            if (brick.playArea[x + 1][y - 1] == 'w') {
                if (x + 1 == brick.size - 1 && y - 1 == 0) {
                    dropToGround(brick);
                } else if (y - 1 == 0) {
                    brick.display();
                    moveDiagRightDown(brick);
                } else if (x + 1 == brick.size - 1) {
                    dropToGround(brick);
                }
                break;
            } else if (Character.isDigit(brick.playArea[x + 1][y - 1])) {
                char temp = brick.playArea[x + 1][y - 1];
                int newVal = Character.getNumericValue(temp) - 1;
                brick.playArea[x + 1][y - 1] = (newVal == 0) ? ' ' : (char) ('0' + newVal);
                brick.display();
                moveDown(brick);
                break;

            }

            restoreGround(brick);
            x = x + 1;
            y = y - 1;
            brick.playArea[x][y] = 'b';
            brick.display();
        }
    }


    public void moveDiagRightDown(Brick brick) {
        while (true) {
            if (x + 1 >= brick.size || y + 1 >= brick.size) break;

            if (brick.playArea[x + 1][y + 1] == 'w') {
                if (x + 1 == brick.size - 1 && y + 1 == brick.size - 1) {
                    dropToGround(brick);
                } else if (y + 1 == brick.size - 1) {
                    brick.display();
                    moveDiagLeftDown(brick);
                } else if (x + 1 == brick.size - 1) {
                    dropToGround(brick);
                }
                break;
            } else if (Character.isDigit(brick.playArea[x + 1][y + 1])) {
                char temp = brick.playArea[x + 1][y + 1];
                int newVal = Character.getNumericValue(temp) - 1;
                brick.playArea[x + 1][y + 1] = (newVal == 0) ? ' ' : (char) ('0' + newVal);
                brick.display();
                moveDown(brick);
                break;
            }

            restoreGround(brick);
            x = x + 1;
            y = y + 1;
            brick.playArea[x][y] = 'b';
            brick.display();
        }
    }

    private void restoreGround(Brick brick) {
        if (x == brick.size - 1) {
            brick.playArea[x][y] = 'g';
        } else {
            brick.playArea[x][y] = ' ';
        }
    }

    private void dropToGround(Brick brick) {
        restoreGround(brick);
        x = brick.size - 1;
        brick.playArea[x][y] = 'b';
        brick.display();
    }
}
