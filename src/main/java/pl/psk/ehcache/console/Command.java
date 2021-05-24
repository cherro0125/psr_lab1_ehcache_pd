package pl.psk.ehcache.console;

public interface Command {
    void execute(Object... args);
    String getDescription();
}
