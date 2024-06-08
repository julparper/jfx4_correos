package es.etg.prog.correos.controller;

import es.etg.prog.correos.App;
import es.etg.prog.correos.model.Envio;
import es.etg.prog.correos.view.FormularioViewController;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class CorreosController extends Application{

    // Referencia a la interfaz gráfica para cargarla
    private final static String MAIN_VIEW = "view/formularioView.fxml";
    private final static String WIN_TITLE = "Aplicación DAW Correos";

    //Lógica de negocio (modelo)
    //private static Envio model;

    
    // Este método se llama al ejecutar lanzar la aplicación
    // Carga la pantalla inicial
    // Carga el modelo
    @Override
    public void start(Stage stage) throws IOException {

        //Cargo la vista
        stage.setScene(cargarVista(MAIN_VIEW));
        stage.setTitle(WIN_TITLE);
        //stage.setResizable(false);
        stage.show();
    }

    private Scene cargarVista(String ficheroView) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(ficheroView));
        Parent root = (Parent)fxmlLoader.load();  

        //Obtengo el controlador de la vista para pasarle una referencia al controlador - MVC:
        FormularioViewController viewController = fxmlLoader.<FormularioViewController>getController();
        viewController.setCorreosController(this);
        Scene scene = new Scene(root); 
        return scene;
    }

    
    //Métodos de acceso al modelo

    public String procesar(String destinatario, String dirección, double peso){

        return new Envio(destinatario, dirección, peso).facturar();
    }

    
}
