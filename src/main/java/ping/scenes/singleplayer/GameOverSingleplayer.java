package ping.scenes.singleplayer;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.StaticScene;

import ping.Ping;
import ping.entities.buttons.ExitButton;
import ping.entities.buttons.MultiplayerButton;
import ping.entities.buttons.PlayAgainButton;

public class GameOverSingleplayer extends StaticScene{
	Ping ping;
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
	}
	
	

}
