package game;

import board.Board;
import board.Position;
import validation.ValidationUtil;

public class TwoPlayerGame {

    //    Player white starts the game
    private Player playerWhite;
    private Player playerBlack;
    private Board board;
    public enum Color {WHITE,BLACK}
    private Color toMove = Color.WHITE;

    public TwoPlayerGame(String playerOneName, String playerTwoName)  {
        playerWhite = new Player(playerOneName, Color.WHITE);
        playerBlack = new Player(playerTwoName, Color.BLACK);
        board = new Board(playerWhite, playerBlack);
    }

    public boolean move(String playerWhoMoved, Position source, Position destination)    {
//        just check if the player who moved is actually supposed to move or not.
        if((playerWhite.getName().equals(playerWhoMoved) && toMove.equals(Color.WHITE)) || (playerBlack.getName().equals(playerWhoMoved) && toMove.equals(Color.BLACK)))   {
            if(ValidationUtil.validate(board, source, destination, playerWhoMoved))    {
                board.changeBoardState(source, destination);
                if(toMove.equals(Color.BLACK))  {
                    toMove = Color.WHITE;
                }else   {
                    toMove = Color.BLACK;
                }
                board.print();
                return true;
            }else   {
                System.out.println("The move is invalid.");
                board.print();
                return false;
            }
        }else   {
            System.out.println("It's not " + playerWhoMoved + "'s move.");
            board.print();
            return false;
        }
    }

//    if either of the king is in check and there is no valid move to defend it.
    public boolean isGameOver() {
        return false;
    }
}
