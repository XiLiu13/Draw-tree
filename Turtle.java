package turtle;
import java.awt.Color;

public class Turtle {
    private double x, y;     // turtle is at (x, y)
    private double angle,angle2,cutoff,prop,n,c;    // facing this many degrees counterclockwise from the x-axis


    // start at (x0, y0), facing a0 degrees counterclockwise from the x-axis
    public Turtle(double x0, double y0, double a0) {
        x = x0;
        y = y0;
        angle = a0;
        angle2=31.0091;
        cutoff=0.0001;
        prop=1.6666666666;
        n=2;
        c=0.9999999;
    }

    // rotate orientation delta degrees counterclockwise
    public void turnLeft(double delta) {
        angle += delta;
    }

    public void turnRight(double delta) {
        turnLeft(-delta);
    }

    // move forward the given amount, with the pen down
    public void goForward(double step) {
        double oldx = x;
        double oldy = y;
        x += step * Math.cos(Math.toRadians(angle));
        y += step * Math.sin(Math.toRadians(angle));
        StdDraw.line(oldx, oldy, x, y);
    }

    public void goBackward(double step) {
        goForward(-step);
    }

    // copy to onscreen
    public void show() {
        StdDraw.show();
    }

    // pause t milliseconds
    public void pause(int t) {
        StdDraw.pause(t);
    }


    public void setPenColor(Color color) {
        StdDraw.setPenColor(color);
    }
    public void setPenRadius(double radius) {
        StdDraw.setPenRadius(radius);
    }
    public void setCanvasSize(int width, int height) {
        StdDraw.setCanvasSize(width, height);
    }
    public void setXscale(double min, double max) {
        StdDraw.setXscale(min, max);
    }
    public void setYscale(double min, double max) {
        StdDraw.setYscale(min, max);
    }
    public void XiLiuDrawTree(double branchLen) {
        if(branchLen>0.0001)
        {
        goForward(branchLen);
        turnLeft(30);
        XiLiuDrawTree(0.6*branchLen);

        turnRight(60);
        XiLiuDrawTree(0.6*branchLen);

        turnLeft(30);
        goBackward(branchLen);
        }
    } 
    public static void main(String[] args) {
        StdDraw.enableDoubleBuffering();
        double x0 = 0.5;
        double y0 = 0.0;
        double a0 = 90;
        Turtle turtle = new Turtle(x0, y0, a0);
        turtle.setCanvasSize(500, 500);
        turtle.setPenColor(Color.MAGENTA);
        turtle.XiLiuDrawTree(0.4);
        turtle.show();


        // The following block draws an equilateral triangle as an example

        // StdDraw.enableDoubleBuffering();
        // double x0 = 0.5;
        // double y0 = 0.1;
        // double a0 = 60.0;
        // double step = Math.sqrt(3)/2;
        // Turtle turtle = new Turtle(x0, y0, a0);
        // turtle.goForward(step);
        // turtle.turnLeft(120.0);
        // turtle.goForward(step);
        // turtle.turnLeft(120.0);
        // turtle.goForward(step);
        // turtle.turnLeft(120.0);
        // turtle.show();
    }

}