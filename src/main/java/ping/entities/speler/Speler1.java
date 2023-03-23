package ping.entities.speler;

import java.util.Set;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.userinput.KeyListener;


import javafx.scene.input.KeyCode;
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
        if (pressedKeys.contains(KeyCode.W)) {
            setMotion(4, 180d);
        } else if (pressedKeys.contains(KeyCode.S)) {
            setMotion(4, 0d);
        } else {
			setMotion(0,0d);
			}
		}

	//TO DO---------------------------------------------------------------------------------------------
	@Override
	public void onCollision(Collider collidingObject) {
		setMotion(0,0d);
		if(collidingObject instanceof Border) {
			Coordinate2D locatie = new Coordinate2D(this.getAnchorLocation().getX()- 5, this.getAnchorLocation().getY());
			setAnchorLocation(locatie);
		} else {
			Coordinate2D locatie = new Coordinate2D(this.getAnchorLocation().getX() + 5, this.getAnchorLocation().getY());
			setAnchorLocation(locatie);
		}
		
	}

}
