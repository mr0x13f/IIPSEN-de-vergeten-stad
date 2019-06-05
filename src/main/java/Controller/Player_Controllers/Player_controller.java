package Controller.Player_Controllers;

import Model.data.StaticData;
import Model.player.Navigator;
import Model.player.Player;
import com.sun.org.apache.xpath.internal.operations.Bool;
import javafx.scene.paint.Color;

import java.util.Map;

public class Player_controller {


    static Player_controller playercont;
    Player player;




    public Player_controller(String className, String imagePath){
        player = new Player("a",className, "b", 4, Color.BLUE, imagePath);
    }


    public Player_controller(String n, String className, String b, int maxwater, Color color, String imagePath){
        player = new Player("a",className, "b", 4, Color.BLUE, imagePath);
    }
    // Singleton Pattern.
    // now we can call: SpelbordController.getInstance()  from everywhere
    // AND it guarantees there is only 1 instance.
    public static Player_controller getInstance(boolean loadGame, String className) {
        if (playercont == null) {
            if( loadGame){

                System.out.println(((Map)(StaticData.getInstance()).getRoomInfo()).get("archeoloog"));
                playercont = new Player_controller(className, className +".png");
            }else{}
        }
        return playercont;
    }

    public static Player_controller getInstance() {
        return playercont;
    }

    public void move(){

    }

    public void zandWegScheppen(){

    }

    public void Uitgraven(){

    }

    public void eenOnderdeelOppakken(){

    }

    public void drinkWater(){
        player.subtractWater(1);
        System.out.println(player.getWater());
    }


    public void giveWater(Player receiver, int amount){
        if(this.getPlayer().getWater() == 0){
            System.out.println("You dont have any water to given");
        } else if( receiver.getWater() >= receiver.getMaxWater()){
            System.out.println(receiver.getClassName() + " has already full water");
        }else{
            this.player.subtractWater(amount);
            receiver.addWater(amount);
        }


    }


    public Player getPlayer() {
        return player;
    }
}
