package validation;

import board.Board;
import board.Position;
import board.Square;
import pieces.Piece;

public class ValidationUtil {

//    only basic validations for piece.
//    TODO : if there is something in between the source and destination, the move should be invalidated.
    public static boolean validate(Board board, Position source, Position destination, String playerWhoMoved) {
        return source.getRow() >= 0 && source.getRow() < 8 && destination.getRow() >= 0 && destination.getRow() < 8 && source.getColumn() >= 0 && source.getColumn() < 8 && destination.getColumn() >= 0 && destination.getColumn() < 8 && areValidOccupants(board, source, destination, playerWhoMoved) && board.getBoard()[source.getRow()][source.getColumn()].getPiece().isValidMove(source, destination);
    }

    private static boolean areValidOccupants(Board board, Position source, Position destination, String playerWhoMoved)    {
        Square src = board.getBoard()[source.getRow()][source.getColumn()];
        Square dest = board.getBoard()[destination.getRow()][destination.getColumn()];
        Piece sourceOccupant = src.getPiece();
        Piece destinationOccupant = dest.getPiece();

        if(sourceOccupant != null && sourceOccupant.player.getName().equals(playerWhoMoved))   {
            if(destinationOccupant == null)
                return true;
            if(!destinationOccupant.player.getName().equals(playerWhoMoved))
                return true;
        }

        return false;
    }
}
