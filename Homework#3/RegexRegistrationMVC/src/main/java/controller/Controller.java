package controller;

import model.Group;
import model.NoteBook;
import model.NoteBookRecord;
import view.TextConstantsContainer;
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
        view.printConcatenatedString(view.getString(TextConstantsContainer.QUESTION),
                TextConstantsContainer.LINE_BREAK, view.getString(TextConstantsContainer.CHOICE));
        view.printMessage(TextConstantsContainer.ARCHER_POINTER);
        boolean flag = false;
        String answer = scanner.nextLine().trim();
        while (!answer.equals(view.getString(TextConstantsContainer.N))) {
            if (answer.equals(view.getString(TextConstantsContainer.Y))) {
                printProposition();
                view.printMessage(TextConstantsContainer.ARCHER_POINTER);
                String ans = scanner.nextLine().trim();
                while (!ans.matches(view.getString(RegexContainer.PROPOSITION))) {
                    view.printlnMessage(view.getString(TextConstantsContainer.WRONG));
                    view.printMessage(TextConstantsContainer.ARCHER_POINTER);
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
                view.printMessage(TextConstantsContainer.LINE_BREAK); printModel(noteBookRecord);
                view.printConcatenatedString(view.getString(TextConstantsContainer.QUESTION),
                        TextConstantsContainer.LINE_BREAK, view.getString(TextConstantsContainer.CHOICE));
                view.printMessage(TextConstantsContainer.ARCHER_POINTER);
                flag = true;
            } else {
                view.printConcatenatedString(view.getString(TextConstantsContainer.WRONG));
                view.printMessage(TextConstantsContainer.ARCHER_POINTER);
            }
            answer = scanner.nextLine();
        }
        if (flag)
            view.printConcatenatedString(TextConstantsContainer.LINE_BREAK,
                view.getString(TextConstantsContainer.READY), TextConstantsContainer.LINE_BREAK);
    }

    public void fillModel(NoteBookRecord noteBookRecord) {
        ssn(noteBookRecord); sfn(noteBookRecord); smn(noteBookRecord); noteBookRecord.createFullName();
        view.printConcatenatedStringSpace(view.getString(TextConstantsContainer.FULL_NAME),
                TextConstantsContainer.DD, String.valueOf(noteBookRecord.getFullName()));
        snn(noteBookRecord); scmm(noteBookRecord); sg(noteBookRecord); shtn(noteBookRecord);
        smtn(noteBookRecord); ssmtn(noteBookRecord); se(noteBookRecord); ss(noteBookRecord);
        si(noteBookRecord); sct(noteBookRecord); sstr(noteBookRecord); shm(noteBookRecord);
        ssam(noteBookRecord); noteBookRecord.createFullAddress();
        view.printConcatenatedStringSpace(view.getString(TextConstantsContainer.FULL_ADDRESS), TextConstantsContainer.DD,
                String.valueOf(noteBookRecord.getFullAddress()));
        view.printConcatenatedString(TextConstantsContainer.LINE_BREAK,
                view.getString(TextConstantsContainer.GREETING), TextConstantsContainer.LINE_BREAK);
    }

    public void ssn(NoteBookRecord noteBookRecord) { noteBookRecord.setSecondName(inputStringRegexCheck(RegexContainer.NAME_SURNAME_MIDDLE_NAME, TextConstantsContainer.SECOND_NAME)); }

    public void sfn(NoteBookRecord noteBookRecord) { noteBookRecord.setFirstName(inputStringRegexCheck(RegexContainer.NAME_SURNAME_MIDDLE_NAME, TextConstantsContainer.FIRST_NAME)); }

    public void smn(NoteBookRecord noteBookRecord) { noteBookRecord.setMiddleName(inputStringRegexCheck(RegexContainer.NAME_SURNAME_MIDDLE_NAME, TextConstantsContainer.MIDDLE_NAME)); }

    public void snn(NoteBookRecord noteBookRecord) { noteBookRecord.setNickname(inputStringRegexCheck(RegexContainer.SKYPE, TextConstantsContainer.NICKNAME)); }

    public void scmm(NoteBookRecord noteBookRecord) { noteBookRecord.setComment(inputStringRegexCheck(RegexContainer.COMMENT, TextConstantsContainer.COMMENT)); }

    public void sg(NoteBookRecord noteBookRecord) { noteBookRecord.setGroup(Group.valueOf(inputStringRegexCheck(RegexContainer.GROUP, TextConstantsContainer.GROUP))); }

    public void shtn(NoteBookRecord noteBookRecord) { noteBookRecord.setHomeTelephoneNumber(inputStringRegexCheck(RegexContainer.HOME_TELEPHONE_NUMBER, TextConstantsContainer.HOME_TELEPHONE_NUMBER)); }

    public void smtn(NoteBookRecord noteBookRecord) { noteBookRecord.setMobileTelephoneNumber(inputStringRegexCheck(RegexContainer.TELEPHONE_NUMBER, TextConstantsContainer.MOBILE_TELEPHONE_NUMBER)); }

    public void ssmtn(NoteBookRecord noteBookRecord) { noteBookRecord.setSecondMobileTelephoneNumber(inputStringRegexCheck(RegexContainer.TELEPHONE_NUMBER, TextConstantsContainer.SECOND_MOBILE_TELEPHONE_NUMBER)); }

    public void se(NoteBookRecord noteBookRecord) { noteBookRecord.setEmail(inputStringRegexCheck(RegexContainer.EMAIL, TextConstantsContainer.EMAIL)); }

    public void ss(NoteBookRecord noteBookRecord) { noteBookRecord.setSkype(inputStringRegexCheck(RegexContainer.SKYPE, TextConstantsContainer.SKYPE)); }

    public void si(NoteBookRecord noteBookRecord) { noteBookRecord.setIndex(inputStringRegexCheck(RegexContainer.INDEX, TextConstantsContainer.INDEX)); }

    public void sct(NoteBookRecord noteBookRecord) { noteBookRecord.setCity(inputStringRegexCheck(RegexContainer.CITY, TextConstantsContainer.CITY)); }

    public void sstr(NoteBookRecord noteBookRecord) { noteBookRecord.setStreet(inputStringRegexCheck(RegexContainer.CITY, TextConstantsContainer.STREET)); }

    public void shm(NoteBookRecord noteBookRecord) { noteBookRecord.setHomeNumber(inputStringRegexCheck(RegexContainer.STREET_APARTMENT_NUMBER, TextConstantsContainer.HOME_NUMBER)); }

    public void ssam(NoteBookRecord noteBookRecord) { noteBookRecord.setApartmentNumber(inputStringRegexCheck(RegexContainer.STREET_APARTMENT_NUMBER, TextConstantsContainer.APARTMENT_NUMBER)); }

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
        view.printConcatenatedString(TextConstantsContainer.ENTER_LANGUAGE_ON_UA, TextConstantsContainer.LINE_BREAK,
                TextConstantsContainer.OR_UA, TextConstantsContainer.F, TextConstantsContainer.OR, TextConstantsContainer.S, TextConstantsContainer.SPACE,
                TextConstantsContainer.ENTER_LANGUAGE_ON_EN);
        view.printMessage(TextConstantsContainer.ARCHER_POINTER);
        while (!scanner.hasNext(TextConstantsContainer.EN) && !scanner.hasNext(TextConstantsContainer.UA)) {
            view.printConcatenatedString(TextConstantsContainer.WRONG_SETUP_UA, TextConstantsContainer.LINE_BREAK,
                    TextConstantsContainer.WRONG_SETUP_EN);
            view.printMessage(TextConstantsContainer.ARCHER_POINTER);
            scanner.nextLine();
        }
        view.configureResourceBungle(scanner.nextLine().trim());
    }

    public void printModel(NoteBookRecord noteBookRecord) {
        view.printConcatenatedString(
                view.concatenateStringSpace(view.getString(TextConstantsContainer.FULL_NAME), TextConstantsContainer.DD, String.valueOf(noteBookRecord.getFullName())) + TextConstantsContainer.LINE_BREAK,
                view.concatenateStringSpace(cleanString(TextConstantsContainer.NICKNAME), TextConstantsContainer.DD, noteBookRecord.getNickname()) + TextConstantsContainer.LINE_BREAK,
                view.concatenateStringSpace(cleanString(TextConstantsContainer.COMMENT), TextConstantsContainer.DD, noteBookRecord.getComment()) + TextConstantsContainer.LINE_BREAK,
                view.concatenateStringSpace(cleanString(TextConstantsContainer.GROUP), TextConstantsContainer.DD, String.valueOf(noteBookRecord.getGroup())) + TextConstantsContainer.LINE_BREAK,
                view.concatenateStringSpace(cleanString(TextConstantsContainer.HOME_TELEPHONE_NUMBER), TextConstantsContainer.DD, noteBookRecord.getHomeTelephoneNumber()) + TextConstantsContainer.LINE_BREAK,
                view.concatenateStringSpace(cleanString(TextConstantsContainer.MOBILE_TELEPHONE_NUMBER), TextConstantsContainer.DD, noteBookRecord.getMobileTelephoneNumber()) + TextConstantsContainer.LINE_BREAK,
                view.concatenateStringSpace(cleanString(TextConstantsContainer.SECOND_MOBILE_TELEPHONE_NUMBER), TextConstantsContainer.DD, noteBookRecord.getSecondMobileTelephoneNumber()) + TextConstantsContainer.LINE_BREAK,
                view.concatenateStringSpace(cleanString(TextConstantsContainer.EMAIL), TextConstantsContainer.DD, noteBookRecord.getEmail()) + TextConstantsContainer.LINE_BREAK,
                view.concatenateStringSpace(cleanString(TextConstantsContainer.SKYPE), TextConstantsContainer.DD, noteBookRecord.getSkype()) + TextConstantsContainer.LINE_BREAK,
                view.concatenateStringSpace(view.getString(TextConstantsContainer.FULL_ADDRESS), TextConstantsContainer.DD, String.valueOf(noteBookRecord.getFullAddress())) + TextConstantsContainer.LINE_BREAK,
                view.concatenateStringSpace(view.getString(TextConstantsContainer.FULL_DATE_OF_CREATION), TextConstantsContainer.DD, String.valueOf(noteBookRecord.getFullDateOfCreation())) + TextConstantsContainer.LINE_BREAK,
                view.concatenateStringSpace(view.getString(TextConstantsContainer.FULL_DATE_OF_EDITING), TextConstantsContainer.DD, noteBookRecord.isEdited() ? String.valueOf(noteBookRecord.getFullDateOfEditing()) : ""));
        view.printMessage(TextConstantsContainer.LINE_BREAK);
    }

    public void printProposition() {
        view.printConcatenatedString(convertString(TextConstantsContainer.SECOND_NAME, 0), TextConstantsContainer.LINE_BREAK,
                convertString(TextConstantsContainer.FIRST_NAME, 1), TextConstantsContainer.LINE_BREAK,
                convertString(TextConstantsContainer.MIDDLE_NAME, 2), TextConstantsContainer.LINE_BREAK,
                convertString(TextConstantsContainer.NICKNAME, 3), TextConstantsContainer.LINE_BREAK,
                convertString(TextConstantsContainer.COMMENT, 4), TextConstantsContainer.LINE_BREAK,
                convertString(TextConstantsContainer.GROUP, 5), TextConstantsContainer.LINE_BREAK,
                convertString(TextConstantsContainer.HOME_TELEPHONE_NUMBER, 6), TextConstantsContainer.LINE_BREAK,
                convertString(TextConstantsContainer.MOBILE_TELEPHONE_NUMBER, 7), TextConstantsContainer.LINE_BREAK,
                convertString(TextConstantsContainer.SECOND_MOBILE_TELEPHONE_NUMBER, 8), TextConstantsContainer.LINE_BREAK,
                convertString(TextConstantsContainer.EMAIL, 9), TextConstantsContainer.LINE_BREAK,
                convertString(TextConstantsContainer.SKYPE, 10), TextConstantsContainer.LINE_BREAK,
                convertString(TextConstantsContainer.INDEX, 11), TextConstantsContainer.LINE_BREAK,
                convertString(TextConstantsContainer.CITY, 12), TextConstantsContainer.LINE_BREAK,
                convertString(TextConstantsContainer.STREET, 13), TextConstantsContainer.LINE_BREAK,
                convertString(TextConstantsContainer.HOME_NUMBER, 14), TextConstantsContainer.LINE_BREAK,
                convertString(TextConstantsContainer.APARTMENT_NUMBER, 15));
    }

    public String convertString(String string, int i) {
        return view.concatenateStringSpace(cleanString(string),
                view.concatenateString(TextConstantsContainer.F, String.valueOf(i), TextConstantsContainer.S));
    }

    public String cleanString(String string) {
        StringBuilder sb = new StringBuilder(view.getString(string));
        sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
        sb.reverse().replace(0, 10, TextConstantsContainer.NONE).reverse();
        return sb.toString();
    }
}
