package pl.paisley4.omsivehicleutils.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MainController {

    @FXML
    private Label testlabel;

    @FXML
    private Button testbutton;

    @FXML
    public void initialize() {
        this.testbutton.setOnAction(e -> {
            if(testlabel.getText().equalsIgnoreCase("Hello World")){
                testlabel.setText("Hello OMSI");
                return;
            }
            testlabel.setText("Hello World");
        });
    }

}
