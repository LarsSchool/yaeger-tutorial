package ping.entities.powerups;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;

import javafx.scene.paint.Color;

import java.util.Random;

public class GrootteSpeler extends PowerUp{
    public int snelheidBal;

    public GrootteSpeler(String resource, Coordinate2D initialLocation, Size size) {
        super(resource, initialLocation, size);
    }

    public void doPowerUp(){
        Random rand = new Random();
		int random = rand.nextInt(2);
    }
    
    public void teken() {
    	
    }

}
