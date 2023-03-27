package ping.scenes.multiplayer;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import ping.Ping;
import ping.entities.buttons.ExitButton;
import ping.entities.buttons.PlayAgainButton;
import ping.entities.buttons.SingleplayerButton;
import ping.entities.scorebord.PuntenSpeler1;
import ping.entities.scorebord.PuntenSpeler2;


public class GameOverMultiplayer extends StaticScene{
	
	private Ping ping;
	private static int gewonnenSpeler;
	public GameOverMultiplayer(Ping ping) {
		this.ping = ping;
	}

	@Override
	public void setupScene() {
		setBackgroundImage("backgrounds/eindscherm_ping.png");
	}

	@Override
	public void setupEntities() {
	    var gewonnenText = new TextEntity(
		        new Coordinate2D(getWidth() / 4, getHeight() / 8 + 40),
		        "Speler " + gewonnenSpeler + " heeft gewonnen!"
		    );

		gewonnenText.setFont(Font.font("Roboto", FontWeight.BOLD, 50));
	    gewonnenText.setFill(Color.GOLDENROD);
		
	    PlayAgainButton playAgainButton = new PlayAgainButton(new Coordinate2D(getWidth()/3  , (getHeight()/2 - 20)), ping);
	    ExitButton exitButton = new ExitButton(new Coordinate2D(getWidth()/ 3 + 120, (getHeight()/2) + 150), ping);
		SingleplayerButton singleplayerButton =
				new SingleplayerButton(new Coordinate2D((getWidth()/8 * 3) + 55, (getHeight()/2) + 100), ping);

		addEntity(singleplayerButton);
		addEntity(gewonnenText);
	    addEntity(exitButton);
	    addEntity(playAgainButton);
	}
	
	public static void setGewonnenSpeler(int waarde) {
		gewonnenSpeler = waarde;
	}
	

}
