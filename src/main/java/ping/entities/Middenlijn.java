package ping.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.DynamicRectangleEntity;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;

public class Middenlijn extends DynamicRectangleEntity {
	
	private Point2D locatie;

	public Middenlijn(Coordinate2D initialPosition, Size size) {
		super(initialPosition, size);
		setFill(Color.WHITE);
	}
	
	public void middenlijnExpand(double waarde, double waarde2) {
		this.setWidth(waarde);
		this.setAnchorLocationX(this.getAnchorLocation().getX() - (waarde2/2));

	}
	

}
