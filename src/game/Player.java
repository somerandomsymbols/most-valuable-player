package game;

import java.util.HashMap;
import java.util.Map;

public class Player
{
    private Map<String, String> properties;

    public Player()
    {
        this.properties = new HashMap<String, String>();
    }

    public Player(Map<String, String> properties)
    {
        this.properties = properties;
    }

    public Map<String, String> getProperties()
    {
        return this.properties;
    }

    public String getProperty(String propertyName)
    {
        return this.properties.get(propertyName);
    }

    public Integer getIntegerProperty(String propertyName)
    {
        String property = this.getProperty(propertyName);

        if (property == null)
            return null;
        else
            return Integer.valueOf(property);
    }

    public void setProperty(String propertyName, Object value)
    {
        this.properties.put(propertyName, String.valueOf(value));
    }

    public void increaseProperty(String propertyName, int value)
    {
        Integer property = this.getIntegerProperty(propertyName);

        if (property == null)
            this.setProperty(propertyName, value);
        else
            this.setProperty(propertyName, property + value);
    }

    @Override
    public String toString() {
        return "Player{" +
                "properties=" + properties +
                '}';
    }
}
