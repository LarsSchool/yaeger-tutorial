package ping.entities.powerups;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import ping.entities.speler.Speler1;
import ping.entities.speler.Speler2;

public class Inverter extends PowerUp implements Collided {
	public int invert;

	public Inverter(String resource, Coordinate2D initialLocation, Size size) {
		super(resource, initialLocation, size);
		setMotionPowerUp();
	}

	@Override
	public void onCollision(Collider collidingObject) {
		if (collidingObject instanceof Speler1) {
			Speler2.invert();
		} else if (collidingObject instanceof Speler2) {
			Speler1.invert();
		}
		doPowerUp();
	}

	public void doPowerUp() {
		// haalt power up weg
		remove();
	}

	public int getInvert() {
		return invert;
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
