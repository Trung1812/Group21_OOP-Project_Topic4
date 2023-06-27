package transition;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class QuickSort extends Application{
	@Override
	public void start(Stage stage) throws Exception{
		Parent root = FXMLLoader.load(getClass().getResource("QuickSortUI.fxml"));
		
		Scene scene = new Scene(root);
		
		stage.setTitle("Sorting Visualizer");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String args[]) {
		launch(args);
	}
	
}