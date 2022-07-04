package game;

import java.util.List;

public class GameBasketball extends GameTeam
{
    private static final List<String> playerProperties = List.of("player name", "nickname", "number", "team name", "scored points", "rebounds", "assists");

    public GameBasketball()
    {
        super(GameType.BASKETBALL);
    }

    @Override
    public List<String> getPlayerProperties()
    {
        return GameBasketball.playerProperties;
    }

    @Override
    public void processResults(List<Player> players)
    {
        this.players = players;

        for (Player player : this.players)
        {
            player.increaseProperty("rating points", player.getIntegerProperty("scored points") * 2 + player.getIntegerProperty("rebounds") + player.getIntegerProperty("assists"));
            this.teams.put(player.getProperty("team name"), this.teams.getOrDefault(player.getProperty("team name"), 0) + player.getIntegerProperty("scored points"));
        }

        super.processResults();
    }
}
