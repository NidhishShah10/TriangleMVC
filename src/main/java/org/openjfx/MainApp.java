package org.openjfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Scene.fxml"));
        Parent textForm = loader.load();

        TriangleModel model = new TriangleModel();
        FXMLController controller = loader.getController();
        controller.setModel(model);

        GraphicalView graphicalView = new GraphicalView(model);
        TextualView textualView = new TextualView(model);

        VBox root = new VBox(20, textForm, graphicalView, textualView);
        root.setStyle("-fx-padding: 20; -fx-alignment: center;");

        Scene scene = new Scene(root, 500, 900);
        stage.setScene(scene);
        stage.setTitle("Right Triangle MVC");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
