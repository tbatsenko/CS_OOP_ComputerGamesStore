package store;

public enum GamesGenre {
    ACTION("action"), MOBA("moba"), SIMULATION("simulation");

    private String name;

    GamesGenre(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}