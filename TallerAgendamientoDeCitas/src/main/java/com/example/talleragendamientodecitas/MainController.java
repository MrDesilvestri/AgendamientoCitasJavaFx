package com.example.talleragendamientodecitas;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

public class MainController {

    @FXML
    private void handleRegisterCita(ActionEvent event) throws Exception {
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("RegisterCitaView.fxml")));
        stage.setScene(scene);
    }

    @FXML
    private void handleConsultarCitas(ActionEvent event) throws Exception {
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("ConsultarCitasView.fxml")));
        stage.setScene(scene);
    }

    @FXML
    private void handleSalir(ActionEvent event) {
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        stage.close();
    }
}
