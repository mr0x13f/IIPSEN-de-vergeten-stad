package View.bord_views;

import Controller.Player_Controllers.Player_Controller;
import Model.Tiles.Tile;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import java.awt.*;

public class ActieKnoppenView {

    static GridPane view = new GridPane();

    public GridPane maakActieKnoppen(){
        Button up = new Button("▲");
        Button down = new Button("▼");
        Button left = new Button("◄");
        Button right = new Button("►");
        Button TileActions = new Button("Actie");
        up.setPrefSize(60, 60);
        down.setPrefSize(60, 60);
        left.setPrefSize(60, 60);
        right.setPrefSize(60, 60);
        TileActions.setPrefSize(60, 60);

        GridPane acties = new GridPane();

        acties.add(up, 1, 0);
        acties.add(down, 1, 2);
        acties.add(left, 0, 1);
        acties.add(right, 2, 1);
        acties.add(TileActions, 1, 1);

        acties.setLayoutX(319);
        acties.setLayoutY(685);

        up.setOnMouseClicked(e -> {
            Player_Controller playerController = Player_Controller.getInstance();
            playerController.moveNoord();
        });

        down.setOnMouseClicked(e -> {
            Player_Controller playerController = Player_Controller.getInstance();
            playerController.moveZuid();
        });

        right.setOnMouseClicked(e -> {
            Player_Controller playerController = Player_Controller.getInstance();
            playerController.moveOost();
        });

        left.setOnMouseClicked(e -> {
            Player_Controller playerController = Player_Controller.getInstance();
            playerController.moveWest();
        });

        TileActions.setOnMouseClicked(e -> {
            Player_Controller playerController = Player_Controller.getInstance();
            playerController.tileActies();
        });

        view = acties;
        return acties;
    }



    public static GridPane getView() {
        return view;
    }
}
