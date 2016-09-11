package pieces;

import board.Position;
import game.Player;

public class Bishop extends Piece {

    public Bishop(Player player)    {
        name = "B";
        this.player = player;
    }

    @Override
    public boolean isValidMove(Position source, Position destination) {
        return (Math.abs(source.getRow() - destination.getRow()) == Math.abs(source.getColumn() - destination.getColumn())) && (source.getRow() - destination.getRow() != 0);
    }
}
