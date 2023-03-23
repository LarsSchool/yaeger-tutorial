package ping.entities.powerups;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;


public class BalToevoegen extends PowerUp{
    public int aantalBallen;

    public BalToevoegen(String resource, Coordinate2D initialLocation, Size size) {
        super(resource, initialLocation, size);
        aantalBallen = 1;
    }

    public void doPowerUp(){
        aantalBallen++;
    }

    public int getAantalBallen(){
        return aantalBallen;
    }
}
