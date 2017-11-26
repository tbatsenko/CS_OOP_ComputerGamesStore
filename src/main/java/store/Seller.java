package store;

import java.util.ArrayList;
import java.util.List;

public class Seller extends User{
    public List<Message> msgs;
    private String sellerName;

    public Seller(String name) {
        msgs = new ArrayList<>();
        this.sellerName = name;
    }


    @Override
    public boolean update(String msg) {
        msgs.add(new Message(msg));
        System.out.println("Seller " + sellerName + " just got a new msg with a content: " + msg);
        return true;
    }
}
