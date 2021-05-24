package pl.psk.ehcache.client.impl;


import net.sf.ehcache.*;
import net.sf.ehcache.config.*;
import net.sf.ehcache.search.Attribute;
import net.sf.ehcache.search.Result;
import pl.psk.ehcache.model.Book;

import java.net.UnknownHostException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class ClientImpl implements pl.psk.ehcache.client.Client {

    private CacheManager cacheManager;
    private Ehcache instance;
    private final String MAP_NAME = "books";
    final private static Random r = new Random(System.currentTimeMillis());


    @Override
    public void start() throws UnknownHostException {

        Configuration cacheManagerConfig = new Configuration();

        CacheConfiguration cacheConfig = new CacheConfiguration(MAP_NAME, 0)
                .eternal(false).logging(true);
        Searchable searchable = new Searchable();
        cacheConfig.addSearchable(searchable);




        searchable.addSearchAttribute(new SearchAttribute().name("name").expression("value.getName()"));


        cacheManagerConfig.addCache(cacheConfig);

        cacheManager = new CacheManager(cacheManagerConfig);
//        cacheManager.getCacheManagerEventListenerRegistry().registerListener(new CacheManagerEventListener(){
//            @Override
//            public void init() throws CacheException {
//
//            }
//
//            @Override
//            public Status getStatus() {
//                 return Status.STATUS_ALIVE;
//            }
//
//            @Override
//            public void dispose() throws CacheException {
//
//            }
//
//            @Override
//            public void notifyCacheAdded(String s) {
//                System.out.println("Cache added ");
//                System.out.println(s);
//            }
//
//            @Override
//            public void notifyCacheRemoved(String s) {
//                System.out.println("Cache removed ");
//                System.out.println(s);
//            }
//        });
        instance = cacheManager.getEhcache(MAP_NAME);
    }


    @Override
    public List<Book> getBooks(String bookName) {
        Collection<Book> books;
        Attribute<String> name = instance.getSearchAttribute("name");
        if (bookName != null && !bookName.isEmpty()) {
            books = instance.createQuery()
                    .includeKeys()
                    .includeValues()
                    .addCriteria(name.ilike(bookName)).execute().all().stream().map(Result::getValue).map(el -> (Book) el).collect(Collectors.toList());

        } else {
            books = instance.getAll(instance.getKeys()).values().stream().map(el -> (Book) el.getObjectValue()).collect(Collectors.toList());
        }

        return new LinkedList<>(books);
    }

    @Override
    public Book getBook(Long id) {
        Element value = instance.get(id);
        return value != null ? (Book) value.getObjectValue(): null;
    }

    @Override
    public void insertBook(Book book) {
        Long id = (long) Math.abs(r.nextInt());
        book.setId(id);
        instance.put(new Element(id, book));
    }

    @Override
    public void deleteBook(Long id) {
        instance.remove(id);
    }

    @Override
    public void deleteAllBooks() {
        instance.removeAll();
    }

    @Override
    public void modifyBook(Long id, Book book) {
        book.setId(id);
        instance.put(new Element(id, book));
    }
}
