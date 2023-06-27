package transition;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;



public class QuickSortController {

    @FXML
    private TextArea arrayTextArea;

    @FXML
    private HBox arrayVisualizer;

    @FXML
    private Button generateBtn;

    @FXML
    private ToggleGroup sortAlgoritm;

    @FXML
    private Button sortBtn;
    
    @FXML
    private TextField arraySizeTF;
    
    @FXML
    private TextField speedTF;
    
    @FXML
    private TextField timeTF;
    
    private List<Rectangle> recList = new ArrayList<>();

    @FXML
    void handleGenerateButton(ActionEvent event) {
    	arrayVisualizer.getChildren().clear();
    	int arrLen = Integer.parseInt(arraySizeTF.getText());
    	List<Integer> array = generateRandomArray(arrLen);
    	
    	double hboxWidth = arrayVisualizer.getWidth();
    	double recWidth = hboxWidth/arrLen;
    	double maxLen = arrayVisualizer.getHeight();
    	int maximum = array.get(0);
    	for (int i = 0; i < arrLen; i++) {
    		if (maximum < array.get(i)) {
    			maximum = array.get(i);
    		}
    	}
    	for (int i = 0; i < arrLen; i++) {
    		double recLen = ((double)array.get(i)/maximum)*maxLen;
    		Rectangle rec = new Rectangle(recWidth, recLen);
    		rec.setStrokeWidth(10);
    		rec.setVisible(true);
    		
    		arrayVisualizer.getChildren().add(rec);
    		recList.add(rec);
    	}
    	
    	
    	String listString = array.stream().map(Object::toString)
                .collect(Collectors.joining(", "));
    	arrayTextArea.setText(listString);
    	
    }
    
    public List<Integer> generateRandomArray(int n){
        ArrayList<Integer> list = new ArrayList<Integer>(n);
        Random random = new Random();
        
        for (int i = 0; i < n; i++)
        {
            list.add(random.nextInt(1000));
        }
       return list;
    }  
    
    @FXML
    void handleSortButton(ActionEvent event) {
    	for (int i = 0; i < recList.size() - 1; i++) {
    		Rectangle node1 = recList.get(i);
    		Rectangle node2 = recList.get(i+1);
    		node1.setFill(Color.AZURE);
    		node2.setFill(Color.AZURE);
    		if (node1.getHeight() > node2.getHeight()) {
    			TranslateTransition transition1 = new TranslateTransition();
    			TranslateTransition transition2 = new TranslateTransition();
    			transition1.setDuration(Duration.seconds(0.1));
    			transition2.setDuration(Duration.seconds(0.1));
    			
    			double pos1 = node1.getX();
    			double pos2 = node2.getX();
    			
    			transition1.setToX(pos2);
    			transition1.setNode(node1);
    			
    			transition2.setToX(pos1);
    			transition2.setNode(node2);
    			
    			transition1.play();
    			transition2.play();
    			
    			
    		} else {
    			node1.setFill(Color.BLACK);
    			node2.setFill(Color.BLACK);
    		}
    		
    		
    	}
    }
}
