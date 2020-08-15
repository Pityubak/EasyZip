
module EasyZip {
    requires javafx.swt;
    requires javafx.base;
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.media;
    requires javafx.swing;
    requires javafx.web;
    requires java.base;
    opens com.pityubak;
    exports com.pityubak;
    opens com.pityubak.controller;
    exports com.pityubak.controller;
}
