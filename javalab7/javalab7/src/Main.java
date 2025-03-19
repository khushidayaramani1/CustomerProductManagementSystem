import Controller.Controller;
import Model.Model;
import View.View;

import java.io.IOException;

/**
 * Identification comments:
 *   Name: Purab Keshwani
 *   Experiment No: 09
 *   Experiment Title:
 *   Experiment Date:
 *   @version 1.0
 *
 *
 * Beginning comments:
 * Filename: Main.java
 * @author:  Richard Joseph
 * Overview: This is the main class used to created objects for Student Class and Course Class. In this file we have achieved the following
 * - Menu Driven Program to create Student and Courses
 * - String Manipulation by using split function for Full name
 *
 */

public class Main {
    public static void main(String[] args) throws IOException {
        View view = new View();
        Model model = new Model();
        Controller controller = new Controller(model,view);



    }
}