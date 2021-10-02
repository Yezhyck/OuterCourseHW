package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

@Data
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

    private void setInputGroup(String inputGroup) {
        switch (Group.valueOf(inputGroup)) {
            case ADMIN -> group = Group.ADMIN;
            case MANAGER -> group = Group.MANAGER;
            case USER -> group = Group.USER;
            default -> group = Group.UNKNOWN;
        }
    }

    public boolean hasFullName() {
        return fullName.getFirstName() != null &&
                fullName.getSecondName() != null &&
                fullName.getMiddleName() != null;
    }

    public void createFullName() {
        if (hasFullName())
            fullName = new FullName(firstName, secondName, middleName);
    }

    public boolean hasFullAddress() {
        return fullAddress.getIndex() != null &&
                fullAddress.getCity() != null &&
                fullAddress.getStreet() != null &&
                fullAddress.getHomeNumber() != null &&
                fullAddress.getApartmentNumber() != null;
    }

    public void createFullAddress() {
        if (hasFullAddress())
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

    private void updateDateOfEditing() {
        this.fullDateOfEditing = new FullDate(LocalDate.now(), LocalDateTime.now());
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public void setHomeTelephoneNumber(String homeTelephoneNumber) {
        this.homeTelephoneNumber = homeTelephoneNumber;
    }

    public void setMobileTelephoneNumber(String mobileTelephoneNumber) {
        this.mobileTelephoneNumber = mobileTelephoneNumber;
    }

    public void setSecondMobileTelephoneNumber(String secondMobileTelephoneNumber) {
        this.secondMobileTelephoneNumber = secondMobileTelephoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setHomeNumber(String homeNumber) {
        this.homeNumber = homeNumber;
    }

    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
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
