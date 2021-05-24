package pl.psk.ehcache.console.impl;

import pl.psk.ehcache.client.Client;
import pl.psk.ehcache.console.Command;

public class RemoveAllBooksCommand implements Command {
    @Override
    public void execute(Object... args) {
        if(args.length != 0 && args[0] instanceof Client){
            Client client = (Client) args[0];
            client.deleteAllBooks();
            System.out.println("DELETED ALL RECORDS");
        }
    }

    @Override
    public String getDescription() {
        return "Remove all books";
    }
}
