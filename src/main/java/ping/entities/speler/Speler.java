package ping.entities.speler;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public abstract class  Speler extends DynamicSpriteEntity{

	public Speler(String resource, Coordinate2D initialLocation, Size size) {
		super(resource, initialLocation, size);
		// TODO Auto-generated constructor stub
	}
       
}
