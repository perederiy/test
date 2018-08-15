package org.itstep;

import org.itstep.controller.Controller;
import org.itstep.model.Model;
import org.itstep.view.View;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Controller controller =
                new Controller(new Model(), new View());
        // Run
        controller.processUser();
    }
}
