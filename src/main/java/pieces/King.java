package pieces;

import board.Position;
import game.Player;

public class King extends Piece {

    public King(Player player)    {
        name = "K";
        this.player = player;
    }

//    TODO : both castling O-O and O-O-O still to look
    @Override
    public boolean isValidMove(Position source, Position destination) {
        if((source.getRow().equals(destination.getRow()) && Math.abs(source.getColumn() - destination.getColumn()) == 1) || (source.getColumn().equals(destination.getColumn()) && Math.abs(source.getRow() - destination.getRow()) == 1))return true;
        return false;
    }
}
