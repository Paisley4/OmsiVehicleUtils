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

        List<Mesh> meshesToRemove = new ArrayList<>();

        config.getMeshes().forEach(mesh -> {
            if(mesh.getVisibility() != null){
                if(cti.getSetvars().containsKey(mesh.getVisibility().getFirst())){
                    if(cti.getSetvars().get(mesh.getVisibility().getFirst()) != mesh.getVisibility().getSecond()){
                        meshesToRemove.add(mesh);
                    }
                }
            }
        });

        Collections.sort(meshesToRemove);
        Collections.reverse(meshesToRemove);

        meshesToRemove.forEach(m -> {
            for(int i = m.getEndsAt(); i >= m.getStartsAt(); i--){
                config.getLines().remove(i);
            }
        });

        File outputFile = new File("output.cfg");

        try{
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile), Charset.forName(config.getCoding())));
            for(String line : config.getLines()){
                writer.write(line + "\n");
            }
        }catch (IOException e){
            e.printStackTrace();
        }
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
