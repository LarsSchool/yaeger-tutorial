package ping.entities.powerups;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;

import javafx.scene.paint.Color;

import java.util.Random;

public class GrootteSpeler extends PowerUp {
	Random rand = new Random();

	public GrootteSpeler(String resource, Coordinate2D initialLocation, Size size) {
		super(resource, initialLocation, size);
		setMotionPowerUp();
	}

	public void doPowerUp() {
		int random = rand.nextInt(2);
    	remove();
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
