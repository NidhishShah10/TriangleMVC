package org.openjfx;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class GraphicalView extends StackPane implements TriangleModel.Observer {

    private final Canvas canvas = new Canvas(400, 400);
    private final double padding = 40.0;

    public GraphicalView(TriangleModel model) {
        getChildren().add(canvas);
        model.addObserver(this);
    }

    @Override
    public void modelChanged(double base, double height) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        double canvasWidth = canvas.getWidth();
        double canvasHeight = canvas.getHeight();

        double scaleX = (canvasWidth - 2 * padding) / base;
        double scaleY = (canvasHeight - 2 * padding) / height;
        double scale = Math.min(scaleX, scaleY);

        double originX = padding;
        double originY = canvasHeight - padding;

        double[] xPoints = {
            originX,
            originX + base * scale,
            originX
        };
        double[] yPoints = {
            originY,
            originY,
            originY - height * scale
        };

        gc.setFill(Color.LIGHTGRAY);
        gc.fillRect(0, 0, canvasWidth, canvasHeight);

        gc.setFill(Color.DEEPSKYBLUE);
        gc.fillPolygon(xPoints, yPoints, 3);

        gc.setStroke(Color.BLACK);
        gc.strokePolygon(xPoints, yPoints, 3);
    }
}
