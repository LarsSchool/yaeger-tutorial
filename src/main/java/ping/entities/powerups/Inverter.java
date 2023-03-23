package ping.entities.powerups;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;
import java.util.Set;

public class Inverter extends PowerUps implements KeyListener {
    public int invert;

    public Inverter(Coordinate2D initialLocation) {
        super(initialLocation);
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
