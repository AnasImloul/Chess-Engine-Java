package ChessBoard;

import java.awt.*;

public class Tile extends Point {
    int x;
    int y;

    public Tile(int x, int y){
        this.x = x;
        this.y = y;
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public boolean equals(Tile tile){
        return tile.getX() == x && tile.getY() == y;
    }

    public String toString(){
        return "(" + x + ", " + y + ")";
    }
}
