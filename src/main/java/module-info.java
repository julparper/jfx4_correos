module es.etg.prog.correos {
    requires javafx.controls;
    requires javafx.fxml;

    opens es.etg.prog.correos to javafx.fxml;
    opens es.etg.prog.correos.view to javafx.fxml;
    exports es.etg.prog.correos.controller;
    exports es.etg.prog.correos.view;
}
