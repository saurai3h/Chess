package pieces;

import board.Position;
import game.Player;

public class Rook extends Piece {

    public Rook(Player player)    {
        name = "R";
        this.player = player;
    }

    @Override
    public boolean isValidMove(Position source, Position destination) {
        return (source.getRow().equals(destination.getRow()) && !source.getColumn().equals(destination.getColumn())) || (!source.getRow().equals(destination.getRow()) && source.getColumn().equals(destination.getColumn()));
    }
}
