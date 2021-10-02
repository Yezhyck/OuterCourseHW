import controller.Controller;
import model.Model;
import view.View;

public class Main {
    public static void main(String[] args) {
        Controller Controller = new Controller(new Model(), new View());
        Controller.inputNote();
    }
}
