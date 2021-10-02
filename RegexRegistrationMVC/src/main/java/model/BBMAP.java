package model;

import view.PropertiesTextConstants;

import java.util.*;

public class BBMAP implements PropertiesTextConstants {
    public static final Map<State, String> STATE_REGEX = new LinkedHashMap<>() {{
        put(State.FIRST_NAME, CHECKING_NAME_SURNAME_MIDDLE_NAME);
        put(State.SECOND_NAME, CHECKING_NAME_SURNAME_MIDDLE_NAME);
        put(State.MIDDLE_NAME, CHECKING_NAME_SURNAME_MIDDLE_NAME);
        put(State.NICKNAME, CHECKING_SKYPE_REGEX);
        put(State.COMMENT, CHECKING_COMMENT);
        put(State.GROUP, CHECKING_GROUP);
        put(State.HOME_TELEPHONE_NUMBER, CHECKING_HOME_TELEPHONE_NUMBER);
        put(State.MOBILE_TELEPHONE_NUMBER, CHECKING_TELEPHONE_NUMBER);
        put(State.SECOND_MOBILE_TELEPHONE_NUMBER, CHECKING_TELEPHONE_NUMBER);
        put(State.EMAIL, CHECKING_EMAIL);
        put(State.SKYPE, CHECKING_SKYPE_REGEX);
        put(State.INDEX, CHECKING_INDEX);
        put(State.CITY, CHECKING_CITY);
        put(State.STREET, CHECKING_CITY);
        put(State.HOME_NUMBER, CHECKING_STREET_APARTMENT_NUMBER);
        put(State.APARTMENT_NUMBER, CHECKING_STREET_APARTMENT_NUMBER);
    }};

    public static final Map<State, String> STATE_INPUT = new TreeMap<>() {{
        put(State.FIRST_NAME, INPUT_FIRST_NAME);
        put(State.SECOND_NAME, INPUT_SECOND_NAME);
        put(State.MIDDLE_NAME, INPUT_MIDDLE_NAME);
        put(State.NICKNAME, INPUT_NICKNAME);
        put(State.COMMENT, INPUT_COMMENT);
        put(State.GROUP, INPUT_GROUP);
        put(State.HOME_TELEPHONE_NUMBER, INPUT_HOME_TELEPHONE_NUMBER);
        put(State.MOBILE_TELEPHONE_NUMBER, INPUT_MOBILE_TELEPHONE_NUMBER);
        put(State.SECOND_MOBILE_TELEPHONE_NUMBER, INPUT_SECOND_MOBILE_TELEPHONE_NUMBER);
        put(State.EMAIL, INPUT_EMAIL);
        put(State.SKYPE, INPUT_SKYPE);
        put(State.INDEX, INPUT_INDEX);
        put(State.CITY, INPUT_CITY);
        put(State.STREET, INPUT_STREET);
        put(State.HOME_NUMBER, INPUT_HOME_NUMBER);
        put(State.APARTMENT_NUMBER, INPUT_APARTMENT_NUMBER);
    }};

    public static String findRegex(State state) {
        return STATE_REGEX.get(state);
    }

    public static String findInput(State state) {
        return STATE_INPUT.get(state);
    }
}
