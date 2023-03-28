package ping.scenes.singleplayer;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.StaticScene;

import ping.Ping;
import ping.entities.buttons.ExitButton;
import ping.entities.buttons.MultiplayerButton;
import ping.entities.buttons.PlayAgainButton;
import ping.entities.scorebord.ScoreTekst;
import ping.entities.speler.Speler1;


public class GameOverSingleplayer extends StaticScene{
	Ping ping;
	
	private ScoreTekst puntenSpeler1;
	
	public GameOverSingleplayer(Ping ping) {
		this.ping = ping;
	}

	@Override
	public void setupScene() {
		setBackgroundImage("backgrounds/eindscherm_ping.png");
	}

	@Override
	public void setupEntities() {
	    PlayAgainButton playAgainButton =
				new PlayAgainButton(new Coordinate2D(getWidth()/3  , (getHeight()/2 - 20)), ping);
	    	addEntity(playAgainButton);
	    ExitButton exitButton = new ExitButton(new Coordinate2D(getWidth()/ 3 + 120, (getHeight()/2) + 150), ping);
	    	addEntity(exitButton);
		MultiplayerButton multiplayerButton =
				new MultiplayerButton(new Coordinate2D((getWidth()/8 * 3) + 55, (getHeight()/2) + 100), ping);
			addEntity(multiplayerButton);
			
			puntenSpeler1 = new ScoreTekst(new Coordinate2D(getWidth()/2-22, getHeight()/4));
			addEntity(puntenSpeler1);
			
			
			
			puntenSpeler1.setPuntenText(Speler1.getPuntenAantal());
			
			
			//Deze getter werkt niet omdat er dan gekloot wordt met static. Vandaar de erg lelijke en onveilige public puntenAantal.
//			puntenSpeler1.setPuntenText(Speler1.getPuntenAantal());

	}
	
	

	
	

}
