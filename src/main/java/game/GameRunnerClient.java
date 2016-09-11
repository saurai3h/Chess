package game;

import board.Position;

import java.util.Scanner;

public class GameRunnerClient {
    public static void main(String[] args) {
        TwoPlayerGame game = new TwoPlayerGame("saurabh", "bot");
        Scanner scanner = new Scanner(System.in);

        int playerToMove = 1;
        Position source = new Position(-1,-1);
        Position destination = new Position(-1,-1);
        System.out.println("Enter move in the form : CsrcRsrc CdestRdest, where R and C are rows and columns respectively.\n And r should be a number between 1 and 8 and c a character between a and h.");
        while (!game.isGameOver()) {
            String moveLength = scanner.nextLine();
            String[] movePositions = moveLength.split(" ");
            if(movePositions.length == 2)   {
                if(movePositions[0].length() == 2 && movePositions[1].length() == 2)    {

                    source.setRow(movePositions[0].charAt(1) - '1');
                    source.setColumn(movePositions[0].charAt(0) - 'a');
                    destination.setRow(movePositions[1].charAt(1) - '1');
                    destination.setColumn(movePositions[1].charAt(0) - 'a');

                    if(playerToMove == 1) {
                        if(game.move("saurabh", source, destination))
                            playerToMove = 2;
                    }
                    else {
                        if(game.move("bot", source, destination))
                            playerToMove = 1;
                    }
                }else   {
                    System.out.println("move input is in incorrect form.");
                }
            }else {
                System.out.println("move input is in incorrect form.");
            }
        }

        System.out.println("Game over champs. Good Game!");
    }
}
