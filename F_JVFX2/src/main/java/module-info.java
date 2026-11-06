module cl.duoc.f_jvfx2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;
    requires javafx.graphics;
    requires java.desktop;

    opens cl.duoc.f_jvfx2 to javafx.fxml;
    exports cl.duoc.f_jvfx2;
    exports cl.duoc.f_jvfx2.controller;
    opens cl.duoc.f_jvfx2.controller to javafx.fxml;
}