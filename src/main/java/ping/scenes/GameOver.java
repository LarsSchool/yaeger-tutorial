package ping.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.StaticScene;

import ping.Ping;
import ping.entities.buttons.ExitButton;
import ping.entities.buttons.PlayAgainButton;


public class GameOver extends StaticScene{
	Ping ping;
	public GameOver(Ping ping) {
		// TODO Auto-generated constructor stub
		this.ping = ping;
	}

	@Override
	public void setupScene() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setupEntities() {
	    PlayAgainButton playAgainButton = new PlayAgainButton(new Coordinate2D(getWidth()/2 - 140 , (getHeight()/2 - 60)), ping);
	    addEntity(playAgainButton);
	    ExitButton exitButton = new ExitButton(new Coordinate2D(getWidth()/2 + 50, (getHeight()/2) + 40), ping);
	    addEntity(exitButton);
	}
	
	

}
