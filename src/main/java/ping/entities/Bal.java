package ping.entities;

import java.util.Random;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import ping.entities.speler.Speler;

public class Bal extends DynamicSpriteEntity implements Collided {

	private static int aantalBalTouches = 0;
	private double richting;
	private Random rand = new Random();
	private Coordinate2D location;

	public Bal(String resource, Coordinate2D initialLocation, Size size) {
		super(resource, initialLocation, size);
		richting = getStartRichting();
		setMotion(4, richting);
		this.location = initialLocation;
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

	public static int getAantalBalTouches() {
		return aantalBalTouches;
	}

	public void setAantalBalTouches(int aantalBalTouches) {
		Bal.aantalBalTouches = aantalBalTouches;
	}

	@Override
	public void onCollision(Collider collidingObject) {
		aantalBalTouches++;
		if (collidingObject instanceof Border) {
//			if (richting > 90 && richting < 270) {
//				Coordinate2D locatie = new Coordinate2D(this.getAnchorLocation().getX(),
//						this.getAnchorLocation().getY() + 2);
//				setAnchorLocation(locatie);
//				setMotion(0, 0d);
//			} else if (richting >= 270 && richting <= 90) {
//				Coordinate2D locatie = new Coordinate2D(this.getAnchorLocation().getX(),
//						this.getAnchorLocation().getY() - 2);
//				setAnchorLocation(locatie);
//				setMotion(0, 180d);
//			}

			richting += 45 + getAfwijking(3);
			if (richting > 359) {
				richting -= 360;
			}
			setMotion(5, richting);
		} else if(collidingObject instanceof SingleplayerMuur){
			richting += 45 + getAfwijking(2);
			if (richting > 359) {
				richting -= 360;
			}
			setMotion(5, richting);
			}
		else if (collidingObject instanceof Speler) {
			if(richting > 90 && richting < 270) {
				Coordinate2D locatie = new Coordinate2D(this.getAnchorLocation().getX()- 5, this.getAnchorLocation().getY());
				setAnchorLocation(locatie);
			} else {
				Coordinate2D locatie = new Coordinate2D(this.getAnchorLocation().getX() + 5, this.getAnchorLocation().getY());
				setAnchorLocation(locatie);
			}
			if ((richting > 45 && richting < 135) || (richting > 225 && richting < 315)) {
				richting += 180 + getAfwijking(40);
			} else {
				richting += 90 + getAfwijking(40);
			}
			if (richting > 359) {
				richting -= 360;
			}
			setMotion(5, richting);
		}
	}
}
