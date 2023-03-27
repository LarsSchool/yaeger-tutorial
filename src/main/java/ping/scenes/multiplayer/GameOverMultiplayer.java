package ping.scenes.multiplayer;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;

import javafx.scene.paint.Color;
import ping.Ping;
import ping.entities.buttons.ExitButton;
import ping.entities.buttons.PlayAgainButton;


public class GameOverMultiplayer extends StaticScene{
	
	private Ping ping;
	private static int gewonnenSpeler;
	public GameOverMultiplayer(Ping ping) {
		this.ping = ping;
	}

	@Override
	public void setupScene() {

	}

	@Override
	public void setupEntities() {
	    var gewonnenText = new TextEntity(
		        new Coordinate2D(getWidth() / 2, getHeight() / 8),
		        "Speler " + gewonnenSpeler + " heeft gewonnen!"
		    );
	    
	    gewonnenText.setFill(Color.GOLDENROD);
//	    gewonnenText.setFont();
		
	    PlayAgainButton playAgainButton = new PlayAgainButton(new Coordinate2D(getWidth()/2 - 140 , (getHeight()/2 - 60)), ping);
	    ExitButton exitButton = new ExitButton(new Coordinate2D(getWidth()/2 + 50, (getHeight()/2) + 40), ping);
	    
	    addEntity(gewonnenText);
	    addEntity(exitButton);
	    addEntity(playAgainButton);

	}
	
	public static void setGewonnenSpeler(int waarde) {
		gewonnenSpeler = waarde;
	}
	

}
