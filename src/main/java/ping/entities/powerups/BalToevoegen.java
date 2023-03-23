package ping.entities.powerups;

import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.paint.Color;


public class BalToevoegen extends PowerUps{
    public int aantalBallen;

    public BalToevoegen(Coordinate2D initialLocation) {
        super(initialLocation);
        aantalBallen = 1;
    }

    public void doPowerUp(){
        aantalBallen++;
    }

    public int getAantalBallen(){
        return aantalBallen;
    }
}
