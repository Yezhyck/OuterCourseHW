package view;

import java.util.Locale;
import java.util.ResourceBundle;

public class View implements PropertiesTextConstants {
    public static String MESSAGE_BUNDLE_NAME = "message";
    public static ResourceBundle resourceBundle;

    public void printMessage(String message) {
        System.out.print(message);
    }

    public void printlnMessage(String message) { System.out.println(message); }

    public String concatenateStringSpace(String... message) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : message) stringBuilder.append(s).append(" ");
        return stringBuilder.toString();
    }

    public String concatenateString(String... message) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : message) stringBuilder.append(s);
        return stringBuilder.toString();
    }

    public void printStringInput(String message, String format) {
        printMessage(concatenateStringSpace(
                getString(INPUT_ENTER),
                getString(message),
                getString(format)) +
                LINE_BREAK +
                INPUT_ARCHER_POINTER);
    }

    public void printWrongStringInput(String message, String format) {
        printMessage(concatenateStringSpace(
                getString(INPUT_WRONG) +
                LINE_BREAK +
                getString(INPUT_ENTER),
                getString(message),
                getString(format)) +
                LINE_BREAK +
                INPUT_ARCHER_POINTER);
    }

    public void printConcatenatedStringSpace(String... args) {
        printlnMessage(concatenateStringSpace(args));
    }

    public void printConcatenatedString(String... args) {
        printlnMessage(concatenateString(args));
    }

    public void configureResourceBungle(String language) {
        resourceBundle = ResourceBundle.getBundle(MESSAGE_BUNDLE_NAME, new Locale(language.trim()));
    }

    public String getString(String resource) {
        return View.resourceBundle.getString(resource);
    }
}
