package com.pityubak;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.net.URL; 

/**
 *
 * @author Pityubak
 */
public class EasyZip extends Application {

    private double xOffset = 0;
    private double yOffset = 0;

    @Override
    public void start(Stage stage) throws Exception {
        
        URL mainWindow=EasyZip.class.getResource("view/MainWindow.fxml");
        Parent root = FXMLLoader.load(mainWindow);

        setOnMousePressed(root);
        setOnMouseDragged(root, stage);

        initScene(root, stage);
    }

    private void initScene(Parent root, Stage stage) {
        Scene scene = new Scene(root);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
        stage.setTitle("EasyZip");
        scene.setFill(Color.TRANSPARENT);
        stage.show();
    }

    private void setOnMouseDragged(Parent root, Stage stage) {
        root.setOnMouseDragged((MouseEvent event) -> {
            stage.setX(event.getScreenX() - xOffset);
            stage.setY(event.getScreenY() - yOffset);
        });
    }

    private void setOnMousePressed(Parent root) {
        root.setOnMousePressed((MouseEvent event) -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });
    }

    public static void main(String[] args) {
        launch(args);
    }

}
