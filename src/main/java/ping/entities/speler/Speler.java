package ping.entities.speler;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public abstract class  Speler extends DynamicSpriteEntity{
	
	private static Size size;

	public Speler(String resource, Coordinate2D initialLocation, Size size) {
		super(resource, initialLocation, size);
		this.size = size;
	}
	
	public static void setHeight(double waarde) {
		size = new Size(waarde);
	}
	
	public void setWidth(double waarde) {
		size = new Size(getHeight(), waarde);
	}
	
	public double getHeight(){
		return size.height();
	}
	
	public double getWidth(){
		return size.width();
	}
	
	public abstract void setPuntenAantal(int waarde);
	
	public abstract int getPuntenAantal();


}
