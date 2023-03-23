package ping.entities.speler;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public abstract class  Speler extends DynamicSpriteEntity{
	
	private Size size;

	public Speler(String resource, Coordinate2D initialLocation, Size size) {
		super(resource, initialLocation, size);
		this.size = size;
	}
	
	public double getHeight(){
		return size.height();
	}
	
	public double getWidth(){
		return size.width();
	}
}
