package gui.application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
	    try {
	    	BorderPane root = FXMLLoader.load(getClass().getResource("FXML/App.fxml"));
	        Scene scene = new Scene(root, 1336,768);
	        primaryStage.setScene(scene);
	        primaryStage.setTitle("Service Log Analysis");
	        primaryStage.show();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}


	
	public static void main(String[] args) {
		launch(args);
	}
}
