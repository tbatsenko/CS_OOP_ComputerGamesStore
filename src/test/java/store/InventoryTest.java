package store;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;

public class InventoryTest {

    private Inventory inventory;
    {
        inventory = new Inventory();
    }

    @Before
    public void setup(){
        System.out.println("Running Test...");
    }

    @Test
    public void addGameWithNullParams() {
        assertFalse(inventory.addGame(null));
        }

    @Test
    public void addGameWithNullTitle() {
        // covers Test ComputerGameParams automatically
        ComputerGameParams gameParams = new ComputerGameParams(null, null, null, null, 0, 0);
        assertFalse(inventory.addGame(gameParams));
    }

    @Test
    public void addGameWithMeaningfullParams() {
        // covers Test GameGenre
        ArrayList<GamesGenre> gameGenres = new ArrayList<>();
        gameGenres.add(GamesGenre.MOBA);

        // covers Test ComputerPlatforms and Platform
        ArrayList<Platform> platfms = new ArrayList<>();
        Platform platform = Platform.MACOS;
        platfms.add(platform);

        String gameTitle = "Super Game";
        HashMap<String, String> gameDescription = new HashMap<>();
        gameDescription.put("year", "2013");
        gameDescription.put("rating", "5/5");

        float gamePrice = (float) 123.45;

        int gameAgeRestriction = 12;

        // covers Test ComputerGame cause addGame calls creation of new ComputerGame
        ComputerGameParams gameParams = new ComputerGameParams(gameGenres, platfms, gameTitle, gameDescription, gamePrice,gameAgeRestriction);
        assertTrue(inventory.addGame(gameParams));
    }


    @Test
    public void getGameWithUnexistingID() throws Exception {
        assertNull(inventory.getGame(123));
    }

    @Test
    public void getGameWithExistingID() throws Exception {
        ArrayList<GamesGenre> gameGenres = new ArrayList<>();
        gameGenres.add(GamesGenre.MOBA);

        ArrayList<Platform> platfms = new ArrayList<>();
        Platform platform = Platform.MACOS;
        platfms.add(platform);

        String gameTitle = "Super Game";
        HashMap<String, String> gameDescription = new HashMap<>();
        gameDescription.put("year", "2013");
        gameDescription.put("rating", "5/5");

        float gamePrice = (float) 123.45;

        int gameAgeRestriction = 12;


        ComputerGameParams gameParams = new ComputerGameParams(gameGenres, platfms, gameTitle,
                gameDescription, gamePrice,gameAgeRestriction);


        inventory.addGame(gameParams);

        assertEquals(inventory.getGame(0),  inventory.games.get(0));
    }

    @Test
    public void searchGameWithNullParams() throws Exception {
        // covers Test ComputerGameParams matches method automatically cause search covers it
        ComputerGameParams gameParams = new ComputerGameParams(null, null, null, null,
                0, 0);

        ArrayList<ComputerGame> emptyList = new ArrayList<>();
        assertEquals(inventory.search(gameParams), emptyList);
    }
}
