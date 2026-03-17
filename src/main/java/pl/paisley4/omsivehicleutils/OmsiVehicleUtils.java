package pl.paisley4.omsivehicleutils;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.logging.Logger;

public class OmsiVehicleUtils extends Application {

    private static Logger logger;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        logger = Logger.getLogger(getClass().getName());
        FXMLLoader loader = new FXMLLoader(getClass().getResource("main.fxml"));
        Scene scene = new Scene(loader.load(), 600, 400);
        stage.setTitle("Omsi Vehicle Utils");
        stage.setScene(scene);
        stage.show();
    }

    public static Logger getLogger() {
        return logger;
    }
}
