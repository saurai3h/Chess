package pieces;

import game.Player;
import board.Position;

public abstract class Piece {

    public Player player;
    public String name;

    public abstract boolean isValidMove(Position source, Position destination);
}
