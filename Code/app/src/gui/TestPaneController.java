package gui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class TestPaneController {

    @FXML
    private Button testbutton;

    @FXML
    void btnPressed(ActionEvent event) throws IOException {
    	PopUpTable popUpTable = new PopUpTable(null);
    	BorderPane pane = popUpTable.createTableView();
		Stage stage = new Stage();
		Scene scene = new Scene(pane, 1024, 640);
		stage.setScene(scene);
		stage.show();
    }
    
}