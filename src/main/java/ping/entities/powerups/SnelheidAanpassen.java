package ping.entities.powerups;



import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;

import javafx.scene.paint.Color;

import java.util.Random;

public class SnelheidAanpassen extends PowerUp {
    public int snelheidBal;
	Random rand = new Random();

    public SnelheidAanpassen(String resource, Coordinate2D initialLocation, Size size) {
        super(resource, initialLocation, size);
        snelheidBal = 4;
		setMotionPowerUp();
    }

    public void doPowerUp(){
//        Random rand = new Random();
//        int nieuweSnelheid = rand.nextInt(5) + 2;
//        while(nieuweSnelheid > 7 || nieuweSnelheid < 2 || snelheidBal == nieuweSnelheid){
//            nieuweSnelheid = rand.nextInt(5) + 2;
//        }
    	remove();
    }

    public int getSnelheidBal(){
        return snelheidBal;
    }

	@Override
	public void setMotionPowerUp() {
		int random = rand.nextInt(2);
		if (random == 0) {
			setMotion(1, 90d);
		} else {
			setMotion(1, 270d);
		}
	}
}
