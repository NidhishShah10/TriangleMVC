package org.openjfx;

import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;

public class TextualView extends VBox implements TriangleModel.Observer {

    private final TextArea textArea;

    public TextualView(TriangleModel model) {
        textArea = new TextArea();
        textArea.setEditable(false);
        textArea.setStyle("-fx-font-family: 'monospace'; -fx-font-size: 14;");
        getChildren().add(textArea);

        // Register as observer
        model.addObserver(this);
    }

    @Override
    public void modelChanged(double base, double height) {
        double hypotenuse = Math.sqrt(base * base + height * height);
        String output = String.format(
            "Base: %.2f\nHeight: %.2f\nHypotenuse: %.2f",
            base, height, hypotenuse
        );
        textArea.setText(output);
    }
}
