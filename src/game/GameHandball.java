package game;

import java.util.HashMap;
import java.util.List;

public class GameHandball extends GameTeam
{
    private static final List<String> playerProperties = List.of("player name", "nickname", "number", "team name", "goals made", "goals received");

    public GameHandball()
    {
        super(GameType.HANDBALL);
    }

    @Override
    public List<String> getPlayerProperties()
    {
        return GameHandball.playerProperties;
    }

    @Override
    public void processResults(List<Player> players)
    {
        this.players = players;

        for (Player player : this.players)
        {
            player.increaseProperty("rating points", player.getIntegerProperty("goals made") * 2 - player.getIntegerProperty("goals received"));
            this.teams.put(player.getProperty("team name"), this.teams.getOrDefault(player.getProperty("team name"), 0) + player.getIntegerProperty("goals made"));
        }

        super.processResults();
    }
}
