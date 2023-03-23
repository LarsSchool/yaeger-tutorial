package ping.entities;

import java.util.Optional;
import java.util.Random;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

import javafx.scene.Node;
import ping.entities.speler.Speler;

public class Bal extends DynamicSpriteEntity implements Collided {

	private int aantalBalTouches = 0;
	private double richting;
	private Random rand = new Random();

	public Bal(String resource, Coordinate2D initialLocation, Size size) {
		super(resource, initialLocation, size);
		richting = getStartRichting();
		setMotion(4, richting);
	}

	public double getStartRichting() {
		double resultaat;
		int random = rand.nextInt(2);
		if (random == 0) {
			resultaat = 270d;
		} else {
			resultaat = 90d;
		}
		return resultaat + getAfwijking(5);
	}

	public int getAfwijking(int aantal) {
		int random = rand.nextInt(2);
		int afwijking = rand.nextInt(aantal) + 1;
		if (random == 0) {
			return afwijking;
		} else {
			return -afwijking;
		}
	}

	public int getAantalBalTouches() {
		return aantalBalTouches;
	}

	public void setAantalBalTouches(int aantalBalTouches) {
		this.aantalBalTouches = aantalBalTouches;
	}

	@Override
	public void onCollision(Collider collidingObject) {
		aantalBalTouches++;
		if (collidingObject instanceof Border) {
			richting += 90 + getAfwijking(5);
			if (richting > 359) {
				richting -= 360;
			}
			setMotion(5, richting);
		} else if (collidingObject instanceof Speler) {
			if ((richting > 45 && richting < 135) || (richting > 225 && richting < 315)) {
				richting += 180 + getAfwijking(30);
			} else {
				richting += 90 + getAfwijking(30);
			}
			if (richting > 359) {
				richting -= 360;
			}
			setMotion(5, richting);
		}
	}

}
