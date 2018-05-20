package test;

/**
 * Tests for the Playable Interface
 */

import main.Board;
import main.Game;
import main.Response;
import org.junit.Test;
public class TestPlayable {

    @Test
    public void testRegisterPlayerWrongPhase(){

        Game g = new Game();
        g.changePhase(Game.Phase.Setup);

        Response r = g.registerPlayer("Test");

        assert (!r.getResult());

    }

    @Test
    public void testRegisterPlayerOne(){

        Game g = new Game();

        Response r = g.registerPlayer("TestOne");

        assert (r.getResult());

    }

    @Test
    public void testRegisterPlayerBoth(){

        Game g = new Game();

        g.registerPlayer("TestOne");
        Response r = g.registerPlayer("TestTwo");

        assert (r.getResult());

    }

    @Test
    public void testRegisterPlayerSameName(){

        Game g = new Game();

        g.registerPlayer("Test");
        Response r = g.registerPlayer("Test");

        assert (!r.getResult());

    }

    @Test
    public void testPlaceShipWrongPhase(){

        Game g = new Game();
        int[][] coords = new int[][] {{2,2}, {2,3}};

        assert (!g.placeShip(1, coords).getResult());

    }

    @Test
    public void testPlaceShipNullCoords(){

        Game g = new Game();
        g.changePhase(Game.Phase.Setup);

        assert (!(g.placeShip(1, null).getResult()));
    }

    @Test
    public void testPlaceShipDiagonalCoords(){

        Game g = new Game();
        g.changePhase(Game.Phase.Setup);

        int[][] coords = new int[][] {{2,3}, {2,3}};

        assert !(g.placeShip(1, coords).getResult());
    }

    @Test
    public void testPlaceShipBrokenLine(){

        Game g = new Game();
        g.changePhase(Game.Phase.Setup);

        int[][] coords = new int[][] {{2,2,2}, {2,3,5}};

        assert (!(g.placeShip(1, coords).getResult()));
    }

    @Test
    public void testPlaceShipValidCoords(){

        Game g = new Game();
        g.registerPlayer("Test");

        g.changePhase(Game.Phase.Setup);

        int[][] coords = new int[][] {{2,2,2}, {2,3,4}};

        assert (g.placeShip(1, coords).getResult());
    }

    @Test
    public void testPlaceShipValidCoordsOutOfSync(){

        Game g = new Game();
        g.registerPlayer("Test");

        g.changePhase(Game.Phase.Setup);

        int[][] coords = new int[][] {{2,2,2}, {5,6,7}};

        assert (g.placeShip(1, coords).getResult());
    }

    @Test
    public void testPlaceShipValidCoordsEdgeCase(){

        Game g = new Game();
        g.registerPlayer("Test");

        g.changePhase(Game.Phase.Setup);

        int[][] coords = new int[][] {{Board.sizeX -2, Board.sizeX -2, Board.sizeX -2}, {Board.sizeY -2 ,Board.sizeY -1 ,Board.sizeY}};

        assert (g.placeShip(1, coords).getResult());
    }

    @Test
    public void testPlaceShipSameSize(){

        Game g = new Game();
        g.registerPlayer("Test");
        g.changePhase(Game.Phase.Setup);

        int[][] coords = new int[][] {{2,2,2}, {2,3,4}};

        g.placeShip(1, coords);
        assert !(g.placeShip(1, coords).getResult());

    }

    @Test
    public void testPlaceShipOutOfRangePoints(){

        Game g = new Game();
        g.registerPlayer("Test");

        g.changePhase(Game.Phase.Setup);

        int[][] coords = new int[][] {{Board.sizeX, Board.sizeX, Board.sizeX}, {Board.sizeY - 1, Board.sizeY, Board.sizeY + 1}};

        assert !(g.placeShip(1, coords).getResult());

    }

    @Test
    public void testPlaceShipOutOfRangePointsNegative(){

        Game g = new Game();
        g.registerPlayer("Test");

        g.changePhase(Game.Phase.Setup);

        int[][] coords = new int[][] {{-1, 0, 1}, {0, 0, 0}};

        assert !(g.placeShip(1, coords).getResult());

    }


}
