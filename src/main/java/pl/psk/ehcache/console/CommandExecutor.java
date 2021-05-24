package pl.psk.ehcache.console;

import pl.psk.ehcache.console.impl.*;

import java.util.HashMap;

public class CommandExecutor {
    private HashMap<Long,Command> commands;

    public CommandExecutor(HashMap<Long, Command> commands) {
        this.commands = commands;
    }

    public CommandExecutor() {
        this.commands = new HashMap<>();
        commands.put(1L,new ListAllBooksCommand());
        commands.put(2L,new AddBookCommand());
        commands.put(3L,new FindBookByIdCommand());
        commands.put(4L, new EditBookCommand());
        commands.put(5L,new RemoveBookCommand());
        commands.put(6L,new AdvanceSearchCommand());
        commands.put(7L,new RemoveAllBooksCommand());
        commands.put(8L,new AddExampleBooksCommand());
        commands.put(9L,new ExitCommand());
    }

    public void executeCommand(Long id, Object... args){
        commands.get(id).execute(args);
    }

    public String getMenuText(){
        StringBuilder sb = new StringBuilder();
        sb.append("------MENU--------\n");
        commands.forEach((key, value) -> sb.append(String.format("%d.%s\n", key, value.getDescription())));
        sb.append("------------------\n");
        return sb.toString();
    }
}
