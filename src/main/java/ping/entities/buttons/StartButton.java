package ping.entities.buttons;

import java.util.Optional;

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
import ping.Ping;

public class StartButton extends TextEntity implements MouseButtonPressedListener, MouseEnterListener, MouseExitListener{
		
	private Ping ping;

	public StartButton(Coordinate2D initialLocation, Ping ping){
	    super(initialLocation,"Play Ping (definitely not Pong)");
	    this.ping = ping;
	    setFill(Color.PURPLE);
	    setFont(Font.font("Roboto", FontWeight.BOLD, 30));
	}

	@Override
	public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2D){
	    ping.setActiveScene(1);
	}

	@Override
	public void onMouseEntered(){
	    setFill(Color.VIOLET);
	    setCursor(Cursor.HAND);
	}

	@Override
	public void onMouseExited(){
	    setFill(Color.PURPLE);
	    setCursor(Cursor.DEFAULT);
	}


}
