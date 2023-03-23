package ping.entities.powerups;

import java.util.Random;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;


public class BalToevoegen extends PowerUp{
    public int aantalBallen;
	Random rand = new Random();

    public BalToevoegen(String resource, Coordinate2D initialLocation, Size size) {
        super(resource, initialLocation, size);
        aantalBallen = 1;
		setMotionPowerUp();
    }

    public void doPowerUp(){
//        aantalBallen++;
    	remove();
    }

    public int getAantalBallen(){
        return aantalBallen;
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
