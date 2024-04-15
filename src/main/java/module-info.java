module es.etg.prog.correos {
    requires transitive javafx.controls;
    requires transitive javafx.fxml;

    opens es.etg.prog.correos to javafx.fxml;
    opens es.etg.prog.correos.view to javafx.fxml;
    exports es.etg.prog.correos.controller;
    exports es.etg.prog.correos.view;
}
