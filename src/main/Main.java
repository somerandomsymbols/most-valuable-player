package main;

import game.Game;
import input.CSVReader;
import input.CSVReaderException;
import tournament.Tournament;
import tournament.TournamentException;

import java.io.IOException;

public class Main
{
    public static void main(String[] args)
    {
        try
        {
            String winner = Tournament.getWinner("tournament");

            if (winner != null)
                System.out.println("Winner is " + winner);
            else
                System.out.println("Winner cannot be determined");
        }
        catch (TournamentException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
