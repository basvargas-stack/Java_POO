module cl.duoc.f_jvfx2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;

    opens cl.duoc.f_jvfx2 to javafx.fxml;
    exports cl.duoc.f_jvfx2;
    exports cl.duoc.f_jvfx2.controller;
    opens cl.duoc.f_jvfx2.controller to javafx.fxml;
    exports cl.duoc.f_jvfx2.util;
    opens cl.duoc.f_jvfx2.util to javafx.fxml;



    opens cl.duoc.f_jvfx2.model to javafx.fxml;
    exports cl.duoc.f_jvfx2.model;

}