import java.awt.*;

public enum TetrominoColors {
    Z_PIECE(new Color(255, 13, 114)),
    I_PIECE(new Color(13, 194, 255)),
    S_PIECE(new Color(13, 255, 114)),
    T_PIECE(new Color(245, 56, 255)),
    L_PIECE(new Color(255, 142, 13)),
    O_PIECE(new Color(255, 225, 56)),
    J_PIECE(new Color(56, 119, 255));

    private Color color;
    TetrominoColors(Color c){
        color = c;
    }

    public Color getColor(){
        return color;
    }

}
