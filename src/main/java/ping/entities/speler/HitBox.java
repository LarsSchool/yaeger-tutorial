package ping.entities.speler;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;

public class HitBox extends RectangleEntity implements Collider {

    public HitBox(final Coordinate2D initialPosition) {
        super(initialPosition);
//        setWidth();
//        setHeight(Speler.getHeight());
    }
}