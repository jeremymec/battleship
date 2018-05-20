package main;

import java.util.ArrayList;

class Player {

    private String name;

    private Board board;

    private ArrayList<Ship> ships;

    Player(String name){
        this.name = name;
        this.ships = new ArrayList<>();
        this.board = new Board();
    }

    public String getName() {
        return name;
    }

    void addShip(Ship ship){
        ships.add(ship);
    }

    boolean hasShipOfSize(int size){

        for (Ship s : ships){
            if (s.getSize() == size){ return true; }
        }

        return false;
    }

    boolean hasOverlappingShip(Ship ship){

        for (Ship s : ships){
            if (s.overlapsWithShip(ship)){ return true; }
        }

        return false;
    }

}
