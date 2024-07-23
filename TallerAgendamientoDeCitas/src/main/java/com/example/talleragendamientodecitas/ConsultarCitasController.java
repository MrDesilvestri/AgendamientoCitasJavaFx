package com.example.talleragendamientodecitas;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

public class ConsultarCitasController {
    @FXML
    private TextField fechaField;
    @FXML
    private TableView<Cita> citasTable;

    private Barberia barberia = new Barberia();

    @FXML
    protected void handleBuscarCitas(ActionEvent event) {
        try {
            String fechaTexto = fechaField.getText();
            LocalDate fecha;

            // Validación de la fecha
            try {
                fecha = parseFecha(fechaTexto);
            } catch (DateTimeParseException ex) {
                showAlert(Alert.AlertType.ERROR, "Error de Formato", "La fecha debe estar en el formato YYYY-MM-DD.");
                return;
            }

            List<Cita> citas = barberia.consultarCitas(fecha);
            citasTable.getItems().setAll(citas);

        } catch (Exception ex) {
            showAlert(Alert.AlertType.ERROR, "Error", "Hubo un error al buscar las citas: " + ex.getMessage());
        }
    }

    private LocalDate parseFecha(String fechaTexto) throws DateTimeParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(fechaTexto, formatter);
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    protected void handleVolver(ActionEvent event) throws Exception {
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("MainView.fxml")));
        stage.setScene(scene);
    }
}
