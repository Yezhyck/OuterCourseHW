import controller.Controller;
import model.NoteBook;
import view.View;

public class Main {
    public static void main(String[] args) {
        Controller Controller = new Controller(new NoteBook(), new View());
        Controller.inputNote();
    }
}
