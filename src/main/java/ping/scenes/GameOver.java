package ping.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.StaticScene;
import com.github.hanyaeger.tutorial.Waterworld;

import ping.entities.buttons.ExitButton;
import ping.entities.buttons.PlayAgainButton;


public class GameOver extends StaticScene{
	Waterworld waterworld;
	public GameOver(Waterworld waterworld) {
		// TODO Auto-generated constructor stub
		this.waterworld = waterworld;
	}

	@Override
	public void setupScene() {
		// TODO Auto-generated method stub
	    setBackgroundImage("backgrounds/background1.jpg");
	}

	@Override
	public void setupEntities() {
		// TODO Auto-generated method stub
	    PlayAgainButton playAgainButton = new PlayAgainButton(new Coordinate2D(getWidth()/2 - 140 , (getHeight()/2 - 60)), waterworld);
	    addEntity(playAgainButton);
	    ExitButton exitButton = new ExitButton(new Coordinate2D(getWidth()/2 + 50, (getHeight()/2) + 40), waterworld);
	    addEntity(exitButton);
	}
	
	

}
