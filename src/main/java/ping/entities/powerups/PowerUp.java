package ping.entities.powerups;

import java.util.Random;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import ping.entities.Bal;

public abstract class  PowerUp extends DynamicSpriteEntity implements Collided {
    public int aantalBalTouches;
    
    private Random rand = new Random();
    
    public PowerUp(String resource, Coordinate2D initialLocation, Size size) {
        super(resource, initialLocation, size);
        aantalBalTouches = Bal.getAantalBalTouches();
    }

    @Override
    public void onCollision(Collider collidingObject) {
    	doPowerUp();
    }
    
    public int getRandom(int waarde) {
		return rand.nextInt(waarde);
    }

    public abstract void doPowerUp();
    
    public abstract void setMotionPowerUp();
}
