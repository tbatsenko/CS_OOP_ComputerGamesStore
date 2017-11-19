package store;

import java.util.ArrayList;
import java.util.HashMap;

public class ComputerGameParams {
    private ArrayList<GamesGenre> genres;
    private ArrayList<ComputerPlatforms.Platform> platforms;


    private String title;
    private HashMap<String, String> description;



    private float price;
    private int ageRestriction;



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public HashMap<String, String> getDescription() {
        return description;
    }

    public void setDescription(HashMap<String, String> description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getAgeRestriction() {
        return ageRestriction;
    }

    public void setAgeRestriction(int ageRestriction) {
        this.ageRestriction = ageRestriction;
    }

    public ArrayList<GamesGenre> getGenres() {
        return new ArrayList<GamesGenre>(genres);
    }

    public ArrayList<ComputerPlatforms.Platform> getPlatforms() {
        return new ArrayList<ComputerPlatforms.Platform>(platforms);
    }

    public ComputerGameParams(ArrayList<GamesGenre> genres, ArrayList<ComputerPlatforms.Platform> platforms, String title, HashMap<String, String> description, float price, int ageRestriction) {
        this.genres = genres;
        this.platforms = platforms;

        this.title = title;
        this.description = description;
        this.price = price;
        this.ageRestriction = ageRestriction;
    }


    public boolean matches(ComputerGameParams searchParams) {
        ArrayList<GamesGenre> geners = getGenres();
        if ((geners != null) && (!geners.isEmpty()) && (!geners.containsAll(searchParams.getGenres()))) {
            return false;
        }

        ArrayList<ComputerPlatforms.Platform> platforms = getPlatforms();
        if ((platforms != null) && (!platforms.isEmpty()) && (!platforms.containsAll(searchParams.getGenres()))) {
            return false;
        }

        String title = getTitle();
        if ((title != null) && (!title.equals("")) && (!title.equals(searchParams.getTitle()))) {
            return false;
        }

        float price = getPrice();
        if (price > searchParams.getPrice()) {
            return false;
        }

        int ageRestriction = getAgeRestriction();
        if (ageRestriction > searchParams.getAgeRestriction()) {
            return false;
        }
        return true;
    }
}
