import java.awt.*;
import java.util.ArrayList;
import java.util.Stack;

public class Board {

    public static int sizeX;
    public static int sizeY;

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

    public static boolean checkCoordsValid(ArrayList<Point> coords){

        for (Point c : coords){
            if (c.x < 0 || c.x > sizeX || c.y < 0 || c.y > sizeY){ return false; }
        }

        return true;
    }

}
