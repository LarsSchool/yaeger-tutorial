package ping.entities.speler;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class Speler extends DynamicSpriteEntity {

    protected Speler(String resource, Coordinate2D initialLocation) {
        super(resource, initialLocation);
    }
}
