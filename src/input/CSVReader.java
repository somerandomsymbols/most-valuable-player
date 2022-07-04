package input;

import game.*;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

public class CSVReader
{
    public static Game readGame(File file) throws IOException, CSVReaderException
    {
        Game game;
        GameType gameType;
        List<Player> players = new ArrayList<Player>();
        FileReader fileReader = new FileReader(file);
        Scanner scanner = new Scanner(fileReader);

        if (!scanner.hasNextLine())
            throw new CSVReaderException("File \"" + file.getName() + "\" is empty");

        try
        {
            gameType = GameType.valueOf(scanner.nextLine());
        }
        catch (IllegalArgumentException e)
        {
            throw new CSVReaderException("Unsupported game type in file \"" + file.getName() + "\"");
        }

        switch (gameType)
        {
            case BASKETBALL:
                game = new GameBasketball();
                break;
            case HANDBALL:
                game = new GameHandball();
                break;
            default:
                throw new CSVReaderException("Unsupported game type in file \"" + file.getName() + "\"");
        }

        List<String> playerProperties = game.getPlayerProperties();


        while (scanner.hasNextLine())
        {
            String nextLine = scanner.nextLine();
            List<String> propertiesList = List.of(nextLine.split(";"));

            if (propertiesList.size() != playerProperties.size())
                throw new CSVReaderException("Incorrect parameters number in file \"" + file.getName() + "\"");

            Map<String, String> propertiesMap = new HashMap<String, String>();

            for (int i = 0; i < propertiesList.size(); ++i)
            {
                String property = propertiesList.get(i);
                if (property == null || property.isEmpty())
                    throw new CSVReaderException("Parameter \"" + playerProperties.get(i) + "\" in file \"" + file.getName() + "\" is null");
                propertiesMap.put(playerProperties.get(i), property);
            }


            players.add(new Player(propertiesMap));
        }

        fileReader.close();
        game.processResults(players);
        return game;
    }
}
