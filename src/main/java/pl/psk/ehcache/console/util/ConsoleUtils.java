package pl.psk.ehcache.console.util;

import java.util.Scanner;

public class ConsoleUtils {

    private static final String GREEN_BOLD = "\033[1;32m";

    private static final String RED_BOLD = "\033[1;31m";

    private static final String RESET = "\033[0m";

    private static final String BLUE_BOLD = "\033[1;34m";

    private static void printColor(String color, String text){
        System.out.println(String.format("%s %s %s",color,text,RESET));
    }

    public static void printGreen(String text){
        printColor(GREEN_BOLD,text);
    }

    public static void printRed(String text){
        printColor(RED_BOLD,text);
    }

    public static void printBlue(String text){
        printColor(BLUE_BOLD,text);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static int readConsoleValue() {
        return Integer.parseInt(scanner.nextLine());
    }

    public static String readConsoleString(){
        return scanner.nextLine();
    }
}
