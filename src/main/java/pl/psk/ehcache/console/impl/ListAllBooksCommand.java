package pl.psk.ehcache.console.impl;


import pl.psk.ehcache.client.Client;
import pl.psk.ehcache.console.Command;
import pl.psk.ehcache.console.util.ConsoleUtils;

public class ListAllBooksCommand implements Command {
    @Override
    public void execute(Object... args) {
        if(args.length != 0 && args[0] instanceof Client){
            Client client = (Client) args[0];
            client.getBooks(null).forEach(book -> {
                System.out.println("---------------");
                ConsoleUtils.printGreen(String.format("\nID: %d {\n%s\n}\n%n",book.getId(),book.toString()));
                System.out.println("---------------");
            });
        }
    }

    @Override
    public String getDescription() {
        return "Show all books";
    }
}
