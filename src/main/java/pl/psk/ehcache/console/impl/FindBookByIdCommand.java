package pl.psk.ehcache.console.impl;


import pl.psk.ehcache.client.Client;
import pl.psk.ehcache.console.Command;
import pl.psk.ehcache.console.util.ConsoleUtils;
import pl.psk.ehcache.model.Book;

public class FindBookByIdCommand implements Command {
    @Override
    public void execute(Object... args) {
        if(args.length != 0 && args[0] instanceof Client){
            Client client = (Client) args[0];
            System.out.println("Type ID:");
            int value = ConsoleUtils.readConsoleValue();
            Book book = client.getBook((long) value);
            if(book != null){
                ConsoleUtils.printGreen(String.format("Found book : %s\n",book.toString()));
            }else{
                ConsoleUtils.printRed(String.format("Book with ID: %d not found.",value));
            }

        }
    }

    @Override
    public String getDescription() {
        return "Find book by id";
    }
}
