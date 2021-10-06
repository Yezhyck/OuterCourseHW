package controller;

import model.Group;
import model.NoteBook;
import model.NoteBookRecord;
import view.TextConstants;
import view.View;

import java.util.*;

public class Controller {
    private final View view;
    private final Scanner scanner;
    private final NoteBook noteBook;

    public Controller(NoteBook noteBook,  View view) {
        this.view = view;
        this.noteBook = noteBook;
        this.scanner = new Scanner(System.in);
    }

    public void inputNote() {
        NoteBookRecord noteBookRecord = new NoteBookRecord();
        configureLanguage();
        fillModel(noteBookRecord);
        printModel(noteBookRecord);
        editModel(noteBookRecord);
        noteBook.addNoteBookRecord(noteBookRecord);
    }

    public void editModel(NoteBookRecord noteBookRecord) {
        view.printConcatenatedString(view.getString(TextConstants.QUESTION),
                TextConstants.LINE_BREAK, view.getString(TextConstants.CHOICE));
        view.printMessage(TextConstants.ARCHER_POINTER);
        boolean flag = false;
        String answer = scanner.nextLine().trim();
        while (!answer.equals(view.getString(TextConstants.N))) {
            if (answer.equals(view.getString(TextConstants.Y))) {
                printProposition();
                view.printMessage(TextConstants.ARCHER_POINTER);
                String ans = scanner.nextLine().trim();
                while (!ans.matches(view.getString(RegexContainer.PROPOSITION))) {
                    view.printlnMessage(view.getString(TextConstants.WRONG));
                    view.printMessage(TextConstants.ARCHER_POINTER);
                    ans = scanner.nextLine().trim();
                    if (!(Integer.parseInt(ans) < 16)) break;
                }
                switch (Integer.parseInt(ans)) {
                    case 0 -> ssn(noteBookRecord); case 1 -> sfn(noteBookRecord); case 2 -> smn(noteBookRecord);
                    case 3 -> snn(noteBookRecord); case 4 -> scmm(noteBookRecord); case 5 -> sg(noteBookRecord);
                    case 6 -> shtn(noteBookRecord); case 7 -> smtn(noteBookRecord); case 8 -> ssmtn(noteBookRecord);
                    case 9 -> se(noteBookRecord); case 10 -> ss(noteBookRecord); case 11 -> si(noteBookRecord);
                    case 12 -> sct(noteBookRecord); case 13 -> sstr(noteBookRecord); case 14 -> shm(noteBookRecord);
                    case 15 -> ssam(noteBookRecord);
                }
                view.printMessage(TextConstants.LINE_BREAK); printModel(noteBookRecord);
                view.printConcatenatedString(view.getString(TextConstants.QUESTION),
                        TextConstants.LINE_BREAK, view.getString(TextConstants.CHOICE));
                view.printMessage(TextConstants.ARCHER_POINTER);
                flag = true;
            } else
                view.printConcatenatedString(view.getString(TextConstants.WRONG),
                        TextConstants.LINE_BREAK, TextConstants.ARCHER_POINTER);
            answer = scanner.nextLine();
        }
        if (flag)
            view.printConcatenatedString(TextConstants.LINE_BREAK,
                view.getString(TextConstants.READY), TextConstants.LINE_BREAK);
    }

    public void fillModel(NoteBookRecord noteBookRecord) {
        ssn(noteBookRecord); sfn(noteBookRecord); smn(noteBookRecord); noteBookRecord.createFullName();
        view.printConcatenatedStringSpace(view.getString(TextConstants.FULL_NAME),
                TextConstants.DD, String.valueOf(noteBookRecord.getFullName()));
        snn(noteBookRecord); scmm(noteBookRecord); sg(noteBookRecord); shtn(noteBookRecord);
        smtn(noteBookRecord); ssmtn(noteBookRecord); se(noteBookRecord); ss(noteBookRecord);
        si(noteBookRecord); sct(noteBookRecord); sstr(noteBookRecord); shm(noteBookRecord);
        ssam(noteBookRecord); noteBookRecord.createFullAddress();
        view.printConcatenatedStringSpace(view.getString(TextConstants.FULL_ADDRESS), TextConstants.DD,
                String.valueOf(noteBookRecord.getFullAddress()));
        view.printConcatenatedString(TextConstants.LINE_BREAK,
                view.getString(TextConstants.GREETING), TextConstants.LINE_BREAK);
    }

    public void ssn(NoteBookRecord noteBookRecord) { noteBookRecord.setSecondName(inputStringRegexCheck(RegexContainer.NAME_SURNAME_MIDDLE_NAME, TextConstants.SECOND_NAME)); }

