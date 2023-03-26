package ping.entities.speler;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;
import ping.Ping;
import ping.entities.Border;
import ping.entities.scorebord.PuntenSpeler2;

import java.util.Set;

public class Speler2 extends Speler implements KeyListener, Collided, Collider {
	private static boolean inverted = false;
	private static int puntenAantal = 0;

	// constructor van speler 2
	public Speler2(Coordinate2D location, Size size, PuntenSpeler2 puntenSpeler2) {
		super("sprites/player_2.png", location, size);
	}

	@Override
	public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
		// zorgt voor beweging speler 2 met de pijltjes
		if (Ping.getSpelerAantal() == 2 && !inverted) {
			if (pressedKeys.contains(KeyCode.UP)) {
				setMotion(4, 180d);
			} else if (pressedKeys.contains(KeyCode.DOWN)) {
				setMotion(4, 0d);
			} else {
				setSpeed(0);
			}
		} else if (Ping.getSpelerAantal() == 2 && inverted) {
			if (pressedKeys.contains(KeyCode.DOWN)) {
				setMotion(4, 180d);
			} else if (pressedKeys.contains(KeyCode.UP)) {
				setMotion(4, 0d);
			} else {
				setSpeed(0);
			}
		} 
	}

	public static void invert() {
		if (inverted) {
			inverted = false;
		} else {
			inverted = true;
		}
	}

	@Override
	public void onCollision(Collider collidingObject) {
		if (collidingObject instanceof Border) {
			if (this.getDirection() == 0) {
				Coordinate2D locatie = new Coordinate2D(this.getAnchorLocation().getX(),
						this.getAnchorLocation().getY() - 2);
				setAnchorLocation(locatie);
				setSpeed(0);
			} else if (this.getDirection() == 180) {
				Coordinate2D locatie = new Coordinate2D(this.getAnchorLocation().getX(),
						this.getAnchorLocation().getY() + 2);
				setAnchorLocation(locatie);
//				setMotion(0, 180d);
				setSpeed(0);
			}
		}
	}
	
	@Override
	public void setPuntenAantal(int waarde) {
		puntenAantal = waarde;
	}
	
	@Override
	public int getPuntenAantal() {
		return puntenAantal;
	}
}
