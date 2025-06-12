package org.openjfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class FXMLController {

    @FXML
    private TextField baseField;

    @FXML
    private TextField heightField;

    @FXML
    private Label hypotenuseLabel;

    private TriangleModel model;

    public void setModel(TriangleModel model) {
        this.model = model;
        model.addObserver((_, _) -> updateHypotenuse());
    }

    @FXML
    private void handleUpdateAction(ActionEvent event) {
        try {
            double b = Double.parseDouble(baseField.getText());
            double h = Double.parseDouble(heightField.getText());
            model.setBase(b);
            model.setHeight(h);
        } catch (NumberFormatException e) {
            hypotenuseLabel.setText("Invalid input!");
        }
    }

    private void updateHypotenuse() {
        double hypotenuse = model.getHypotenuse();
        hypotenuseLabel.setText(String.format("Hypotenuse: %.2f", hypotenuse));
    }
}
