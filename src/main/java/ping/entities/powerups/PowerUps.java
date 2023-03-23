package ping.entities.powerups;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicCircleEntity;
import ping.entities.Bal;

import java.util.Random;

public abstract class  PowerUps extends DynamicCircleEntity implements Collided {
    public int powerUpRandom;
    public int aantalBalTouches;
    public PowerUps(Coordinate2D initialLocation) {
        super(initialLocation);
        aantalBalTouches = Bal.getAantalBalTouches();
    }

    @Override
    public void onCollision(Collider collidingObject) {
        if (aantalBalTouches % 5 == 0) {
            Random rand = new Random();
            powerUpRandom = rand.nextInt(0,4);
            if (powerUpRandom == 0) {
                BalToevoegen powerUp =
                        new BalToevoegen("sprites/powerUps-rood.png",
                                new Coordinate2D(getWidth()/2 - (30/2), getHeight()/2 - (30/2)),
                                        new Size(30,30));
            } else if (powerUpRandom == 1) {

            } else if (powerUpRandom == 2) {

            } else if (powerUpRandom == 3) {


            }
        }
    }

    public abstract void doPowerUp();
}
