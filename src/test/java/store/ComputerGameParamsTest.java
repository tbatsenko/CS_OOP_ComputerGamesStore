package store;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;

public class ComputerGameParamsTest {
    private ComputerGameParams testParams;
    {
        testParams = new ComputerGameParams(null, null, null, null, 0, 0);
    }

    @Before
    public void setup(){
        System.out.println("Running Game Params Test...");
    }

    @Test
    public void matchNullParams() {
        ComputerGameParams searchParams = new ComputerGameParams(null, null, null, null, 0, 0);
        assertFalse(testParams.matches(searchParams));
    }

    @Test
    public void matchWithNullTitle() {
        ArrayList<GamesGenre> gameGenres = new ArrayList<>();
        gameGenres.add(GamesGenre.MOBA);

        // covers Test ComputerGameParams automatically
        ArrayList<Platform> gamePlatforms = new ArrayList<>();
        gamePlatforms.add(Platform.WINDOWS);

        HashMap<String, String> gameDescription = new HashMap<>();
        gameDescription.put("year", "2013");
        gameDescription.put("rating", "5/5");

        float gamePrice = (float) 123.45;

        int gameAgeRestriction = 12;

        ComputerGameParams searchParams = new ComputerGameParams(gameGenres, gamePlatforms, null, gameDescription, gamePrice,gameAgeRestriction);
        assertFalse(testParams.matches(searchParams));
    }

    @Test
    public void addGameWithMeaningfullParams() {
        HashMap<String, String> gameDescription = new HashMap<>();
        gameDescription.put("year", "2013");
        gameDescription.put("rating", "5/5");


        // covers Test GameGenre
        ArrayList<GamesGenre> gameGenres = new ArrayList<>();
        gameGenres.add(GamesGenre.MOBA);

        // covers Test ComputerPlatforms and Platform
        ArrayList<Platform> platfms = new ArrayList<>();
        Platform platform = Platform.MACOS;
        platfms.add(platform);

        String gameTitle = "Super Game";


        float gamePrice = (float) 123.45;

        int gameAgeRestriction = 12;

        testParams.setAgeRestriction(9);
        testParams.setTitle("Super Game");
        testParams.setPrice(100);
        testParams.setDescription(gameDescription);
        testParams.setGenres(gameGenres);
        testParams.setPlatforms(platfms);

        ComputerGameParams searchParams = new ComputerGameParams(gameGenres, platfms, gameTitle, gameDescription, gamePrice,gameAgeRestriction);
        assertTrue(testParams.matches(searchParams));
    }

}
