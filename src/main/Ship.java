package main;

import java.awt.*;
import java.util.ArrayList;

public class Ship {

    private ArrayList<Point> coords;

    public Ship(ArrayList<Point> coords) {
        this.coords = coords;
    }

    boolean overlapsWithShip(Ship s){
        for (Point c1 : s.coords){
            for (Point c2 : s.coords){
                if (c1.x == c2.x && c1.y == c2.y){
                    return true;
                }
            }
        }

        return false;
    }

    int getSize(){
        return coords.size();
    }


    static boolean validShipSize(ArrayList<Point> points){

        // Check points is in a line
        boolean xLine = true;
        boolean yLine = true;

        for (int i = 0; i < points.size() - 1; i++){
            // If all coords are not the same, coords are not in a line
            if (points.get(i).x != points.get(i+1).x) { xLine = false; }
            if (points.get(i).y != points.get(i+1).y) { yLine = false; }

            // If coords skip, the line is broken
            if ( (Math.abs(points.get(i).x - points.get(i+1).x)) > 1) { return false; }
            if ( (Math.abs(points.get(i).y - points.get(i+1).y)) > 1) { return false; }
        }


        // If array is not in a line on either axis, not a valid ship placement
        return xLine || yLine;

    }

}
