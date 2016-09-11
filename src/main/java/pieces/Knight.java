package pieces;

import board.Position;
import game.Player;

public class Knight extends Piece{

    public Knight(Player player)    {
        name = "N";
        this.player = player;
    }

    @Override
    public boolean isValidMove(Position source, Position destination) {
        return (Math.abs(source.getRow() - destination.getRow()) == 1 && Math.abs(source.getColumn() - destination.getColumn()) == 2) || (Math.abs(source.getRow() - destination.getRow()) == 2 && Math.abs(source.getColumn() - destination.getColumn()) == 1);
    }
}
