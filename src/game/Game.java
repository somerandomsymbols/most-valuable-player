package game;

import java.util.*;

public abstract class Game
{
    private final GameType gameType;
    protected List<Player> players;
    protected String winner;

    public Game(GameType gameType)
    {
        this.gameType = gameType;
    }

    public final GameType getGameType()
    {
        return this.gameType;
    }

    public final List<Player> getPlayers()
    {
        return this.players;
    }

    public final String getWinner()
    {
        return this.winner;
    }

    public abstract List<String> getPlayerProperties();

    public abstract void processResults(List<Player> players);


}
