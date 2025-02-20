package src;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

public class GenerateHeatTransferTestCase {
    public static void main(String[] args) {
        int N = StdIn.readInt();
        double blockerBallRadius = StdIn.readDouble();
        double leftSideParticleMinV = StdIn.readDouble();
        double leftSideParticleMaxV = StdIn.readDouble();
        double leftSideParticleMinRadius = StdIn.readDouble();
        double leftSideParticleMaxRadius = StdIn.readDouble();
        double leftSideParticleMinMass = StdIn.readDouble();
        double leftSideParticleMaxMass = StdIn.readDouble();
        double rightSideParticleMinV = StdIn.readDouble();
        double rightSideParticleMaxV = StdIn.readDouble();
        double rightSideParticleMinRadius = StdIn.readDouble();
        double rightSideParticleMaxRadius = StdIn.readDouble();
        double rightSideParticleMinMass = StdIn.readDouble();
        double rightSideParticleMaxMass = StdIn.readDouble();

        int leftSideParticles = N/2;
        int rightSideParticles = N - leftSideParticles;
        int blockerBallCount = 22;

        // Empty and filled with particles along with blockers
         int totalParticlesCount = (N < 1) ? N + blockerBallCount + 3 : N + blockerBallCount;

        // Filled with particles and closed blocker wall
        // int totalParticlesCount = N + blockerBallCount + 3;
        // One side particles without blockers
        // int totalParticlesCount = N/2;
        System.out.println(totalParticlesCount);

        int i;
        for(i = 0; i< leftSideParticles;i++){
            double rx     = StdRandom.uniformDouble(blockerBallRadius, 0.5-blockerBallRadius);
            double ry     = StdRandom.uniformDouble(0+blockerBallRadius, 1-blockerBallRadius);
            double vx     = StdRandom.uniformDouble(leftSideParticleMinV, leftSideParticleMaxV);
            double vy     = StdRandom.uniformDouble(leftSideParticleMinV, leftSideParticleMaxV);
            double radius = StdRandom.uniformDouble(leftSideParticleMinRadius, leftSideParticleMaxRadius);
            double mass   = StdRandom.uniformDouble(leftSideParticleMinMass, leftSideParticleMaxMass);
            int r         = 255;
            int g         = 0;
            int b         = 0;
            System.out.println(rx + " " + ry + " " + vx + " " + vy + " " + radius + " " + mass + " " + r + " " + g + " " + b);
        }
        for(i = 0; i< rightSideParticles;i++){
            double rx     = StdRandom.uniformDouble(0.5+blockerBallRadius, 1-blockerBallRadius);
            double ry     = StdRandom.uniformDouble(0+blockerBallRadius, 1-blockerBallRadius);
            double vx     = StdRandom.uniformDouble(rightSideParticleMinV, rightSideParticleMaxV);
            double vy     = StdRandom.uniformDouble(rightSideParticleMinV, rightSideParticleMaxV);
            double radius = StdRandom.uniformDouble(rightSideParticleMinRadius, rightSideParticleMaxRadius);
            double mass   = StdRandom.uniformDouble(rightSideParticleMinMass, rightSideParticleMaxMass);
            int r         = 0;
            int g         = 0;
            int b         = 255;
            System.out.println(rx + " " + ry + " " + vx + " " + vy + " " + radius + " " + mass + " " + r + " " + g + " " + b);
        }

        // 1st ball position up from middle and 11 balls till top
        for(i = 0; i<blockerBallCount/2; i++){
            double rx     = 0.5;
            double ry     = (0.5 + 1 * 2 * blockerBallRadius )+(i+1)*blockerBallRadius*2;
            double vx     = 0;
            double vy     = 0;
            double radius = 0.02;
            double mass   = 100000;
            int r         = 0;
            int g         = 0;
            int b         = 0;
            System.out.println(rx + " " + ry + " " + vx + " " + vy + " " + radius + " " + mass + " " + r + " " + g + " " + b);
        }

        // 1st ball position down from middle and 11 balls till bottom
        for(i = 0; i<blockerBallCount/2; i++){
            double rx     = 0.5;
            double ry     = (0.5 - 1 * 2 * blockerBallRadius )-(i+1)*blockerBallRadius*2;
            double vx     = 0;
            double vy     = 0;
            double radius = 0.02;
            double mass   = 100000;
            int r         = 0;
            int g         = 0;
            int b         = 0;
            System.out.println(rx + " " + ry + " " + vx + " " + vy + " " + radius + " " + mass + " " + r + " " + g + " " + b);
        }

        if(N<1){
            // If there are no particles just close the gap
            for(i = 0; i<3; i++){
                double rx     = 0.5;
                double ry     = (0.5 -2 * 2 * blockerBallRadius )+(i+1)*blockerBallRadius*2;
                double vx     = 0;
                double vy     = 0;
                double radius = 0.02;
                double mass   = 100000;
                int r         = 0;
                int g         = 0;
                int b         = 0;
                System.out.println(rx + " " + ry + " " + vx + " " + vy + " " + radius + " " + mass + " " + r + " " + g + " " + b);
            }
        }
    }
}
