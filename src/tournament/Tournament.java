package tournament;

import game.Game;
import game.Player;
import input.CSVReader;
import input.CSVReaderException;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Tournament
{
    public static String getWinner(String filepath) throws TournamentException {
        File directory = new File(filepath);
        HashMap<String, Integer> ratingPoints = new HashMap<String, Integer>();
        File[] files = directory.listFiles();

        if (files == null)
        {
            throw new TournamentException("Directory \"" + filepath + "\" is missing");
        }

        for (File file : files)
        {
            if (file.isFile())
            {
                try
                {
                    Game game = CSVReader.readGame(file);

                    for (Player player : game.getPlayers())
                    {
                        String nickname = player.getProperty("nickname");

                        ratingPoints.put(nickname, ratingPoints.getOrDefault(nickname, 0) + player.getIntegerProperty("rating points"));
                    }
                }
                catch (CSVReaderException e)
                {
                    System.out.println(e.getMessage());
                }
                catch (IOException e)
                {
                    System.out.println("IOException while reading a file");
                }
            }
        }

        StringBuilder mvp = new StringBuilder();
        int rating = Integer.MIN_VALUE;

        for (Map.Entry<String, Integer> entry : ratingPoints.entrySet())
        {
            if (entry.getValue() > rating)
            {
                mvp = new StringBuilder(entry.getKey());
                rating = entry.getValue();
            }
            else if (entry.getValue() == rating)
                mvp.append("; ").append(entry.getKey());
        }

        if (mvp.length() > 0)
            return mvp.toString();
        else
            return null;
    }
}
