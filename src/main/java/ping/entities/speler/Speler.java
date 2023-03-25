package ping.entities.speler;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

import ping.entities.scorebord.PuntenText;

public abstract class  Speler extends DynamicSpriteEntity{
	
	private static Size size;
	PuntenText puntenSpeler;

	public Speler(String resource, Coordinate2D initialLocation, Size size, PuntenText puntenSpeler) {
		super(resource, initialLocation, size);
		this.size = size;
		this.puntenSpeler = puntenSpeler;
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

	public int getPuntenAantal() {
		return 0;
	}
	
	public void setPuntenAantal(int waarde) {
//		puntenAantal = waarde;
		puntenSpeler.setPuntenText("" + waarde);
	}
	

}
