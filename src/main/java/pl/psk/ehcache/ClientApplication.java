package pl.psk.ehcache;

import pl.psk.ehcache.client.Client;
import pl.psk.ehcache.client.impl.ClientImpl;
import pl.psk.ehcache.console.menu.MenuHandler;

import java.net.UnknownHostException;

public class ClientApplication {
    public static void main(String[] args) throws UnknownHostException {
        Client client = new ClientImpl();
        client.start();
        MenuHandler menuHandler = new MenuHandler(client);
        menuHandler.start();
    }
}
