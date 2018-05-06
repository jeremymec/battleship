package model;

import java.util.Stack;

public class Board {

    public enum Square {
        HIT,
        NOTHIT
    }

    Square[][] squares;

    Stack<Move> moves;

}
