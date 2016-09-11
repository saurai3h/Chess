package pieces;

import board.Position;
import game.Player;

public class Queen extends Piece {

    public Queen(Player player)    {
        name = "Q";
        this.player = player;
    }

    @Override
    public boolean isValidMove(Position source, Position destination) {
        return new Bishop(this.player).isValidMove(source, destination) || new Rook(this.player).isValidMove(source, destination);
    }
}
