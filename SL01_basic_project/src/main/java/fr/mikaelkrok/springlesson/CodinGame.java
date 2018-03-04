package fr.mikaelkrok.springlesson;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by mikae on 16/07/2016.
 */
public class CodinGame {

    /**
     * the goal is to save all points at 1st round to improve
     * precision
     */
    private static class Point{
        public int x;
        public int y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
        public boolean equals(Object obj) {
            if (this == obj){
                return true;
            }
            if(obj instanceof Point){
                Point p = (Point) obj;
                if(p.x != this.x) return false;
                if(p.y != this.y) return false;
                return true;
            }
            return false;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }

    private static List<Point> set = new ArrayList<Point>();

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        boolean turnComplete = false;
        int maxDist = 0;
        Point maxPoint = null;
        // game loop
        while (true) {
            int x = in.nextInt();
            int y = in.nextInt();
            int nextCheckpointX = in.nextInt(); // x position of the next check point
            int nextCheckpointY = in.nextInt(); // y position of the next check point
            int nextCheckpointDist = in.nextInt(); // distance to the next checkpoint
            int nextCheckpointAngle = in.nextInt(); // angle between your pod orientation and the direction of the next checkpoint
            int opponentX = in.nextInt();
            int opponentY = in.nextInt();

            // Basic speed calculation
            String stringT = "99";
            double T = 0;
            double turnCoef = (180-Math.abs(nextCheckpointAngle))/150;
            T = nextCheckpointDist>999?99:nextCheckpointDist/10;
            T = T * turnCoef;

            // Boost Calculation
            Point p = new Point(x, y);
            if(!turnComplete){
                Point nextP = new Point(nextCheckpointX, nextCheckpointY);
                if(set.contains(nextP)){
                    turnComplete = true;
                }else{
                    set.add(nextP);
                    int tmpDist = distBetweenPoint(p, nextP);
                    if(tmpDist>maxDist){
                        // when to trigger the boost;
                        maxPoint = p;
                        maxDist = tmpDist;
                    }
                }
            }else{
                if(p.equals(maxPoint)){
                    stringT = "BOOST";
                }else{
                    stringT = String.valueOf(T);
                }
            }


            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");


            // You have to output the target position
            // followed by the power (0 <= thrust <= 100)
            // i.e.: "x y thrust"


            System.out.println(nextCheckpointX + " "
                    + nextCheckpointY + " "
                    + stringT);
        }
    }

    private static int distBetweenPoint(Point A, Point B){
        int dist = 0;
        dist = (int)Math.sqrt((B.x-A.x)*(B.x-A.x)+(B.y-A.y)*(B.y-A.y));
        return dist;
    }
}
