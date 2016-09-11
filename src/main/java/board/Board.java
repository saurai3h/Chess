package board;

import game.Player;
import pieces.*;

public class Board {
    public Square[][] getBoard() {
        return board;
    }

    private Square[][] board;

    public Board(Player p1, Player p2) {
        board = new Square[8][8];
        for(int i = 0 ; i < 8 ; ++i)    {
            for(int j = 0 ; j < 8 ; ++j)    {
                board[i][j] = new Square();
                board[i][j].setPosition(new Position(i,j));
            }
        }
        initializePieces(p1, p2);
        print();
    }

    public void print() {
        for(int i = 7 ; i >= 0 ; --i)   {
            System.out.print((i+1) + "  ");
            for(int j = 0 ; j < 8 ; ++j)    {
                Piece piece = board[i][j].getPiece();
                if(piece != null)
                    System.out.print(piece.name + " ");
                else System.out.print("_ ");
            }
            System.out.println();
        }
        System.out.print("   ");
        for(int i = 1 ; i <= 8 ; ++i) {
            char placeHolder = 'a';
            placeHolder += (i-1);
            System.out.print(placeHolder + " ");
        }
        System.out.println();
    }

    public void changeBoardState(Position source, Position destination)  {
        Piece toMove = board[source.getRow()][source.getColumn()].getPiece();
        board[source.getRow()][source.getColumn()].setPiece(null);
        board[destination.getRow()][destination.getColumn()].setPiece(toMove);
    }

    private void initializePieces(Player p1, Player p2)    {
        board[0][0].setPiece(new Rook(p1));
        board[0][1].setPiece(new Knight(p1));
        board[0][2].setPiece(new Bishop(p1));
        board[0][3].setPiece(new Queen(p1));
        board[0][4].setPiece(new King(p1));
        board[0][5].setPiece(new Bishop(p1));
        board[0][6].setPiece(new Knight(p1));
        board[0][7].setPiece(new Rook(p1));
        for(int j = 0 ; j < 8 ; ++j)
            board[1][j].setPiece(new Pawn(p1));

        board[7][0].setPiece(new Rook(p2));
        board[7][1].setPiece(new Knight(p2));
        board[7][2].setPiece(new Bishop(p2));
        board[7][3].setPiece(new Queen(p2));
        board[7][4].setPiece(new King(p2));
        board[7][5].setPiece(new Bishop(p2));
        board[7][6].setPiece(new Knight(p2));
        board[7][7].setPiece(new Rook(p2));
        for(int j = 0 ; j < 8 ; ++j)
            board[6][j].setPiece(new Pawn(p2));
    }
}
