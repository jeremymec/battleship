package main;

import java.awt.*;
import java.util.ArrayList;

public class Game implements Playable {

    private Player playerOne;
    private Player playerTwo;

    public enum Phase {
        Waiting,
        Setup,
        Active
    }

    private Phase phase;

    public Game(){
        phase = Phase.Waiting;
    }

    // TESTING ONLY SHOULD REMOVE
    public void changePhase(Phase p){
        phase = p;
    }


    public Player getPlayerFromID(int playerID) {

        switch (playerID){
            case 1:
                return getPlayerOne();
            case 2:
                return getPlayerTwo();
        }

        return null;
    }

    private Player getPlayerOne() {
        return playerOne;
    }

    private Player getPlayerTwo() {
        return playerTwo;
    }

    @Override
    public Response registerPlayer(String name) {

        if (phase != Phase.Waiting) {
            return new Response("", false);
        }

        if (playerOne == null){
            playerOne = new Player(name);
            return new Response("", true);

        } else if (playerTwo == null) {
            // Do not allow two players with the same name
            if (playerOne.getName().equals(name)) { return new Response("", false); }

            playerTwo = new Player(name);
            return new Response("", true);

        } else {
            return new Response("", false);
        }

    }

    @Override
    public Response placeShip(int playerID, int[][] coords) {

        // Check game is in the setup phase
        if (phase != Phase.Setup){ return new Response("", false); }

        // Convert the coords into usable list
        ArrayList<Point> listOfPoints = coordsArrayToList(coords);
        if (listOfPoints == null) { return new Response("", false); }

        // Check the ship is of a valid size
        if (!Ship.validShipSize(listOfPoints)) { return new Response("", false); }

        // Check the player is valid
        if (getPlayerFromID(playerID) == null) { return new Response("", false); }

        // Check the player hasn't already placed a ship of that size
        if (getPlayerFromID(playerID).hasShipOfSize(listOfPoints.size())) { return new Response("", false); }

        // Check that coords are valid ones that exist on the board
        if (!(Board.checkValidPoints(listOfPoints))) { return new Response("", false); }

        getPlayerFromID(playerID).addShip(new Ship(listOfPoints));

        return new Response("", true);
    }

    @Override
    public Response fireShot(int playerID, int x, int y) {
        return new Response("", false);
    }

    private ArrayList<Point> coordsArrayToList(int[][] coords){

        // Check array of coords is not null
        if (coords == null) { return null; }

        // Check array of coords contains only x and y
        if (coords.length != 2) { return null; }

        // Check array has coords in it
        if (coords[0].length == 0 || coords[1].length == 0) { return null; }

        // Check array has same number of x and y coords
        if (coords[0].length != coords[1].length) { return null; }

        ArrayList<Point> points = new ArrayList<>();

        for (int i = 0; i < coords[0].length; i++){

            points.add(new Point(coords[0][i], coords[1][i]));

        }

        return points;
    }


}
