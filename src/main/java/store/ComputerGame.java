package store;

public class ComputerGame {
    private static int idcounter = 0;
    private final int id = idcounter++;
    private ComputerGameParams params;

    ComputerGame(ComputerGameParams gameParams) {
        this.params = gameParams;
    }
    int getId() {
        return id;
    }
    ComputerGameParams getParams() {
        return params;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass() || this.params.getTitle() == null) return false;
        ComputerGame that = (ComputerGame) o;
        if (this == o) return true;

        return false;
    }
}
