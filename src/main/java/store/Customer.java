package store;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Customer extends User{
    // TODO divide into different packages
    public List<Message> msgs;
    private String name;

    Customer(String name) {
        msgs = new ArrayList<>();
        this.name = name;
    }


    @Override
    public boolean update(String msg) {
        msgs.add(new Message(msg));
        System.out.println("Customer " + name + " just got a new msg with content: " + msg);
        return true;
    }
}
