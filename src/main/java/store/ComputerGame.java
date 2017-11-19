package store;

public class ComputerGame {

    private static int idcounter = 0;

    private final int id = idcounter++;

    public ComputerGameParams params;

    public ComputerGame(ComputerGameParams gameParams) {
        this.params = gameParams;
    }

    public int getId() {
        return id;
    }

    public ComputerGameParams getParams() {
        return params;
    }

    public void setParams(ComputerGameParams params) {
        this.params = params;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ComputerGame that = (ComputerGame) o;

        return id == that.id;
    }
}
