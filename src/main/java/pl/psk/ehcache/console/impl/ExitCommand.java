package pl.psk.ehcache.console.impl;

import lombok.SneakyThrows;
import pl.psk.ehcache.console.Command;
import pl.psk.ehcache.console.menu.MenuHandler;

public class ExitCommand implements Command {
    @SneakyThrows
    @Override
    public void execute(Object... args) {
        MenuHandler.exitMenu();
        System.out.println("BYE BYE!");
        Thread.sleep(1500);
        System.exit(0);
    }

    @Override
    public String getDescription() {
        return "EXIT";
    }
}
