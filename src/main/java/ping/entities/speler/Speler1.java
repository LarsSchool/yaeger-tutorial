package ping.entities.speler;

import java.util.Set;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;
import ping.Ping;
import ping.entities.Border;

public class Speler1 extends Speler implements KeyListener, Collided, Collider {
	private Coordinate2D location;
	private Size size;

	public Speler1(Coordinate2D location, Size size) {
		super("sprites/player_1.png", location, size);
		this.location = location;
		this.size = size;
	}

	@Override
	public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
		if (Ping.getSpelerAantal() == 1) {
			if (pressedKeys.contains(KeyCode.UP)) {
				setMotion(4, 180d);
			} else if (pressedKeys.contains(KeyCode.DOWN)) {
				setMotion(4, 0d);
			} else if (pressedKeys.contains(KeyCode.W)) {
				setMotion(4, 180d);
			} else if (pressedKeys.contains(KeyCode.S)) {
				setMotion(4, 0d);
			} else {
				setSpeed(0);
			}
		} else if (Ping.getSpelerAantal() == 2) {
			if (pressedKeys.contains(KeyCode.W)) {
				setMotion(4, 180d);
			} else if (pressedKeys.contains(KeyCode.S)) {
				setMotion(4, 0d);
			} else {
				setSpeed(0);
			}
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
}
