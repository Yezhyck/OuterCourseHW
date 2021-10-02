package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

@Data
@AllArgsConstructor
public class NoteBookRecord {
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
    private FullDate fullDateOfAdding;

    public NoteBookRecord() {
        this.fullName = new FullName();
        this.fullAddress = new FullAddress();
        this.fullDateOfCreation = new FullDate(LocalDate.now(), LocalDateTime.now());
    }

    public void createFullName() {
        fullName = new FullName(firstName, secondName, middleName);
    }

    public void createFullAddress() {
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
            return secondName + " "
                    + firstName + " "
                    + middleName;
        }
    }

    private void updateDateOfEditing() {
        this.fullDateOfEditing = new FullDate(LocalDate.now(), LocalDateTime.now());
    }

    public void updateDateOfAdding() {
        this.fullDateOfAdding = new FullDate(LocalDate.now(), LocalDateTime.now());
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        createFullName();
        updateDateOfEditing();
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
        createFullName();
        updateDateOfEditing();
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
        createFullName();
        updateDateOfEditing();
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
        updateDateOfEditing();
    }

    public void setComment(String comment) {
        this.comment = comment;
        updateDateOfEditing();
    }

    public void setGroup(Group group) {
        this.group = group;
        updateDateOfEditing();
    }

    public void setHomeTelephoneNumber(String homeTelephoneNumber) {
        this.homeTelephoneNumber = homeTelephoneNumber;
        updateDateOfEditing();
    }

    public void setMobileTelephoneNumber(String mobileTelephoneNumber) {
        this.mobileTelephoneNumber = mobileTelephoneNumber;
        updateDateOfEditing();
    }

    public void setSecondMobileTelephoneNumber(String secondMobileTelephoneNumber) {
        this.secondMobileTelephoneNumber = secondMobileTelephoneNumber;
        updateDateOfEditing();
    }

    public void setEmail(String email) {
        this.email = email;
        updateDateOfEditing();
    }

    public void setSkype(String skype) {
        this.skype = skype;
        updateDateOfEditing();
    }

    public void setIndex(String index) {
        this.index = index;
        createFullAddress();
        updateDateOfEditing();
    }

    public void setCity(String city) {
        this.city = city;
        createFullAddress();
        updateDateOfEditing();
    }

    public void setStreet(String street) {
        this.street = street;
        createFullAddress();
        updateDateOfEditing();
    }

    public void setHomeNumber(String homeNumber) {
        this.homeNumber = homeNumber;
        createFullAddress();
        updateDateOfEditing();
    }

    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
        createFullAddress();
        updateDateOfEditing();
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
    @Getter
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
