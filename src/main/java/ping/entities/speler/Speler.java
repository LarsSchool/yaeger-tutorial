package ping.entities.speler;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public abstract class  Speler extends DynamicSpriteEntity {
	
	private Size size;

	public Speler(String resource, Coordinate2D initialLocation, Size size) {
		super(resource, initialLocation, size);
		this.size = size;
	}
	
	public void setHeight(double waarde){
		size = new Size(30, waarde);
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

	public abstract int getPuntenAantal();
	
	public abstract void setPuntenAantal(int waarde);

	

}
