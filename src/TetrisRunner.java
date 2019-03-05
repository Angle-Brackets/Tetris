import javax.swing.*;
import java.awt.*;


public class TetrisRunner extends JFrame{
    //Dimensions are 10 wide and 20 high
    //Game dimensions are 480x800 (width, height)
    public static int WIDTH = 300;
    public static int HEIGHT = 620;
    public static int SCALING = 30;

    public TetrisRunner(){
        super("Tetris");
        setSize(WIDTH, HEIGHT);
        getContentPane().add(new TetrisGameWindow());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setVisible(true);
    }

    public static void main(String[] args) {
        TetrisRunner run = new TetrisRunner();
    }










}
