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
		int randomWaarde = getRandom(7) + 8;
		Speler.setHeight(randomWaarde * 10);
		// haalt power up weg
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
