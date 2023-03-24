package ping.entities.scorebord;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class puntenText extends TextEntity {

    public puntenText(Coordinate2D initialPosition) {
        super(initialPosition);

        setFont(Font.font("Roboto", FontWeight.BOLD, 50));
        setFill(Color.GOLD);
    }

    public void setPuntenText(final String punten) {
        setText(punten);
    }
}
