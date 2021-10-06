package model;
import lombok.Getter;
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
}
