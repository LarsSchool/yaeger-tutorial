package ping.entities.powerups;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import javafx.scene.paint.Color;

import java.util.Random;

public class Inverter extends PowerUps{
    public int snelheidBal;

    public Inverter(Coordinate2D initialLocation) {
        super(initialLocation);
    }

    public void doPowerUp(){
        Random rand = new Random();
        int nieuweSnelheid = rand.nextInt( 2,7);
        while(nieuweSnelheid > 7 || nieuweSnelheid < 2 || snelheidBal == nieuweSnelheid){
            nieuweSnelheid = rand.nextInt( 2,7);
        }
    }

    public int getSnelheidBal(){
        return snelheidBal;
    }

    public Color getKleur(){
        return Color.BLUE;
    }
}
