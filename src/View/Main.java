package View;

import Controller.Controller;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

public class Main /*extends Application*/{
	
	private int screenWidth = 1600;
	private int screenHeight = 900;
    
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.launch(args);
    }
    
	/*@Override
	public void start(Stage primaryStage) throws Exception {
		
		Bord bord = new Bord();
		
        Canvas canvas = new Canvas(screenWidth, screenHeight);
        Group root = new Group(canvas);
        Scene scene = new Scene(root);
        
        primaryStage.setTitle("De Vergeten Stad");
        primaryStage.setScene(scene);
        primaryStage.show();
		
	    ////////////////////////// Main Loop //////////////////////////
		new AnimationTimer() {
            @Override
            public void handle(long now) {
                
            	GraphicsContext gc = canvas.getGraphicsContext2D();
            	bord.render(gc);
            	
            }
        }.start();
		
	}*/
	
}
