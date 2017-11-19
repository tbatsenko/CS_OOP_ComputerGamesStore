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

//    public ComputerGameParams(ArrayList<GamesGenre> gameGenres, ArrayList<ComputerPlatforms.Platform> platforms, String gameTitle, HashMap<String, String> gameDescription, float gamePrice, int gameAgeRestriction) {
//    }


    String getTitle() {
        return title;
    }

    void setTitle(String title) {
        this.title = title;
    }

    public HashMap<String, String> getDescription() {
        return description;
    }

    void setDescription(HashMap<String, String> description) {
        this.description = description;
    }

    private float getPrice() {
        return price;
    }

    void setPrice(float price) {
        this.price = price;
    }

    private int getAgeRestriction() {
        return ageRestriction;
    }

    void setAgeRestriction(int ageRestriction) {
        this.ageRestriction = ageRestriction;
    }

    private ArrayList<GamesGenre> getGenres() {
        return genres;
    }

    public void setGenres(ArrayList<GamesGenre> genres) {
        this.genres = genres;
    }

    public void setPlatforms(ArrayList<ComputerPlatforms.Platform> platforms) {
        this.platforms = platforms;
    }

    private ArrayList<ComputerPlatforms.Platform> getPlatforms() {
        return platforms;

    }

    ComputerGameParams(ArrayList<GamesGenre> genres, ArrayList<ComputerPlatforms.Platform> platforms, String title, HashMap<String, String> description, float price, int ageRestriction) {
        this.genres = genres;
        this.platforms = platforms;

        this.title = title;
        this.description = description;
        this.price = price;
        this.ageRestriction = ageRestriction;
    }


    boolean matches(ComputerGameParams searchParams) {
        if (searchParams.getGenres() == null){
            return false;
        }
        ArrayList<GamesGenre> geners = getGenres();
        if ( geners == null || geners.isEmpty() || !geners.containsAll(searchParams.getGenres())) {
            return false;
        }

        ArrayList<ComputerPlatforms.Platform> platforms = getPlatforms();
        if (platforms.isEmpty() && !platforms.containsAll(searchParams.getGenres())) {
            return false;
        }

        String title = getTitle();
        if ((title == null) || (title.equals("")) || (!title.equals(searchParams.getTitle()))) {
            return false;
        }

        float price = getPrice();
        if (price > searchParams.getPrice()) {
            return false;
        }

        int ageRestriction = getAgeRestriction();
        return ageRestriction <= searchParams.getAgeRestriction();
    }
}
