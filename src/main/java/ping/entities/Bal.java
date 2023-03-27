package ping.entities;

import java.util.Random;
import java.util.Set;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;

import javafx.scene.input.KeyCode;
import ping.Ping;
import ping.entities.speler.Speler;
import ping.entities.speler.Speler1;
import ping.entities.speler.Speler2;
import ping.scenes.multiplayer.GameOverMultiplayer;
import ping.entities.powerups.BalToevoegen;
import ping.entities.scorebord.PuntenSpeler1;
import ping.entities.scorebord.PuntenSpeler2;

public class Bal extends DynamicSpriteEntity implements Collided, SceneBorderTouchingWatcher, KeyListener {

	private static int aantalBalTouches = 0;
	private double richting;
	private Random rand = new Random();
	private Coordinate2D location;
	private static int balSnelheid;

	private Speler speler1;
	private Speler speler2;

	private PuntenSpeler1 puntenSpeler1;
	private PuntenSpeler2 puntenSpeler2;

	private Middenlijn middenlijn;

	private Ping ping;

	private boolean speler1Aangeraakt = false;
	private boolean speler2Aangeraakt = false;

	// constructor bal multiplayer
	public Bal(Ping ping, String resource, Coordinate2D initialLocation, Size size, Speler speler1, Speler speler2,
			PuntenSpeler1 puntenSpeler1, PuntenSpeler2 puntenSpeler2, Middenlijn middenlijn) {
		super(resource, initialLocation, size);
		richting = getStartRichting();
		balSnelheid = 5;
		setMotion(balSnelheid, richting);
		this.ping = ping;
		this.location = initialLocation;
		this.speler1 = speler1;
		this.speler2 = speler2;
		this.puntenSpeler1 = puntenSpeler1;
		this.puntenSpeler2 = puntenSpeler2;
		this.middenlijn = middenlijn;
	}

	// constructor bal singleplayer
	public Bal(Ping ping, String resource, Coordinate2D initialLocation, Size size, Speler speler1,
			PuntenSpeler1 puntenSpeler1) {
		super(resource, initialLocation, size);
		richting = getStartRichting();
		balSnelheid = 5;
		setMotion(balSnelheid, richting);
		this.ping = ping;
		this.location = initialLocation;
		this.speler1 = speler1;
		this.puntenSpeler1 = puntenSpeler1;
	}

	public static void setBalSnelheid(int waarde) {
		balSnelheid = waarde;
	}

	public static int getBalSnelheid() {
		return balSnelheid;
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

			setMotion(balSnelheid, richting);
		} else if (collidingObject instanceof SingleplayerMuur) {
			richting += 45 + getAfwijking(2);
			if (richting > 359) {
				richting -= 360;
			}
			setMotion(balSnelheid, richting);
		} else if (collidingObject instanceof Speler) {
			if (richting > 0 && richting < 180) {
				Coordinate2D locatie = new Coordinate2D(this.getAnchorLocation().getX() - 10,
						this.getAnchorLocation().getY());
				setAnchorLocation(locatie);
			} else {
				Coordinate2D locatie = new Coordinate2D(this.getAnchorLocation().getX() + 10,
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
			setMotion(balSnelheid, richting);
			if (Ping.getSpelerAantal() == 2) {
				if (collidingObject instanceof Speler1 && !speler1Aangeraakt) {
					speler1Aangeraakt = true;
					speler2Aangeraakt = false;
					aantalBalTouches++;
					middenlijn.middenlijnExpand(middenlijn.getWidth() + 10, 10);
				} else if (collidingObject instanceof Speler2 && !speler2Aangeraakt) {
					speler2Aangeraakt = true;
					speler1Aangeraakt = false;
					aantalBalTouches++;
					middenlijn.middenlijnExpand(middenlijn.getWidth() + 10, 10);
				}
			} else if (Ping.getSpelerAantal() == 1) {
				speler1.setPuntenAantal(speler1.getPuntenAantal() + 1);
				puntenSpeler1.setPuntenText(speler1.getPuntenAantal());
				aantalBalTouches++;
				balSnelheid += 1;
			}
		}
	}

	@Override
	public void notifyBoundaryTouching(SceneBorder border) {
		if (Ping.getSpelerAantal() == 2) {
			switch (border) {
			case LEFT:
				setAnchorLocation(location);
				richting = getStartRichting();
				setAantalBalTouches(0);
				setBalSnelheid(5);
				speler2.setPuntenAantal(speler2.getPuntenAantal() + 1);
				puntenSpeler2.setPuntenText(speler2.getPuntenAantal());
				if (BalToevoegen.getAantalBallen() > 1) {
					remove();
					BalToevoegen.SetAantalBallen(BalToevoegen.getAantalBallen() - 1);
				}
				if (checkGewonnen()) {
					speler1.setPuntenAantal(0);
					puntenSpeler1.setPuntenText(speler1.getPuntenAantal());
					speler2.setPuntenAantal(0);
					puntenSpeler2.setPuntenText(speler2.getPuntenAantal());
					GameOverMultiplayer.setGewonnenSpeler(2);
					ping.setActiveScene(2);
				}
				break;
			case RIGHT:
				setAnchorLocation(location);
				richting = getStartRichting();
				setAantalBalTouches(0);
				setBalSnelheid(5);
				speler1.setPuntenAantal(speler1.getPuntenAantal() + 1);
				puntenSpeler1.setPuntenText(speler1.getPuntenAantal());
				if (BalToevoegen.getAantalBallen() > 1) {
					remove();
					BalToevoegen.SetAantalBallen(BalToevoegen.getAantalBallen() - 1);
				}
				if (checkGewonnen()) {
					speler1.setPuntenAantal(0);
					puntenSpeler1.setPuntenText(speler1.getPuntenAantal());
					speler2.setPuntenAantal(0);
					puntenSpeler2.setPuntenText(speler2.getPuntenAantal());
					GameOverMultiplayer.setGewonnenSpeler(1);
					ping.setActiveScene(2);
				}
				break;
			default:
				break;
			}
		} else if (Ping.getSpelerAantal() == 1) {
			switch (border) {
			case RIGHT:
				speler1.setPuntenAantal(0);
				puntenSpeler1.setPuntenText(speler1.getPuntenAantal());
				ping.setActiveScene(4);
				break;
			default:
				break;
			}
		}
	}

	@Override
	public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
		if (pressedKeys.contains(KeyCode.R) && ping.getSpelerAantal() == 2) {
			setAnchorLocation(location);
			richting = getStartRichting();
			setAantalBalTouches(0);
			setBalSnelheid(5);
		}
	}

	public boolean checkGewonnen() {
		if (speler1.getPuntenAantal() >= 10 || speler2.getPuntenAantal() >= 10) {
			return true;
		} else {
			return false;
		}
	}
}
