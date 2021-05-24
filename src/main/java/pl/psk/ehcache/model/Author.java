package pl.psk.ehcache.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.psk.ehcache.console.util.ConsoleUtils;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Author implements Serializable {
    private String name;
    private String surname;
    private Integer age;

    @Override
    public String toString() {
        return new StringBuilder()
                .append(String.format("Name => %s",this.name))
                .append("\n")
                .append(String.format("Surname => %s",this.surname))
                .append("\n")
                .append(String.format("Age => %d",this.age))
                .append("\n")
                .toString();
    }

    public static Author getFromConsole(){
        System.out.println("Author Name:");
        String name = ConsoleUtils.readConsoleString();
        System.out.println("Author surname");
        String surname = ConsoleUtils.readConsoleString();
        System.out.println("Author age:");
        int age = ConsoleUtils.readConsoleValue();
        Author author = new Author(name, surname, age);
        return author;
    }
}
