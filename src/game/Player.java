package game;

public class Player
{
    private String playerName;
    private String nickname;
    private int number;
    private String teamName;

    private int scoredPoints;
    private int rebounds;
    private int assists;

    private int goalsMade;
    private int goalsReceived;

    private int ratingPoints;

    public Player(String playerName, String nickname, int number, String teamName, int scoredPoints, int rebounds, int assists)
    {
        this.playerName = playerName;
        this.nickname = nickname;
        this.number = number;
        this.teamName = teamName;
        this.scoredPoints = scoredPoints;
        this.rebounds = rebounds;
        this.assists = assists;
    }

    public Player(String playerName, String nickname, int number, String teamName, int goalsMade, int goalsReceived)
    {
        this.playerName = playerName;
        this.nickname = nickname;
        this.number = number;
        this.teamName = teamName;
        this.goalsMade = goalsMade;
        this.goalsReceived = goalsReceived;
    }

    public String getPlayerName()
    {
        return playerName;
    }

    public void setPlayerName(String playerName)
    {
        this.playerName = playerName;
    }

    public String getNickname()
    {
        return nickname;
    }

    public void setNickname(String nickname)
    {
        this.nickname = nickname;
    }

    public int getNumber()
    {
        return number;
    }

    public void setNumber(int number)
    {
        this.number = number;
    }

    public String getTeamName()
    {
        return teamName;
    }

    public void setTeamName(String teamName)
    {
        this.teamName = teamName;
    }

    public int getScoredPoints() {
        return scoredPoints;
    }

    public void setScoredPoints(int scoredPoints)
    {
        this.scoredPoints = scoredPoints;
    }

    public int getRebounds()
    {
        return rebounds;
    }

    public void setRebounds(int rebounds)
    {
        this.rebounds = rebounds;
    }

    public int getAssists()
    {
        return assists;
    }

    public void setAssists(int assists)
    {
        this.assists = assists;
    }

    public int getGoalsMade()
    {
        return goalsMade;
    }

    public void setGoalsMade(int goalsMade)
    {
        this.goalsMade = goalsMade;
    }

    public int getGoalsReceived()
    {
        return goalsReceived;
    }

    public void setGoalsReceived(int goalsReceived)
    {
        this.goalsReceived = goalsReceived;
    }

    public int getRatingPoints()
    {
        return ratingPoints;
    }

    public void setRatingPoints(int ratingPoints)
    {
        this.ratingPoints = ratingPoints;
    }

    public void addRatingPoints(int ratingPoints)
    {
        this.ratingPoints += ratingPoints;
    }
}
