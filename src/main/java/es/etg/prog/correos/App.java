package es.etg.prog.correos;

import es.etg.prog.correos.controller.CorreosController;
import javafx.application.Application;

/**
 * JavaFX App
 */
public class App {

    public static void main(String[] args) {


        //Inicio la aplicación javafx (se ejecutará el método start del controlador InstitutoController.java)
        Application.launch(CorreosController.class, args);
    }

}