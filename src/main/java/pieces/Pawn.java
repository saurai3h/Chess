package pieces;

import board.Position;
import game.Player;
import game.TwoPlayerGame;

public class Pawn extends Piece {

    public Pawn(Player player)    {
        name = "p";
        this.player = player;
    }

//    TODO : pawn takes on adjacent column.
//    TODO : en passant.
//    TODO : promotion.
//    TODO : if it takes something on the same column, it should be illegal. this is only for pawn.
    @Override
    public boolean isValidMove(Position source, Position destination) {
        if(source.getRow().equals(destination.getRow())) return false;
        if(!source.getColumn().equals(destination.getColumn()))return false;
        if(source.getRow()==1 && player.getColor().equals(TwoPlayerGame.Color.WHITE))  {
            return destination.getRow() == 2 || destination.getRow() == 3;
        }else if(source.getRow()==6 && player.getColor().equals(TwoPlayerGame.Color.BLACK))    {
            return destination.getRow() == 5 || destination.getRow() == 4;
        }else   {
            boolean white = player.getColor().equals(TwoPlayerGame.Color.WHITE) && destination.getRow()-source.getRow()==1;
            boolean black = player.getColor().equals(TwoPlayerGame.Color.BLACK) && destination.getRow()-source.getRow()==-1;
            return white || black;
        }
    }
}
