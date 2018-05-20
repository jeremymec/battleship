package main;

import java.awt.*;
import java.util.ArrayList;
import java.util.Stack;

public class Board {

    public static int sizeX = 20;
    public static int sizeY = 20;

    public enum Square {
        HIT,
        NOTHIT
    }

    private Square[][] squares;

    private Stack<Move> moves;

    Board(){

        squares = new Square[sizeX][sizeY];

        for (int y = 0; y < sizeY; y++){

            for (int x = 0; x < sizeX; x++){
                squares[x][y] = Square.NOTHIT;
            }
        }
    }

    public Square getSquare(int x, int y){
        if (x < 0 || x > squares[1].length || y < 0 || y > squares[0].length){
            return null;
        } else {
            return squares[x][y];
        }
    }

    static boolean checkValidPoints(ArrayList<Point> points){

        for (Point p : points){
            if (!( p.x >= 0 && p.x <= sizeX && p.y >= 0 && p.y <= sizeY)) { return false; }
        }

        return true;
    }

}
