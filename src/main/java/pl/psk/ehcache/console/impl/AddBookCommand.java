package pl.psk.ehcache.console.impl;


import pl.psk.ehcache.client.Client;
import pl.psk.ehcache.console.Command;
import pl.psk.ehcache.model.Author;
import pl.psk.ehcache.model.Book;

public class AddBookCommand implements Command {
    @Override
    public void execute(Object... args) {
        if(args.length != 0 && args[0] instanceof Client){
            Client client = (Client) args[0];
            Author author = Author.getFromConsole();
            Book book = Book.getFromConsole(author);

            client.insertBook(book);
        }
    }

    @Override
    public String getDescription() {
        return "Add book";
    }
}
