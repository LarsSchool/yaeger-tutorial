package ping.entities.powerups;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;

import java.util.Random;
import java.util.Set;

public class Inverter extends PowerUp implements KeyListener {
    public int invert;

    public Inverter(Coordinate2D initialLocation) {
        super(null, initialLocation, null);
    }

    public void doPowerUp(){

    }

    public int getInvert(){
        return invert;
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> set) {

    }
}
