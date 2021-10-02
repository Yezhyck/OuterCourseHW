package model;

import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;

@Getter
public class NoteBook {
    private final LinkedList<NoteBookRecord> noteBookRecords;

    public NoteBook() {
        noteBookRecords = new LinkedList<>();
    }

    public void addNoteBookRecord(NoteBookRecord noteBookRecord) {
        noteBookRecord.updateDateOfAdding();
        noteBookRecords.add(noteBookRecord);
    }

    public NoteBookRecord findByFirstName(String attribute) {
        NoteBookRecord noteBookRecord = null;
        for (NoteBookRecord n : noteBookRecords)
            if (n.getFirstName().equals(attribute)) {
                noteBookRecord = n;
                break;
            }
        return noteBookRecord;
    }

    public NoteBookRecord findBySecondName(String attribute) {
        NoteBookRecord noteBookRecord = null;
        for (NoteBookRecord n : noteBookRecords)
            if (n.getSecondName().equals(attribute)) {
                noteBookRecord = n;
                break;
            }
        return noteBookRecord;
    }

    public NoteBookRecord findByMiddleName(String attribute) {
        NoteBookRecord noteBookRecord = null;
        for (NoteBookRecord n : noteBookRecords)
            if (n.getMiddleName().equals(attribute)) {
                noteBookRecord = n;
                break;
            }
        return noteBookRecord;
    }

    public NoteBookRecord findByNickName(String attribute) {
        NoteBookRecord noteBookRecord = null;
        for (NoteBookRecord n : noteBookRecords)
            if (n.getNickname().equals(attribute)) {
                noteBookRecord = n;
                break;
            }
        return noteBookRecord;
    }

    public NoteBookRecord findByComment(String attribute) {
        NoteBookRecord noteBookRecord = null;
        for (NoteBookRecord n : noteBookRecords)
            if (n.getComment().equals(attribute)) {
                noteBookRecord = n;
                break;
            }
        return noteBookRecord;
    }

    public NoteBookRecord findByGroup(Group attribute) {
        NoteBookRecord noteBookRecord = null;
        for (NoteBookRecord n : noteBookRecords)
            if (n.getGroup().equals(attribute)) {
                noteBookRecord = n;
                break;
            }
        return noteBookRecord;
    }

    public NoteBookRecord findByHomeTelephoneNumber(String attribute) {
        NoteBookRecord noteBookRecord = null;
        for (NoteBookRecord n : noteBookRecords)
            if (n.getHomeTelephoneNumber().equals(attribute)) {
                noteBookRecord = n;
                break;
            }
        return noteBookRecord;
    }

    public NoteBookRecord findByMobileTelephoneNumber(String attribute) {
        NoteBookRecord noteBookRecord = null;
        for (NoteBookRecord n : noteBookRecords)
            if (n.getMobileTelephoneNumber().equals(attribute)) {
                noteBookRecord = n;
                break;
            }
        return noteBookRecord;
    }

    public NoteBookRecord findBySecondMobileTelephoneNumber(String attribute) {
        NoteBookRecord noteBookRecord = null;
        for (NoteBookRecord n : noteBookRecords)
            if (n.getSecondMobileTelephoneNumber().equals(attribute)) {
                noteBookRecord = n;
                break;
            }
        return noteBookRecord;
    }

    public NoteBookRecord findByEmail(String attribute) {
        NoteBookRecord noteBookRecord = null;
        for (NoteBookRecord n : noteBookRecords)
            if (n.getEmail().equals(attribute)) {
                noteBookRecord = n;
                break;
            }
        return noteBookRecord;
    }

    public NoteBookRecord findBySkype(String attribute) {
        NoteBookRecord noteBookRecord = null;
        for (NoteBookRecord n : noteBookRecords)
            if (n.getSkype().equals(attribute)) {
                noteBookRecord = n;
                break;
            }
        return noteBookRecord;
    }

    public NoteBookRecord findByIndex(String attribute) {
        NoteBookRecord noteBookRecord = null;
        for (NoteBookRecord n : noteBookRecords)
            if (n.getIndex().equals(attribute)) {
                noteBookRecord = n;
                break;
            }
        return noteBookRecord;
    }

    public NoteBookRecord findByCity(String attribute) {
        NoteBookRecord noteBookRecord = null;
        for (NoteBookRecord n : noteBookRecords)
            if (n.getCity().equals(attribute)) {
                noteBookRecord = n;
                break;
            }
        return noteBookRecord;
    }

    public NoteBookRecord findByStreet(String attribute) {
        NoteBookRecord noteBookRecord = null;
        for (NoteBookRecord n : noteBookRecords)
            if (n.getStreet().equals(attribute)) {
                noteBookRecord = n;
                break;
            }
        return noteBookRecord;
    }

    public NoteBookRecord findByHomeNumber(String attribute) {
        NoteBookRecord noteBookRecord = null;
        for (NoteBookRecord n : noteBookRecords)
            if (n.getHomeNumber().equals(attribute)) {
                noteBookRecord = n;
                break;
            }
        return noteBookRecord;
    }

    public NoteBookRecord findByApartmentNumber(String attribute) {
        NoteBookRecord noteBookRecord = null;
        for (NoteBookRecord n : noteBookRecords)
            if (n.getApartmentNumber().equals(attribute)) {
                noteBookRecord = n;
                break;
            }
        return noteBookRecord;
    }
}
