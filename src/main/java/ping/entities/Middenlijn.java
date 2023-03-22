package ping.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.DynamicRectangleEntity;

import javafx.scene.paint.Color;
import ping.Ping;

public class Middenlijn extends DynamicRectangleEntity {

	public Middenlijn(Coordinate2D initialPosition, Size size) {
		super(initialPosition, size);
		setFill(Color.WHITE);
	}

}
