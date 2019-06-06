package View;

import Controller.Bord_Controllers.Bord_Controller;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import observers.*;
import Controller.Controller;

public class BordView {

    ActieKnoppenView AKV = new ActieKnoppenView();
    Controller controller = Controller.getInstance();

    public static GridPane gridPane;

    String kaart = "/gamescreenempty.png";
    //String file = "C:\\Users\\mjboere\\workspace\\Hello FX World\\src\\wereldkaart.jpg";
    private double width = 1600;
    private double height = 900;
    private double windowAnchorX = 50;
    private double windowAnchorY= 50;

    static Stage primaryStage;
    Bord_Controller bordController;
    TextField usernameField = new TextField();
    TextField passwordField = new TextField();
    Button zonBrand = new Button("Burn");


    public BordView(Stage s){
        primaryStage = s;
        loadPrimaryStage(createInitialGridPane(), createButtons());
        bordController = bordController.getInstance();


        //WaterflesView  waterflesView = new WaterflesView(5);
        //ImageView waterflesImageView = waterflesView.loadWaterfles();
        //gridPane.add(waterflesImageView,0,0 );
        //waterflesView.updateWaterFles(0);

        // PASS IT TO THE CONTROLLER WHO WILL PASS IT TO THE MODEL
        //bordController.registerObserver((BordObserver) this);

    }

    private void loadPrimaryStage(GridPane gp, GridPane actie) {
        try {


            Pane root = new Pane();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("De Vergeten Stad");
            primaryStage.setX(windowAnchorX);
            primaryStage.setY(windowAnchorY);
            primaryStage.show();

            Image backgroundImage = new Image("/background.png");
            ImageView backgroundImageView = new ImageView(backgroundImage);
            root.getChildren().add(backgroundImageView);
            backgroundImageView.setX(0);
            backgroundImageView.setY(0);
            backgroundImageView.setFitWidth(width);
            backgroundImageView.setFitHeight(height);

            // gc.drawImage(backgroundImage, 0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
            /*Bord_Controller b = new Bord_Controller(root);*/
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private GridPane createInitialGridPane(){
        Text scoreText = new Text("Player Score");

        Button submitButton = new Button("Submit");
        //submitButton.addEventFilter(MouseEvent.MOUSE_CLICKED, submitClicked);
        zonBrand.addEventFilter(MouseEvent.MOUSE_CLICKED, zonBrandClicked);

        GridPane gridPane = new GridPane();
        gridPane.setMinSize(400, 200);
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(5);
        gridPane.setHgap(5);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.add(zonBrand, 1, 2);

        //gridPane.add(image, 0, 0);
        //gridPane.add(scoreText, 1, 0);

        return gridPane;
    }

    private GridPane createUpdatedGridPane(BordObservable sb){
/*
        if(sb.isLoginCorrect()){
            return loginCorrect(sb);
        }else{
            return loginIncorrect(sb);
        }*/

        return new GridPane();

    }

    public GridPane loginCorrect(BordObservable sb){
        Text scoreText = new Text("Player Score");
        Button startButton = new Button("Start Game");
        //startButton.addEventFilter(MouseEvent.MOUSE_CLICKED, startClicked);



        GridPane gridPane = new GridPane();
        gridPane.setMinSize(400, 200);
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(5);
        gridPane.setHgap(5);
        gridPane.setAlignment(Pos.CENTER);

        gridPane.add(startButton, 0,0);

        return gridPane;
    }

    public GridPane createButtons(){
        GridPane buttonsPane = AKV.maakActieKnoppen();
        return buttonsPane;
    }

    EventHandler<javafx.scene.input.MouseEvent> zonBrandClicked = new EventHandler<javafx.scene.input.MouseEvent>() {
        @Override
        public void handle(javafx.scene.input.MouseEvent e) {
            controller.verwijderZand();
            System.out.println("button clicked");
        }
    };
}
