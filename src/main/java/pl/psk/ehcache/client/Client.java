package pl.psk.ehcache.client;


import pl.psk.ehcache.model.Book;

import java.net.UnknownHostException;
import java.util.List;

public interface Client {
    void start() throws UnknownHostException;
    List<Book> getBooks(String name);
    Book getBook(Long id);
    void insertBook(Book book);
    void deleteBook(Long id);
    void deleteAllBooks();
    void modifyBook(Long id, Book book);
}
