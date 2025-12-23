package pl.paisley4.omsivehicleutils.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import pl.paisley4.omsivehicleutils.VehicleCTI;
import pl.paisley4.omsivehicleutils.VehicleConfig;
import pl.paisley4.omsivehicleutils.VehicleUtils;

import java.io.File;

public class MainController {

    @FXML private Button processButton;
    @FXML private Button cfgSelectButton;
    @FXML private Button ctiSelectButton;

    @FXML private TextField cfgPath;
    @FXML private TextField ctiPath;
    @FXML private TextField newFileName;

    @FXML private Label alertLabel;

    @FXML
    public void initialize() {
        FileChooser fc = new FileChooser();
        fc.setTitle("Select file");
        fc.setInitialDirectory(new File("."));

        this.cfgSelectButton.setOnAction(e -> {
            fc.getExtensionFilters().clear();
            fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Config files (*.cfg)", "*.cfg"));
            fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("All files", "*.*"));
            File cfgFile = fc.showOpenDialog(null);
            if(cfgFile == null){
                return;
            }
            if(cfgFile.exists()){
                fc.setInitialDirectory(cfgFile.getParentFile());
                cfgPath.setText(fc.showOpenDialog(null).getAbsolutePath());
            }
        });
        this.ctiSelectButton.setOnAction(e -> {
            fc.getExtensionFilters().clear();
            fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("CTI files (*.cti)", "*.cti"));
            fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("All files", "*.*"));
            File ctiFile = fc.showOpenDialog(null);
            if(ctiFile == null){
                return;
            }
            if(ctiFile.exists()){
                fc.setInitialDirectory(ctiFile.getParentFile());
                ctiPath.setText(ctiFile.getAbsolutePath());
            }
        });

        this.newFileName.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if(newFileName.getText().isEmpty()){
                newFileName.setText("output.cfg");
                return;
            }
            if(!newFileName.getText().endsWith(".cfg")){
                newFileName.setText(newFileName.getText() + ".cfg");
            }
        });

        this.processButton.setOnAction(e -> {
            File cfgFile = new File(cfgPath.getText());
            File ctiFile = new File(ctiPath.getText());
            File outputFile = new File(cfgFile.getParentFile(), newFileName.getText());

            if(!cfgFile.exists()){
                alertLabel.setText("Config file not found!");
                return;
            }

            if(!ctiFile.exists()){
                alertLabel.setText("CTI file not found!");
                return;
            }

            VehicleConfig config = new VehicleConfig();
            config.read(cfgFile);

            VehicleCTI cti = new VehicleCTI();
            cti.read(ctiFile);

            VehicleUtils.removeUselessMeshes(config, cti, outputFile);
            alertLabel.setText("Done!");
        });
    }

}
