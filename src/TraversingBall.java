package src;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

public class TraversingBall {
    private static final double MIN_VELOCITY;
    private static final double MAX_VELOCITY;
    private static final double MOVABLE_AREA_SIZE;
    protected final double radius;
    protected double rx, ry;  // position
    protected double vx, vy;  // velocity

    static {
        MIN_VELOCITY = -0.005;
        MAX_VELOCITY = 0.005;
        MOVABLE_AREA_SIZE = 1.0;
    }

    public TraversingBall()
    {
        radius = 0.005;
        rx     = StdRandom.uniformDouble(radius*2, MOVABLE_AREA_SIZE - radius*2);
        ry     = StdRandom.uniformDouble(radius*2, MOVABLE_AREA_SIZE - radius*2);
        vx     = StdRandom.uniformDouble(MIN_VELOCITY, MAX_VELOCITY);
        vy     = StdRandom.uniformDouble(MIN_VELOCITY, MAX_VELOCITY);
    }

    public TraversingBall(double radius, double rx, double ry, double vx, double vy)
    {
        if (!(radius > 0.0)) throw new IllegalArgumentException("radius must be positive");
        if (rx - radius < -1.0 || rx + radius > 1.0) throw new IllegalArgumentException("out-of-bounds rx");
        if (ry - radius < -1.0 || ry + radius > 1.0) throw new IllegalArgumentException("out-of-bounds ry");
        this.radius = radius;
        this.rx = rx;
        this.ry = ry;
        this.vx = vx;
        this.vy = vy;
    }

    public void move(double dt)
    {
        if((rx + vx*dt < radius) || (rx + vx*dt > MOVABLE_AREA_SIZE - radius)) {vx = -vx;}
        if((ry + vy*dt < radius) || (ry + vy*dt > MOVABLE_AREA_SIZE - radius)) {vy = -vy;}
        rx = rx + vx*dt;
        ry = ry + vy*dt;
    }

    public void draw()
    {
        StdDraw.filledCircle(rx, ry, radius);
    }
}
