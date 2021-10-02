package com.company;

public class View {
    public static final String HELLO_PLEASE_FIRSTLY_ENTER_AND_SECONDLY_ENTER_WORLD = "Hello, please firstly enter \"Hello\":";
    public static final String OK_NOW_ENTER_WORLD = "Ok, now enter \"world!\".";
    public static final String OK_HERE_YOUR_SENTENCE = "Ok, here is your sentence:";
    public static final String ERROR = "Error: ";
    public static final String DOES_NON_EQUALS = " doesn't equals ";

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printMessageAndString(String error, String value, String cause, String example){
        System.out.println(error + value + cause + "\"" + example + "\"" + "!");
    }
}
