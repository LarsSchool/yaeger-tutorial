package ping.entities.speler;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.DynamicRectangleEntity;

public abstract class  SpelerRechthoek extends DynamicRectangleEntity {
	
//	private Size size;

	public SpelerRechthoek(Coordinate2D initialLocation, Size size) {
		super(initialLocation, size);
//		this.size = size;
	}
//	
//	public double getHeight(){
//		return size.height();
//	}
//	
//	public double getWidth(){
//		return size.width();
//	}
//
//	
//	public abstract void setPuntenAantal(int waarde);

}
