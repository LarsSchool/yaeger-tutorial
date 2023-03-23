package ping.entities.powerups;



import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;

import javafx.scene.paint.Color;

import java.util.Random;

public class SnelheidAanpassen extends PowerUp {
    public int snelheidBal;

    public SnelheidAanpassen(String resource, Coordinate2D initialLocation, Size size) {
        super(resource, initialLocation, size);
        snelheidBal = 4;
    }

    public void doPowerUp(){
        Random rand = new Random();
        int nieuweSnelheid = rand.nextInt(5) + 2;
        while(nieuweSnelheid > 7 || nieuweSnelheid < 2 || snelheidBal == nieuweSnelheid){
            nieuweSnelheid = rand.nextInt(5) + 2;
        }
    }

    public int getSnelheidBal(){
        return snelheidBal;
    }
}
