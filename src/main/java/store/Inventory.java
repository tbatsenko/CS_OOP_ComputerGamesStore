package store;

import java.util.ArrayList;

class Inventory {
    ArrayList<ComputerGame> games;

    Inventory() {
        games = new ArrayList<>();
    }

    boolean addGame(ComputerGameParams gameParams){
        if (gameParams == null) return false;
        if (gameParams.getTitle() == null) return false;
        ComputerGame newGame = new ComputerGame(gameParams);
        games.add(newGame);
        return true;
    }

    ComputerGame getGame(int id){
        for (ComputerGame game : games)
            if (game.getId() == id) {
                return game;
            }
        return null;
    }



    ArrayList<ComputerGame> search(ComputerGameParams searchParams){

        ArrayList<ComputerGame> result = new ArrayList<>();

        for (ComputerGame game : games) {
            if (game.getParams().matches(searchParams)) {
                result.add(game);
            }
        }

        return result;

    }
}
