package store;

public abstract class User implements Observer {
    @Override
    public abstract boolean update(String msg);
}
