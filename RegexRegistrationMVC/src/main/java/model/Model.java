package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

@Getter
@AllArgsConstructor
public class Model {
    private String firstName;
    private String secondName;
    private String middleName;
    private FullName fullName;
    private String nickname;
    private String comment;
    private Group group;
    private String homeTelephoneNumber;
    private String mobileTelephoneNumber;
    private String secondMobileTelephoneNumber;
    private String email;
    private String skype;
    private String index;
    private String city;
    private String street;
    private String homeNumber;
    private String apartmentNumber;
    private FullAddress fullAddress;
    private FullDate fullDateOfCreation;
    private FullDate fullDateOfEditing;

    public Model() {
        this.fullName = new FullName();
        this.fullAddress = new FullAddress();
        this.fullDateOfCreation = new FullDate(LocalDate.now(), LocalDateTime.now());
    }

    public boolean checkString(String string, String pattern, State state) {
        if (string.matches(pattern)) {
            setField(string, state);
            return true;
        }
        return false;
    }

    private void setField(String fieldValue, State state) {
        if (isFilled()) fullDateOfEditing = new FullDate(LocalDate.now(), LocalDateTime.now());
        switch (state) {
            case FIRST_NAME -> {
                firstName = fieldValue;
                fullName.setFirstName(firstName);
            }
            case SECOND_NAME -> {
                secondName = fieldValue;
                fullName.setSecondName(secondName);
            }
            case MIDDLE_NAME -> {
                middleName = fieldValue;
                fullName.setMiddleName(middleName);
            }
            case NICKNAME -> nickname = fieldValue;
            case COMMENT -> comment = fieldValue;
            case GROUP -> setInputGroup(fieldValue);
            case HOME_TELEPHONE_NUMBER -> homeTelephoneNumber = fieldValue;
            case MOBILE_TELEPHONE_NUMBER -> mobileTelephoneNumber = fieldValue;
            case SECOND_MOBILE_TELEPHONE_NUMBER -> secondMobileTelephoneNumber = fieldValue;
            case EMAIL -> email = fieldValue;
            case SKYPE -> skype = fieldValue;
            case INDEX -> {
                index = fieldValue;
                fullAddress.setIndex(index);
            }
            case CITY -> {
                city = fieldValue;
                fullAddress.setCity(city);
            }
            case STREET -> {
                street = fieldValue;
                fullAddress.setStreet(street);
            }
            case HOME_NUMBER -> {
                homeNumber = fieldValue;
                fullAddress.setHomeNumber(homeNumber);
            }
            case APARTMENT_NUMBER -> {
                apartmentNumber = fieldValue;
                fullAddress.setApartmentNumber(apartmentNumber);
            }
        }
    }

    private void setInputGroup(String inputGroup) {
        switch (Group.valueOf(inputGroup)) {
            case ADMIN -> group = Group.ADMIN;
            case MANAGER -> group = Group.MANAGER;
            case USER -> group = Group.USER;
        }
    }

    public boolean hasFullName() {
        return fullName.getFirstName() != null &&
                fullName.getSecondName() != null &&
                fullName.getMiddleName() != null;
    }

    public boolean isFilled() {
        return firstName != null &&
        secondName != null &&
        middleName != null &&
        nickname != null &&
        comment != null &&
        group != null &&
        homeTelephoneNumber != null &&
        mobileTelephoneNumber != null &&
        secondMobileTelephoneNumber != null &&
        email != null &&
        skype != null &&
        index != null &&
        city != null &&
        street != null &&
        homeNumber != null &&
        apartmentNumber != null;
    }

    private void createFullName() {
        fullName = new FullName(firstName, secondName, middleName);
    }

    public boolean hasFullAddress() {
        return fullAddress.getIndex() != null &&
               fullAddress.getCity() != null &&
               fullAddress.getStreet() != null &&
               fullAddress.getHomeNumber() != null &&
               fullAddress.getApartmentNumber() != null;
    }

    private void createFullAddress() {
        fullAddress = new FullAddress(index, city, street, homeNumber, apartmentNumber);
    }

    public boolean isEdited() {
        return fullDateOfEditing != null;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class FullName {
        private String firstName;
        private String secondName;
        private String middleName;

        @Override
        public String toString() {
            return firstName + " "
                    + secondName + " "
                    + middleName;
        }
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class FullAddress {
        private String index;
        private String city;
        private String street;
        private String homeNumber;
        private String apartmentNumber;

        @Override
        public String toString() {
            return index + ", " +
                    city + ", " +
                    street + ", " +
                    homeNumber + ", " +
                    apartmentNumber;
        }
    }

    @Data
    @NoArgsConstructor
    private static class FullDate {
        private LocalDate localDate;
        private LocalDateTime localDateTime;
        private DayOfWeek dayOfWeek;
        private Month month;
        private int dayOfMonth;
        private int year;
        private int hours;
        private int minutes;
        private int seconds;

        public FullDate(LocalDate localDate, LocalDateTime localDateTime) {
            this.localDate = localDate;
            this.dayOfWeek = this.localDate.getDayOfWeek();
            this.month = this.localDate.getMonth();
            this.dayOfMonth = this.localDate.getDayOfMonth();
            this.year = this.localDate.getYear();

            this.localDateTime = localDateTime;
            this.hours = this.localDateTime.getHour();
            this.minutes = this.localDateTime.getMinute();
            this.seconds = this.localDateTime.getSecond();
        }

        @Override
        public String toString() {
            return dayOfWeek + ", " +
                    month + ", " +
                    dayOfMonth + ", " +
                    year + ", " +
                    hours + ":" +
                    minutes + ":" +
                    seconds;
        }
    }
}
