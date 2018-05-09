import java.awt.*;
import java.util.ArrayList;

public class Ship {

    public enum Size {
        Two,
        Three,
        Four,
        Five
    }

    private ArrayList<Point> coords;

    private Size size;

    public Ship(Size s) {
        size = s;
    }

    public static Size sizeFromRaw(int x1, int y1, int x2, int y2){

        return null;

    }

}