    public void sfn(NoteBookRecord noteBookRecord) { noteBookRecord.setFirstName(inputStringRegexCheck(RegexContainer.NAME_SURNAME_MIDDLE_NAME, TextConstants.FIRST_NAME)); }

    public void smn(NoteBookRecord noteBookRecord) { noteBookRecord.setMiddleName(inputStringRegexCheck(RegexContainer.NAME_SURNAME_MIDDLE_NAME, TextConstants.MIDDLE_NAME)); }

    public void snn(NoteBookRecord noteBookRecord) { noteBookRecord.setNickname(inputStringRegexCheck(RegexContainer.SKYPE, TextConstants.NICKNAME)); }

    public void scmm(NoteBookRecord noteBookRecord) { noteBookRecord.setComment(inputStringRegexCheck(RegexContainer.COMMENT, TextConstants.COMMENT)); }

    public void sg(NoteBookRecord noteBookRecord) { noteBookRecord.setGroup(Group.valueOf(inputStringRegexCheck(RegexContainer.GROUP, TextConstants.GROUP))); }

    public void shtn(NoteBookRecord noteBookRecord) { noteBookRecord.setHomeTelephoneNumber(inputStringRegexCheck(RegexContainer.HOME_TELEPHONE_NUMBER, TextConstants.HOME_TELEPHONE_NUMBER)); }

    public void smtn(NoteBookRecord noteBookRecord) { noteBookRecord.setMobileTelephoneNumber(inputStringRegexCheck(RegexContainer.TELEPHONE_NUMBER, TextConstants.MOBILE_TELEPHONE_NUMBER)); }

    public void ssmtn(NoteBookRecord noteBookRecord) { noteBookRecord.setSecondMobileTelephoneNumber(inputStringRegexCheck(RegexContainer.TELEPHONE_NUMBER, TextConstants.SECOND_MOBILE_TELEPHONE_NUMBER)); }

    public void se(NoteBookRecord noteBookRecord) { noteBookRecord.setEmail(inputStringRegexCheck(RegexContainer.EMAIL, TextConstants.EMAIL)); }

    public void ss(NoteBookRecord noteBookRecord) { noteBookRecord.setSkype(inputStringRegexCheck(RegexContainer.SKYPE, TextConstants.SKYPE)); }

    public void si(NoteBookRecord noteBookRecord) { noteBookRecord.setIndex(inputStringRegexCheck(RegexContainer.INDEX, TextConstants.INDEX)); }

    public void sct(NoteBookRecord noteBookRecord) { noteBookRecord.setCity(inputStringRegexCheck(RegexContainer.CITY, TextConstants.CITY)); }

    public void sstr(NoteBookRecord noteBookRecord) { noteBookRecord.setStreet(inputStringRegexCheck(RegexContainer.CITY, TextConstants.STREET)); }

    public void shm(NoteBookRecord noteBookRecord) { noteBookRecord.setHomeNumber(inputStringRegexCheck(RegexContainer.STREET_APARTMENT_NUMBER, TextConstants.HOME_NUMBER)); }

    public void ssam(NoteBookRecord noteBookRecord) { noteBookRecord.setApartmentNumber(inputStringRegexCheck(RegexContainer.STREET_APARTMENT_NUMBER, TextConstants.APARTMENT_NUMBER)); }

    public String inputStringRegexCheck(String regex, String message) {
        view.printStringInput(message, regex);
        String string = scanner.nextLine().trim();
        while (!string.matches(view.getString(regex))) {
            view.printWrongStringInput(message, regex);
            string = scanner.nextLine().trim();
        }
        return string;
    }

    public void configureLanguage() {
        view.printConcatenatedString(TextConstants.ENTER_LANGUAGE_ON_UA, TextConstants.LINE_BREAK,
                TextConstants.OR_UA, TextConstants.F, TextConstants.OR, TextConstants.S, TextConstants.SPACE,
                TextConstants.ENTER_LANGUAGE_ON_EN);
        view.printMessage(TextConstants.ARCHER_POINTER);
        while (!scanner.hasNext(TextConstants.EN) && !scanner.hasNext(TextConstants.UA)) {
            view.printConcatenatedString(TextConstants.WRONG_SETUP_UA, TextConstants.LINE_BREAK,
                    TextConstants.WRONG_SETUP_EN);
            view.printMessage(TextConstants.ARCHER_POINTER);
            scanner.nextLine();
        }
        view.configureResourceBungle(scanner.nextLine().trim());
    }

