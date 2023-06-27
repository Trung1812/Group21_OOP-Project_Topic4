package test;

import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class AnimationOnHBox extends Application{
	@Override
	public void start(Stage stage) throws Exception{
		HBox hbox = new HBox();
		
		Rectangle rec1 = new Rectangle(50,50);
		Rectangle rec2 = new Rectangle(50, 50);
		
		
		
		TranslateTransition transition1= new TranslateTransition();
		transition1.setToX(40);
		transition1.setToY(40);
		
		transition1.setAutoReverse(true);
		transition1.setDuration(Duration.seconds(3));
		
		transition1.setNode(rec1);
		transition1.play();
		
		
		TranslateTransition transition2 = new TranslateTransition();
		transition2.setToX(0);
		transition2.setToY(90);
		
		transition2.setDuration(Duration.seconds(3));
		
		transition2.setNode(rec2);
		transition2.play();
		
		hbox.getChildren().add(rec2);
		hbox.getChildren().add(rec1);
		
		Scene scene = new Scene(hbox, 600, 600);
		
		stage.setTitle("Transition!");
		stage.setScene(scene);
		stage.show();
		
	}
	
	public static void main(String args[]) {
		launch(args);
	}
	

	

}
