package ping.entities.powerups;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicCircleEntity;
import java.util.Random;

public abstract class  PowerUps extends DynamicCircleEntity implements Collided {
    public int powerUpRandom;
    public PowerUps(Coordinate2D initialLocation) {
        super(initialLocation);
    }

    @Override
    public void onCollision(Collider collidingObject) {
        Random rand = new Random();
        powerUpRandom = rand.nextInt(4);

        if(powerUpRandom == 0){

        }else if(powerUpRandom == 1){

        } else if(powerUpRandom == 2){

        }else if(powerUpRandom == 3){

        }
    }

    public abstract void doPowerUp();
}
