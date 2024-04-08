package es.etg.prog.correos.view;

import es.etg.prog.correos.controller.CorreosController;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class FormularioViewController {

    @FXML
    private Button btnFacturar;

    @FXML
    private TextArea txaMensaje;

    @FXML
    private TextField txfDestinatario;

    @FXML
    private TextField txfDireccion;

    @FXML
    private TextField txfPeso;

    protected CorreosController controller;

    public void setCorreosController(CorreosController c){
        this.controller = c;
    }

    @FXML
    void facturar(MouseEvent event) {

        final String MSG_ERROR_EDAD ="El peso debe ser un valor numérico";
        final String MSG_ERROR_CAMPOS ="Debe rellenar todos los campos";

        String destinatario;
        String direccion;
        Double peso;
        AlertType tipoAlerta = AlertType.INFORMATION;
        String msg = "";

        if(relleno(this.txfDestinatario) && relleno(this.txfDireccion) && relleno(this.txfPeso)){
            destinatario = this.txfDestinatario.getText();
            direccion = this.txfDireccion.getText();

            peso = obtenerValor(txfPeso);
            if(peso ==null){
                tipoAlerta = AlertType.ERROR;
                msg = MSG_ERROR_EDAD;
            }else{
                
                msg = controller.procesar(destinatario, direccion, peso);
                txaMensaje.setText(msg);
            }
        }else{
            msg = MSG_ERROR_CAMPOS;
            tipoAlerta = AlertType.ERROR;
        }
        mostrarAviso(msg, tipoAlerta);
    }

    

    private void mostrarAviso(String msg, AlertType tipo){
        Alert alerta = new Alert(tipo);
        alerta.setHeaderText(null);
        alerta.setTitle("Importante");
        alerta.setContentText(msg);
        alerta.showAndWait();

    }

    private boolean relleno(TextField campo){

        if(campo!=null && campo.getText()!=null && !"".equals(campo.getText().trim())){
            return true;
        }
        return false;
    }

    private Double obtenerValor(TextField campo){
        Double valor = null;
        try{
            valor = Double.valueOf(campo.getText());
        }catch(Exception e){
            valor = null;
        }

        return valor;
    }

}
 

