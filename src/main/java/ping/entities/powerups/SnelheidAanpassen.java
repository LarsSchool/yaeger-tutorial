package ping.entities.powerups;

import com.github.hanyaeger.api.Coordinate2D;
import java.util.Random;

public class SnelheidAanpassen extends PowerUps {
    public int snelheidBal;

    public SnelheidAanpassen(Coordinate2D initialLocation) {
        super(initialLocation);
        snelheidBal = 4;
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
}
