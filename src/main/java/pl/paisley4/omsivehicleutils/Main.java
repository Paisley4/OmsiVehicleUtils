package pl.paisley4.omsivehicleutils;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.paisley4.omsivehicleutils.attributes.Mesh;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Main extends Application {

    public static void main(String[] args) {

        File cfgFile = new File(Objects.requireNonNull(ClassLoader.getSystemClassLoader().getResource("example.cfg")).getFile());
        File ctiFile = new File(Objects.requireNonNull(ClassLoader.getSystemClassLoader().getResource("example.cti")).getFile());

        if(!cfgFile.exists()){
            System.out.println("File not found!");
            return;
        }

        if(!ctiFile.exists()){
            System.out.println("File not found!");
            return;
        }

        VehicleConfig config = new VehicleConfig();
        config.read(cfgFile);

        VehicleCTI cti = new VehicleCTI();
        cti.read(ctiFile);

        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("main.fxml"));
        Scene scene = new Scene(loader.load(), 600, 400);
        stage.setTitle("Omsi Vehicle Utils");
        stage.setScene(scene);
        stage.show();
    }
}
