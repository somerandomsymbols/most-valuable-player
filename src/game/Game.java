package game;

import java.util.*;

public class Game
{
    private final GameType gameType;
    private List<Player> players;
    private Map<String, Integer> teams;
    private String winner;

    public Game(GameType gameType, List<Player> players)
    {
        this.gameType = gameType;
        this.players = players;
        this.processResults();
    }

    public GameType getGameType()
    {
        return gameType;
    }

    public List<Player> getPlayers()
    {
        return players;
    }

    public Map<String, Integer> getTeams()
    {
        return teams;
    }

    public String getWinner()
    {
        if (winner == null)
            return "None";

        return winner;
    }

    private void processResultsBasketball()
    {
        this.teams = new HashMap<>();

        for (Player player : this.players)
        {
            player.addRatingPoints(player.getScoredPoints() * 2 + player.getRebounds() + player.getAssists());
            this.teams.put(player.getTeamName(), this.teams.getOrDefault(player.getTeamName(), 0) + player.getScoredPoints());
        }

        this.determineTeamWinner();
    }

    private void processResultsHandball()
    {
        this.teams = new HashMap<>();

        for (Player player : this.players)
        {
            player.addRatingPoints(player.getGoalsMade() * 2 - player.getGoalsReceived());
            this.teams.put(player.getTeamName(), this.teams.getOrDefault(player.getTeamName(), 0) + player.getGoalsMade());
        }

        this.determineTeamWinner();
    }

    private void determineTeamWinner()
    {
        this.winner = null;
        int winnerScore = 0;

        for (Map.Entry<String, Integer> teamScore : this.teams.entrySet())
        {
            if (teamScore.getValue() > winnerScore)
            {
                this.winner = teamScore.getKey();
                winnerScore = teamScore.getValue();
            }
            else if (teamScore.getValue() == winnerScore)
                this.winner = null;
        }

        if (this.winner != null)
            for (Player player : this.players)
                if (player.getTeamName().equals(this.winner))
                    player.addRatingPoints(10);
    }

    private void processResults()
    {
        switch (this.gameType)
        {
            case BASKETBALL:
                this.processResultsBasketball();
                break;
            case HANDBALL:
                this.processResultsHandball();
                break;
        }
    }
}
