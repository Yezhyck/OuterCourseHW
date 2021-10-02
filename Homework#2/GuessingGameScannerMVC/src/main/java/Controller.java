import java.util.Scanner;

public class Controller {
    private final Model model;
    private final View view;

    public Controller(Model inputModel, View inputView) {
        model = inputModel;
        view = inputView;
    }

    public void processUser() {
        Scanner scanner = new Scanner(System.in);
        int choice = determineChoice(scanner);
        if (choice == Model.ONE) configureLimits(scanner);
        else model.setDefaultLimits();
        model.guessTheNumber();
        view.printMessage(View.START_GAME + View.BRACKET_1 + model.getStart() + View.COMA + model.getEnd() + View.BRACKET_2 + View.DOT);
        guessInputNumber(scanner);
    }

    public int determineChoice(Scanner scanner) {
        view.printMessage(View.CHOICE);
        while (!scanner.hasNextInt()) {
            view.printMessage(View.DUTY);
            view.printMessage(View.CHOICE);
            scanner.nextLine();
        }
        int choice = scanner.nextInt();
        if (choice == Model.ONE || choice == Model.TWO) return choice;
        view.printMessage(View.INVALID_CHOICE);
        return determineChoice(scanner);
    }

    public void configureLimits(Scanner scanner) {
        view.printMessage(View.TWO_LIMITS);
        while (true) {
            view.printMessage(View.FIRST);
            while (!scanner.hasNextInt()) {
                view.printMessage(View.DUTY);
                view.printMessage(View.FIRST);
                scanner.next();
            }
            int firstLimit = scanner.nextInt();
            view.printMessage(View.SECOND);
            while (!scanner.hasNextInt()) {
                view.printMessage(View.DUTY);
                view.printMessage(View.SECOND);
                scanner.next();
            }
            int secondLimit = scanner.nextInt();
            model.setCustomLimits(firstLimit, secondLimit);
            if (model.setCustomLimits(firstLimit, secondLimit)) break;
            view.printMessage(View.MORE);
        }
    }

    public void guessInputNumber(Scanner scanner) {
        while (true) {
            while (!scanner.hasNextInt()) {
                view.printMessage(View.DUTY);
                scanner.next();
            }
            int number = scanner.nextInt();
            if (model.checkNumber(number)) {
                String answer = model.updateModel(number);
                if (answer.equals(Model.EQUALS)) {
                    model.configurePlayer(number, answer);
                    view.printMessage(View.STATISTIC);
                    view.printPlayerAttempts(model.getAttempts(), model.getResultOfAttempts());
                    view.printMessage(View.ANSWER + answer + View.DOT);
                    break;
                }
                view.printPlayerAttempts(model.getAttempts(), model.getResultOfAttempts());
                view.printMessage(View.RANGE + View.BRACKET_1 + model.getStart() + View.COMA + model.getEnd() + View.BRACKET_2 + View.DOT);
                view.printMessage(View.ANSWER + answer + View.THAN + number + View.DOT);
                model.configurePlayer(number, answer);
            } else
                view.printMessage(View.INPUT_NUMBER + View.BRACKET_1 + model.getStart() + View.COMA + model.getEnd() + View.BRACKET_2 + View.DOT);
        }
    }
}
