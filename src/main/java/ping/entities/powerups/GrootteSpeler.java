package ping.entities.powerups;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;

import ping.entities.speler.Speler;
import ping.entities.speler.Speler1;
import ping.entities.speler.Speler2;

public class GrootteSpeler extends PowerUp {
	
	private Speler1 speler1;
	private Speler2 speler2;

	public GrootteSpeler(String resource, Coordinate2D initialLocation, Size size, Speler1 speler1, Speler2 speler2) {
		super(resource, initialLocation, size);
		this.speler1 = speler1;
		this.speler2 = speler2;
		setMotionPowerUp();
	}

	public void doPowerUp() {
		int random = getRandom(2);
		int randomWaarde = getRandom(7) + 8;
		speler1.setHeight(randomWaarde * 10);
		speler2.setHeight(randomWaarde * 10);
		speler1 = new Speler1(speler1.getAnchorLocation(), new Size(speler1.getWidth(), randomWaarde));
		speler2 = new Speler2(speler2.getAnchorLocation(), new Size(speler2.getWidth(), randomWaarde));

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
