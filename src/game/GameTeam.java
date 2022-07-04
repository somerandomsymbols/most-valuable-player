package game;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class GameTeam extends Game
{
    protected Map<String, Integer> teams = new HashMap<String, Integer>();

    public GameTeam(GameType gameType)
    {
        super(gameType);
    }

    public final Map<String, Integer> getTeams()
    {
        return this.teams;
    }

    protected void processResults()
    {
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
                if (this.winner.equals(player.getProperty("team name")))
                    player.increaseProperty("rating points", 10);
    }
}
