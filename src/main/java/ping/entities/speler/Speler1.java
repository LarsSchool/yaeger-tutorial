package ping.entities.speler;

import java.util.Random;
import java.util.Set;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Newtonian;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import com.github.hanyaeger.tutorial.Waterworld;
import com.github.hanyaeger.tutorial.entities.bubbles.AirBubble;
import com.github.hanyaeger.tutorial.entities.map.Coral;
import com.github.hanyaeger.tutorial.entities.text.BubblesPoppedText;
import com.github.hanyaeger.tutorial.entities.text.HealthText;


import javafx.scene.input.KeyCode;
import ping.Ping;

public class Speler1 extends Speler implements KeyListener, Collided, Collider {
	private Ping ping;

	public Speler1(Coordinate2D location, Ping ping) {
		super("sprites/player_1.png", location, new Size(40, 150));
		this.ping = ping;
	}

	@Override
	public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
		if (pressedKeys.contains(KeyCode.UP)) {
			setMotion(3, 180d);
		} else if (pressedKeys.contains(KeyCode.DOWN)) {
			setMotion(3, 0d);
		}
	}

	@Override
	public void onCollision(Collider collidingObject) {

	}
}
