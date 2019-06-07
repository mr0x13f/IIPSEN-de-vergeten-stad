package View;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ViewManager extends Application{

    static Stage primaryStage;
    String kaart = "/gamescreenempty.png";
    private double windowWidth = 1600;
    private double windowHeight = 900;
    private double windowAnchorX = 50;
    private double windowAnchorY= 50;


    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        //loadLoginView();
        loadGameView();
    }

    public void loadLoginView() {

        new LoginView(primaryStage, this);

    }

    public void loadGameView() {
        try {

            BordView bordView = new BordView();  //maak achtergrond
            ActieKnoppenView actieknoppenview = new ActieKnoppenView();  //maak beweeg knoppen
            GraafKnoppenView graafknoppenview = new GraafKnoppenView();  //maak graaf knoppen
            //LoadBordView loadbordview = new LoadBordView();  //geen idee wat deze doet
            OnderdeelView onderdeelview = new OnderdeelView();  //maak onderdelen
            SpeelbordView speelbordview = new SpeelbordView();  //maak speelbord tiles
            //    SpelerView spelerview = new SpelerView();           //maak speler poppetjes en zijkant informatie
            StormView stormview = new StormView();              //maak storm en stormmeter
            UitrustingView uitrustingview = new UitrustingView();   //maak uitrusting plaatsen
            WaterflesView waterflesView = new WaterflesView(4);      //maak waterfles stand
            SpeelbordView speelbordView = new SpeelbordView();

            ImageView waterfles = waterflesView.loadWaterfles();
            waterflesView.updateWaterFles(0);

            ImageView achtergrond = bordView.maakAchtergrond(windowWidth, windowHeight);
            StackPane propellor = onderdeelview.loadPropeller("?", "?");
            StackPane beacon = onderdeelview.loadBeacon("?", "?");
            StackPane motor = onderdeelview.loadMotor("?", "?");
            StackPane zonnewijzer = onderdeelview.loadZonneWijzer("?", "?");
            GridPane knoppen = actieknoppenview.maakActieKnoppen();
            GridPane graafknoppen = graafknoppenview.maakGraafKnoppen();
            GridPane spelbord = speelbordView.loadSpelBord();


            Group group = new Group(achtergrond, knoppen, graafknoppen, waterfles, propellor, beacon, motor, zonnewijzer, spelbord);
            Scene scene = new Scene(group, windowWidth, windowHeight);
            primaryStage.setScene(scene);
            primaryStage.setTitle("WELCOME TO THE GAME");
            primaryStage.setX(windowAnchorX);
            primaryStage.setY(windowAnchorY);
            primaryStage.show();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}
