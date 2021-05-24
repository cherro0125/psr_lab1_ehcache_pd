package pl.psk.ehcache.console.impl;

import pl.psk.ehcache.client.Client;
import pl.psk.ehcache.console.Command;
import pl.psk.ehcache.model.Author;
import pl.psk.ehcache.model.Book;
import pl.psk.ehcache.model.Category;

import java.util.Arrays;
import java.util.Date;

public class AddExampleBooksCommand implements Command {
    @Override
    public void execute(Object... args) {
        if(args.length != 0 && args[0] instanceof Client){
            Client client = (Client) args[0];
            Author author = new Author("George","Martin",50);
            Book book = new Book(0L,"Pieśń lodu i ognia",new Date(), Arrays.asList(Category.ADVENTURE,Category.NOVEL,Category.SCI_FI),author);
            Author author2 = new Author("John","Tolkien",89);
            Book book2 = new Book(0L,"Władca pierścieni",new Date(), Arrays.asList(Category.ADVENTURE,Category.SCI_FI),author2);
            Author author3 = new Author("Joanne","Rowling",55);
            Book book3 = new Book(0L,"Harry Potter i Więzień Azkabanu",new Date(), Arrays.asList(Category.ADVENTURE,Category.SCI_FI),author3);
            client.insertBook(book);
            client.insertBook(book2);
            client.insertBook(book3);
        }
    }

    @Override
    public String getDescription() {
        return "Add example books";
    }
}
