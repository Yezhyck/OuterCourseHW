import controller.Controller;
import model.NoteBook;
import model.NoteBookRecord;
import view.View;

public class Main {
    public static void main(String[] args) {
        Controller Controller = new Controller(new NoteBookRecord(), new NoteBook(), new View());
        Controller.inputNote();
    }
}
