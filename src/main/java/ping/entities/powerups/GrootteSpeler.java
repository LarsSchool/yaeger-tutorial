package ping.entities.powerups;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;

import ping.entities.speler.Speler;


public class GrootteSpeler extends PowerUp {

	public GrootteSpeler(String resource, Coordinate2D initialLocation, Size size) {
		super(resource, initialLocation, size);
		setMotionPowerUp();
	}

	public void doPowerUp() {
		int random = getRandom(2);
		//TO DO we moeten eerst de hitbox maken voor speler, want dan kan deze ook aangepast worden.
//		if(Speler.getHeight() > )
    	remove();
	}

	@Override
	public void setMotionPowerUp() {
		int random = getRandom(2);
		if (random == 0) {
			setMotion(1, 90d);
		} else {
			setMotion(1, 270d);
		}
	}

}
