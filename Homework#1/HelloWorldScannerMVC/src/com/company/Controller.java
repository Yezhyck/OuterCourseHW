package com.company;

import java.util.Scanner;

public class Controller {
    private final Model model;
    private final View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void processUser() {
        Scanner scanner = new Scanner(System.in);
        model.setSentence(inputStringValueWithScanner(scanner));
        view.printMessage(View.OK_HERE_YOUR_SENTENCE);
        view.printMessage(model.getSentence());
    }

    private String inputStringValueWithScanner(Scanner scanner) {
        String sentence = null, hello, world;
        boolean flag = true;
        view.printMessage(View.HELLO_PLEASE_FIRSTLY_ENTER_AND_SECONDLY_ENTER_WORLD);
        while (flag) {
            hello = scanner.next();
            if (hello.equals(Model.HELLO)) {
                view.printMessage(View.OK_NOW_ENTER_WORLD);
                while (flag) {
                    world = scanner.next();
                    if (world.equals(Model.WORLD)) {
                        flag = false;
                        sentence = hello + " " + world;
                    } else view.printMessageAndString(View.ERROR, world, View.DOES_NON_EQUALS, Model.WORLD);
                }
            } else view.printMessageAndString(View.ERROR, hello, View.DOES_NON_EQUALS, Model.HELLO);
        }
        return sentence;
    }
}
