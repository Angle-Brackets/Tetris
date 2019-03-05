import java.util.Random;
import java.awt.*;

public class Tetromino {
    private static char[] shapes = {'I', 'O', 'T', 'S', 'Z', 'J', 'L'};
    private static final int SCALE = TetrisRunner.SCALING;
    private char shape;
    private boolean pieceLanded;
    private int[][] tetromino;
    int x, y;

    public Tetromino(){
        shape = generateShape();

        if(shape == 'I'){
            tetromino = new int[][] {
                    {0,1,0,0},
                    {0,1,0,0},
                    {0,1,0,0},
                    {0,1,0,0},
            };
        }
        else if(shape == 'O'){
            tetromino = new int[][] {
                    {2,2,0,0},
                    {2,2,0,0},
                    {0,0,0,0},
                    {0,0,0,0},
            };
        }
        else if(shape == 'T'){
            tetromino = new int[][]{
                    {0,3,0,0},
                    {3,3,3,0},
                    {0,0,0,0},
                    {0,0,0,0},
            };
        }
        else if(shape == 'S'){
            tetromino = new int[][]{
                    {0,4,4,0},
                    {4,4,0,0},
                    {0,0,0,0},
                    {0,0,0,0},
            };
        }
        else if(shape == 'Z'){
            tetromino = new int[][]{
                    {5,5,0,0},
                    {0,5,5,0},
                    {0,0,0,0},
                    {0,0,0,0},
            };
        }
        else if(shape == 'L'){
            tetromino = new int[][]{
                    {0,6,0,0},
                    {0,6,0,0},
                    {0,6,6,0},
                    {0,0,0,0},
            };
        }
        else if(shape == 'J'){
            tetromino = new int[][]{
                    {0,0,7,0},
                    {0,0,7,0},
                    {0,7,7,0},
                    {0,0,0,0},
            };
        }
        pieceLanded = false;
        x = TetrisRunner.WIDTH/2 - TetrisRunner.SCALING;
        y = 0;
    }

    private char generateShape(){
        Random random = new Random();
        return shapes[random.nextInt(7)];
    }

    public int[][] getTetromino(){
        return tetromino;
    }

    public void draw(Graphics window){
        for(int row = 0; row < tetromino.length; row++){
            for(int col = 0; col < tetromino[row].length; col++){
                if(tetromino[row][col] != 0){
                    Color c = null;
                    switch (tetromino[row][col]){
                        case 1: c = TetrominoColors.I_PIECE.getColor();
                                break;
                        case 2: c = TetrominoColors.O_PIECE.getColor();
                                break;
                        case 3: c = TetrominoColors.T_PIECE.getColor();
                                break;
                        case 4: c = TetrominoColors.S_PIECE.getColor();
                                break;
                        case 5: c = TetrominoColors.Z_PIECE.getColor();
                                break;
                        case 6: c = TetrominoColors.L_PIECE.getColor();
                                break;
                        case 7: c = TetrominoColors.J_PIECE.getColor();
                                break;
                    }

                    window.setColor(c);
                    window.fillRect(x+col*TetrisRunner.SCALING, y+row*TetrisRunner.SCALING, TetrisRunner.SCALING, TetrisRunner.SCALING);
                    window.setColor(Color.BLACK);
                    window.drawRect(x+col*TetrisRunner.SCALING, y+row*TetrisRunner.SCALING, TetrisRunner.SCALING, TetrisRunner.SCALING);
                }

            }
        }
    }

    public void setPosition(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void setPieceLanded(boolean b){
        pieceLanded = b;
    }

    public void updateGameBoardPos(){
        //120, 180 -> /scaling -> [4][6]

        for(int row = 0; row < tetromino.length; row++){
            for(int col = 0; col < tetromino[row].length; col++){
                if(tetromino[row][col] != 0)
                    TetrisGameWindow.gameBoard[(y/SCALE)][x/SCALE] = tetromino[row][col];



            }
        }

    }

    public int[] getPosition(){
        return new int[] {x, y};
    }

    public boolean isPieceLanded(){
        return pieceLanded;
    }

    public String toString(){
        return "Current Piece type is: "+shape;
    }



}
