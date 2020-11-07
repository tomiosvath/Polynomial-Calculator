/**
 * The Main class is responsible for running the application
 */
package polynomial;

import model.Model;
import gui.*;
public class Main {
    /**
     * The main function instantiates a Model, a View and a Controller object in order to run the program
     */
    public static void main(String[] args){
        Model model = new Model();
        View view = new View(model);
        Controller controller = new Controller(model, view);
        view.setVisible(true);
    }
}

