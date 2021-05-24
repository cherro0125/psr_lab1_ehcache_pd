package pl.psk.ehcache.console.impl;



import pl.psk.ehcache.client.Client;
import pl.psk.ehcache.console.Command;
import pl.psk.ehcache.console.util.ConsoleUtils;

public class AdvanceSearchCommand implements Command {
    @Override
    public void execute(Object... args) {
        if(args.length != 0 && args[0] instanceof Client){
            Client client = (Client) args[0];
            System.out.println("Type book name (type * if you don't know exact book title):");
            String name = ConsoleUtils.readConsoleString();
            client.getBooks(name).forEach(book -> {
                ConsoleUtils.printGreen(String.format("\nID: %d {\n%s\n}\n%n",book.getId(),book.toString()));
            });
        }
    }

    @Override
    public String getDescription() {
        return "ADVANCE SEARCH BOOK";
    }
}
