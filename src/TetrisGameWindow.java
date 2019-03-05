import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class TetrisGameWindow extends JPanel implements Runnable{
    public static int[][] gameBoard = new int[TetrisRunner.HEIGHT/TetrisRunner.SCALING][TetrisRunner.WIDTH/TetrisRunner.SCALING];

    Tetromino currentPiece = new Tetromino();

    public TetrisGameWindow(){
        setBackground(Color.WHITE);
        new Thread(this).start();
    }

    public void update(Graphics window){
        paint(window);
    }

    public void paint(Graphics window){
       if(currentPiece.isPieceLanded()){
           currentPiece = new Tetromino();
           currentPiece.setPosition(TetrisRunner.WIDTH/2 - TetrisRunner.SCALING, 0);
           currentPiece.setPieceLanded(false);
       }
       else if(!currentPiece.isPieceLanded() && currentPiece.getPosition()[1] < TetrisRunner.HEIGHT){
            currentPiece.draw(window);
            currentPiece.setPosition(TetrisRunner.WIDTH/2 - TetrisRunner.SCALING, currentPiece.getPosition()[1]+TetrisRunner.SCALING);
            currentPiece.updateGameBoardPos();
            for(int i = 0; i < gameBoard.length; i++){
                for(int j = 0; j < gameBoard[i].length; j++){
                    System.out.print(gameBoard[i][j] + ", ");
                }
                System.out.println();
            }
           System.out.println();
       }
       else{
           currentPiece.setPieceLanded(true);
       }

       //Draw background Grid
       for(int row = 0; row < gameBoard.length; row++){
           for(int col = 0; col < gameBoard[row].length; col++){
               window.drawRect(col*TetrisRunner.SCALING, row*TetrisRunner.SCALING, TetrisRunner.SCALING, TetrisRunner.SCALING);
           }
       }
    }









    public void run(){
        try{
            while(true){
                Thread.currentThread().sleep(1000);
                repaint();
            }
        }catch(Exception e){}
    }
}
