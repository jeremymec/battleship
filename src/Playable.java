import java.awt.*;

public interface Playable {

    int registerPlayer(String name);

    boolean placeShip(int playerID, int x1, int y1, int x2, int y2);

    boolean fireShot(int playerID, int x, int y);

}
