module com.example.talleragendamientodecitas {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.datatype.jsr310;


    opens com.example.talleragendamientodecitas to javafx.fxml;
    exports com.example.talleragendamientodecitas;
}