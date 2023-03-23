package ping.entities.powerups;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;

import java.util.Random;
import java.util.Set;

public class Inverter extends PowerUp implements KeyListener {
    public int invert;
	Random rand = new Random();


    public Inverter(String resource, Coordinate2D initialLocation, Size size) {
        super(resource, initialLocation, size);
		setMotionPowerUp();
    }

    public void doPowerUp(){
    	remove();
    }

    public int getInvert(){
        return invert;
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> set) {

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
