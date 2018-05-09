public class Game implements Playable {

    private Player playerOne;
    private Player playerTwo;

    private Gamestate.Phase phase;

    public Game(){
        phase = Gamestate.Phase.Waiting;
    }

    @Override
    public int registerPlayer(String name) {

        if (phase != Gamestate.Phase.Waiting) {
            return 0;
        }

        if (playerOne == null){
            playerOne = new Player(name);
            return 1;

        } else if(playerTwo != null) {
            playerTwo = new Player(name);
            return 2;

        } else {
            return 0;
        }

    }

    @Override
    public boolean placeShip(int playerID, int x1, int y1, int x2, int y2) {

        if (phase != Gamestate.Phase.Setup){ return false; }

        Ship.Size size = Ship.sizeFromRaw(x1, y1, x2, y2);

        if (size == null) { return false; }

        Ship createdShip = new Ship(size);

    }

    @Override
    public boolean fireShot(int playerID, int x, int y) {
        return false;
    }


}
