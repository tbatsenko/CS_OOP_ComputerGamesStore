package store;

import java.util.ArrayList;

public class Inventory {
    public ArrayList<ComputerGame> games;

    public Inventory() {
        games = new ArrayList<ComputerGame>();
    }

    public boolean addGame(ComputerGameParams gameParams){
        if (gameParams == null) return false;
        if (gameParams.getTitle() == null) return false;
        ComputerGame newGame = new ComputerGame(gameParams);
        games.add(newGame);
        return true;
    }

    public ComputerGame getGame(int id){
        for (ComputerGame game : games) {
            if (game.getId() == id) {
                return game;
            }
        }
        return null;
    }



    public ArrayList<ComputerGame> search(ComputerGameParams searchParams){

        ArrayList<ComputerGame> result = new ArrayList<ComputerGame>();

        for (ComputerGame game : games) {
            if (game.getParams().matches(searchParams)) {
                result.add(game);
            }
        }

        return result;

    }
}
