package ping.entities.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import com.github.hanyaeger.tutorial.Waterworld;

import javafx.scene.Cursor;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class ExitButton extends TextEntity implements MouseButtonPressedListener, MouseEnterListener, MouseExitListener{
	
	private Waterworld waterworld;

	public ExitButton(Coordinate2D initialLocation, Waterworld waterworld){
	    super(initialLocation,"Exit Game");
	    this.waterworld = waterworld;
	    setFill(Color.RED);
	    setFont(Font.font("Roboto", FontWeight.BOLD, 30));
	}

	@Override
	public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2D){
		waterworld.quit();
	}

	@Override
	public void onMouseEntered(){
	    setFill(Color.ORANGE);
	    setCursor(Cursor.HAND);
	}

	@Override
	public void onMouseExited(){
	    setFill(Color.RED);
	    setCursor(Cursor.DEFAULT);
	}
}

