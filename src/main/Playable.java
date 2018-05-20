package main;

public interface Playable {

    Response registerPlayer(String name);

    Response placeShip(int playerID, int[][] coords);

    Response fireShot(int playerID, int x, int y);

}
