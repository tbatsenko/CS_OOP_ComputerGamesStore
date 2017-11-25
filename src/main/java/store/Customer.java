package store;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Customer implements Observer{
    // TODO divide into different packages
    public List<Message> msgs;

    public  Customer() {
        msgs = new ArrayList<>();
    }


    @Override
    public boolean update(String msg) {
        msgs.add(new Message(msg));
        return true;
    }
}
