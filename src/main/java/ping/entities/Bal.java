package ping.entities;

import java.util.Random;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;

import ping.entities.speler.Speler;
import ping.entities.speler.Speler1;
import ping.entities.speler.Speler2;

public class Bal extends DynamicSpriteEntity implements Collided, SceneBorderTouchingWatcher {

	private static int aantalBalTouches = 0;
	private double richting;
	private Random rand = new Random();
	private Coordinate2D location;

	private boolean speler1Aangeraakt = false;
	private boolean speler2Aangeraakt = false;

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
		System.out.println(richting);
		if (collidingObject instanceof Border) {
//			if(richting > 270 && richting < 90) {
//				Coordinate2D locatie = new Coordinate2D(this.getAnchorLocation().getX(), this.getAnchorLocation().getY() - 5);
//				setAnchorLocation(locatie);
//			} else {
//				Coordinate2D locatie = new Coordinate2D(this.getAnchorLocation().getX(), this.getAnchorLocation().getY() + 5);
//				setAnchorLocation(locatie);
//			}

			// maken dat hij berekend met welke hoek hij moet terugstuiteren, dus
			// bijvoorbeeld 360 - 270 = 90, dus dan moet hij met 90 terugstuiteren.
			richting += 45 + getAfwijking(3);
			if (richting > 359) {
				richting -= 360;
			}
			setMotion(5, richting);
		} else if (collidingObject instanceof SingleplayerMuur) {
			richting += 45 + getAfwijking(2);
			if (richting > 359) {
				richting -= 360;
			}
			setMotion(5, richting);
		} else if (collidingObject instanceof Speler) {
			if (richting > 0 && richting < 180) {
				Coordinate2D locatie = new Coordinate2D(this.getAnchorLocation().getX() - 5,
						this.getAnchorLocation().getY());
				setAnchorLocation(locatie);
			} else {
				Coordinate2D locatie = new Coordinate2D(this.getAnchorLocation().getX() + 5,
						this.getAnchorLocation().getY());
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
		if (collidingObject instanceof Speler1 && !speler1Aangeraakt) {
			speler1Aangeraakt = true;
			speler2Aangeraakt = false;
			aantalBalTouches++;
		} else if (collidingObject instanceof Speler2 && !speler2Aangeraakt) {
			speler2Aangeraakt = true;
			speler1Aangeraakt = false;
			aantalBalTouches++;
		}
	}

	@Override
	public void notifyBoundaryTouching(SceneBorder border) {
		switch (border) {
		case LEFT:
			setAnchorLocation(location);
			richting = getStartRichting();
			setAantalBalTouches(0);
//			puntenSpeler2++;
			break;
		case RIGHT:
			setAnchorLocation(location);
			richting = getStartRichting();
			setAantalBalTouches(0);
//			puntenSpeler1++
			break;
		default:
			break;
		}
	}
}
