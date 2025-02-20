package src;

import edu.princeton.cs.algs4.StdDraw;

public class BouncingBalls {
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        TraversingBall[] balls = new TraversingBall[N];
        for(int i = 0; i < N; i++){
            balls[i] = new TraversingBall();
        }
        while(true){
            StdDraw.clear();
            for(int i = 0; i < N; i++)
            {
                balls[i].move(0.5);
                balls[i].draw();
            }
            StdDraw.show(30);
        }
    }
}
