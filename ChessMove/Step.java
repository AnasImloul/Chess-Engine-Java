package ChessMove;

import java.awt.*;

public class Step {

    public final int x;
    public final int y;
    public final int maxSteps;


    public Step(int x, int y){
        this.x = x;
        this.y = y;
        this.maxSteps = 1;
    }

    public Step(int x, int y, boolean isMax){
        this.x = x;
        this.y = y;
        this.maxSteps = isMax ? Integer.MAX_VALUE : 1;
    }

    public Step(Point from, Point to){
        this.x = (int) (to.getX() - from.getY());
        this.y = (int) (to.getY() - from.getY());
        this.maxSteps = 1;
    }

    public Step(int x, int y, int maxSteps){
        this.x = x;
        this.y = y;
        this.maxSteps = maxSteps;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public Step flip(){
        return new Step(-x, -y, maxSteps);
    }

    public boolean equals(Step step) {
        if (step.x * x < 0 || (x == 0 && step.x != 0)) return false;
        if (step.y * y < 0 || (y == 0 && step.y != 0)) return false;
        if (step.x * y != step.y * x) return false;
        return step.x <= maxSteps * x && Math.abs(step.y) <= Math.abs(maxSteps) * y;
    }

    public boolean canExtend(int i){
        return 1 <= i && i <= maxSteps;
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
