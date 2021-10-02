package controller;

import model.BBMAP;
import model.Model;
import model.State;
import view.PropertiesTextConstants;
import view.View;

import java.util.*;

public class Controller implements PropertiesTextConstants {
    private final View view;
    private final Model model;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void inputNote() {
        Scanner scanner = new Scanner(System.in);
        configureLanguage(scanner);
        fillModel(scanner);
        view.printMessage(LINE_BREAK);
        printModel();
        view.printMessage(LINE_BREAK);
        editModel(scanner);
    }

    public void editModel(Scanner scanner) {
        view.printMessage(view.getString(INPUT_QUESTION) + LINE_BREAK +
                view.getString(INPUT_CHOICE) + DD + LINE_BREAK +
                INPUT_ARCHER_POINTER);
        String answer = scanner.nextLine().trim();
        while (!answer.equals(view.getString(N))) {
            if (answer.equals(view.getString(Y))) {
                view.printMessage(LINE_BREAK);
                view.printlnMessage(view.getString(INPUT_QUESTION1));
                printProposition();
                view.printMessage(INPUT_ARCHER_POINTER);
                view.printMessage(LINE_BREAK);
                String ans = scanner.nextLine().trim();
                while (!ans.matches(view.getString(CHECKING_PROPOSITION))) {
                    view.printlnMessage(view.getString(INPUT_WRONG));
                    view.printMessage(INPUT_ARCHER_POINTER);
                    ans = scanner.nextLine().trim();
                }
                inputStringRegexCheck(scanner, State.values()[Integer.parseInt(ans)]);
                view.printMessage(LINE_BREAK);
                printModel();
                view.printMessage(LINE_BREAK);
                view.printMessage(view.getString(INPUT_QUESTION) + LINE_BREAK +
                        view.getString(INPUT_CHOICE) + DD + LINE_BREAK +
                        INPUT_ARCHER_POINTER);
            } else {
                view.printlnMessage(view.getString(INPUT_WRONG));
                view.printMessage(INPUT_ARCHER_POINTER);
            }
            answer = scanner.nextLine();
        }
        view.printMessage(LINE_BREAK);
        view.printlnMessage(view.getString(INPUT_READY));
    }

    public void fillModel(Scanner scanner) {
        boolean fnIsShowed = true, faIsShowed = true;
        for (State state : State.values()) {
            inputStringRegexCheck(scanner, state);
            if (fnIsShowed && model.hasFullName()) {
                view.printConcatenatedStringSpace(
                        view.getString(INPUT_FULL_NAME), DD,
                        String.valueOf(model.getFullName()));
                fnIsShowed = false;
            }
            if (faIsShowed && model.hasFullAddress()) {
                view.printConcatenatedStringSpace(
                        view.getString(INPUT_FULL_ADDRESS), DD,
                        String.valueOf(model.getFullAddress()));
                faIsShowed = false;
            }
        }
        view.printMessage(LINE_BREAK);
        view.printlnMessage(view.getString(INPUT_GREETING));
    }

    public void inputStringRegexCheck(Scanner scanner, State state) {
        String regex = BBMAP.findRegex(state);
        String message = BBMAP.findInput(state);
        view.printStringInput(message, regex);
        while (!setFieldValue(state, scanner.nextLine().trim())) {
            view.printWrongStringInput(message, regex);
        }
    }

    public void configureLanguage(Scanner scanner) {
        view.printlnMessage(INPUT_ENTER_LANGUAGE_ON_UA);
        view.printConcatenatedString(OR_UA, F, OR, S);
        view.printlnMessage(INPUT_ENTER_LANGUAGE_ON_EN);
        view.printMessage(INPUT_ARCHER_POINTER);
        while (!scanner.hasNext(EN) && !scanner.hasNext(UA)) {
            view.printlnMessage(INPUT_WRONG_SETUP_UA);
            view.printlnMessage(INPUT_WRONG_SETUP_EN);
            view.printMessage(INPUT_ARCHER_POINTER);
            scanner.nextLine();
        }
        view.configureResourceBungle(scanner.nextLine().trim());
    }

    public boolean setFieldValue(State state, String string) {
        boolean flag = false;
        for (State s : State.values())
            if (s.equals(state)) {
                String pattern = view.getString(BBMAP.findRegex(state));
                flag = model.checkString(string, pattern, state);
                break;
            }
        return flag;
    }

    public void printModel() {
        view.printConcatenatedString(
                view.concatenateStringSpace(view.getString(INPUT_FULL_NAME), DD, String.valueOf(model.getFullName())) + LINE_BREAK,
                view.concatenateStringSpace(view.getString(INPUT_FULL_NICKNAME), DD, model.getNickname()) + LINE_BREAK,
                view.concatenateStringSpace(view.getString(INPUT_FULL_COMMENT), DD, model.getComment()) + LINE_BREAK,
                view.concatenateStringSpace(view.getString(INPUT_FULL_GROUP), DD, String.valueOf(model.getGroup())) + LINE_BREAK,
                view.concatenateStringSpace(view.getString(INPUT_FULL_HOME_TELEPHONE_NUMBER), DD, model.getHomeTelephoneNumber()) + LINE_BREAK,
                view.concatenateStringSpace(view.getString(INPUT_FULL_MOBILE_TELEPHONE_NUMBER), DD, model.getMobileTelephoneNumber()) + LINE_BREAK,
                view.concatenateStringSpace(view.getString(INPUT_FULL_SECOND_MOBILE_TELEPHONE_NUMBER), DD, model.getSecondMobileTelephoneNumber()) + LINE_BREAK,
                view.concatenateStringSpace(view.getString(INPUT_FULL_EMAIL), DD, model.getEmail()) + LINE_BREAK,
                view.concatenateStringSpace(view.getString(INPUT_FULL_SKYPE), DD, model.getSkype()) + LINE_BREAK,
                view.concatenateStringSpace(view.getString(INPUT_FULL_ADDRESS), DD, String.valueOf(model.getFullAddress())) + LINE_BREAK,
                view.concatenateStringSpace(view.getString(INPUT_FULL_DATE_OF_CREATION), DD, String.valueOf(model.getFullDateOfCreation())) + LINE_BREAK,
                view.concatenateStringSpace(view.getString(INPUT_FULL_DATE_OF_EDITING), DD, model.isEdited() ? String.valueOf(model.getFullDateOfEditing()) : ""));
    }

    public void printProposition() {
        int i = 0;
        for (Map.Entry<State, String> set : BBMAP.STATE_INPUT.entrySet()) {
            StringBuilder sb = new StringBuilder(view.getString(set.getValue()));
            sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
            sb.reverse().replace(0, 10, "").reverse();
            view.printlnMessage(view.concatenateStringSpace(sb.toString(), view.concatenateString(F, String.valueOf(i++), S)));
        }
    }
}