    public void printModel(NoteBookRecord noteBookRecord) {
        view.printConcatenatedString(
                view.concatenateStringSpace(view.getString(TextConstants.FULL_NAME), TextConstants.DD, String.valueOf(noteBookRecord.getFullName())) + TextConstants.LINE_BREAK,
                view.concatenateStringSpace(cleanString(TextConstants.NICKNAME), TextConstants.DD, noteBookRecord.getNickname()) + TextConstants.LINE_BREAK,
                view.concatenateStringSpace(cleanString(TextConstants.COMMENT), TextConstants.DD, noteBookRecord.getComment()) + TextConstants.LINE_BREAK,
                view.concatenateStringSpace(cleanString(TextConstants.GROUP), TextConstants.DD, String.valueOf(noteBookRecord.getGroup())) + TextConstants.LINE_BREAK,
                view.concatenateStringSpace(cleanString(TextConstants.HOME_TELEPHONE_NUMBER), TextConstants.DD, noteBookRecord.getHomeTelephoneNumber()) + TextConstants.LINE_BREAK,
                view.concatenateStringSpace(cleanString(TextConstants.MOBILE_TELEPHONE_NUMBER), TextConstants.DD, noteBookRecord.getMobileTelephoneNumber()) + TextConstants.LINE_BREAK,
                view.concatenateStringSpace(cleanString(TextConstants.SECOND_MOBILE_TELEPHONE_NUMBER), TextConstants.DD, noteBookRecord.getSecondMobileTelephoneNumber()) + TextConstants.LINE_BREAK,
                view.concatenateStringSpace(cleanString(TextConstants.EMAIL), TextConstants.DD, noteBookRecord.getEmail()) + TextConstants.LINE_BREAK,
                view.concatenateStringSpace(cleanString(TextConstants.SKYPE), TextConstants.DD, noteBookRecord.getSkype()) + TextConstants.LINE_BREAK,
                view.concatenateStringSpace(view.getString(TextConstants.FULL_ADDRESS), TextConstants.DD, String.valueOf(noteBookRecord.getFullAddress())) + TextConstants.LINE_BREAK,
                view.concatenateStringSpace(view.getString(TextConstants.FULL_DATE_OF_CREATION), TextConstants.DD, String.valueOf(noteBookRecord.getFullDateOfCreation())) + TextConstants.LINE_BREAK,
                view.concatenateStringSpace(view.getString(TextConstants.FULL_DATE_OF_EDITING), TextConstants.DD, noteBookRecord.isEdited() ? String.valueOf(noteBookRecord.getFullDateOfEditing()) : ""));
        view.printMessage(TextConstants.LINE_BREAK);
    }

    public void printProposition() {
        view.printConcatenatedString(convertString(TextConstants.SECOND_NAME, 0), TextConstants.LINE_BREAK,
                convertString(TextConstants.FIRST_NAME, 1), TextConstants.LINE_BREAK,
                convertString(TextConstants.MIDDLE_NAME, 2), TextConstants.LINE_BREAK,
                convertString(TextConstants.NICKNAME, 3), TextConstants.LINE_BREAK,
                convertString(TextConstants.COMMENT, 4), TextConstants.LINE_BREAK,
                convertString(TextConstants.GROUP, 5), TextConstants.LINE_BREAK,
                convertString(TextConstants.HOME_TELEPHONE_NUMBER, 6), TextConstants.LINE_BREAK,
                convertString(TextConstants.MOBILE_TELEPHONE_NUMBER, 7), TextConstants.LINE_BREAK,
                convertString(TextConstants.SECOND_MOBILE_TELEPHONE_NUMBER, 8), TextConstants.LINE_BREAK,
                convertString(TextConstants.EMAIL, 9), TextConstants.LINE_BREAK,
                convertString(TextConstants.SKYPE, 10), TextConstants.LINE_BREAK,
                convertString(TextConstants.INDEX, 11), TextConstants.LINE_BREAK,
                convertString(TextConstants.CITY, 12), TextConstants.LINE_BREAK,
                convertString(TextConstants.STREET, 13), TextConstants.LINE_BREAK,
                convertString(TextConstants.HOME_NUMBER, 14), TextConstants.LINE_BREAK,
                convertString(TextConstants.APARTMENT_NUMBER, 15));
    }

    public String convertString(String string, int i) {
        return view.concatenateStringSpace(cleanString(string),
                view.concatenateString(TextConstants.F, String.valueOf(i), TextConstants.S));
    }

    public String cleanString(String string) {
        StringBuilder sb = new StringBuilder(view.getString(string));
        sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
        sb.reverse().replace(0, 10, TextConstants.NONE).reverse();
        return sb.toString();
    }
}
