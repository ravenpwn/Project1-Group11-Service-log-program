package gui.test;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import util.CreateLog;

public class TestPaneController {

    @FXML
    private Button testbutton;

    @FXML
    void btnPressed(ActionEvent event) throws IOException {
    	PopUpTable popUpTable = new PopUpTable(CreateLog.createApacheAccessLog("./log/access.json"));
    	BorderPane pane = popUpTable.createTableView();
		Stage stage = new Stage();
		Scene scene = new Scene(pane, 1024, 640);
		stage.setScene(scene);
		stage.show();
    }
    
}