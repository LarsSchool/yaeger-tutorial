package ping.scenes.multiplayer;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.scenes.DynamicScene;

import ping.Ping;
import ping.entities.Bal;
import ping.entities.Border;
import ping.entities.Middenlijn;
import ping.entities.powerups.PowerUp;
import ping.entities.powerups.PowerUpSpawner;
import ping.entities.speler.Speler;
import ping.entities.speler.Speler1;
import ping.entities.speler.Speler2;
import java.util.ArrayList;

public class GameSchermMultiplayer extends DynamicScene implements EntitySpawnerContainer {
	
	Ping ping;

	public GameSchermMultiplayer(Ping ping) {
		// TODO Auto-generated constructor stub
		this.ping = ping;
	}

	@Override
	public void setupScene() {
		// TODO Auto-generated method stub
//		setBackgroundAudio("audio/waterworld.mp3");
		setBackgroundImage("backgrounds/background_ping.png");
	}

	@Override
	public void setupEntities() {
		Bal bal = new Bal("sprites/bal.png", new Coordinate2D(getWidth()/2 - (30/2), getHeight()/2 - (30/2)), new Size(30,30));
		addEntity(bal);

		Middenlijn middenlijn = new Middenlijn(
				new Coordinate2D(getWidth() / 2 - 20 - (bal.getAantalBalTouches() * 4) / 2, 0),
				new Size(40 + bal.getAantalBalTouches() * 4, getHeight()));
		addEntity(middenlijn);

		// SPELERS
		Speler speler1 = new Speler1(new Coordinate2D(getWidth() / 20 - 30, getHeight() / 2 - 70),
				new Size(40, 150));
		addEntity(speler1);

		Speler speler2 = new Speler2(new Coordinate2D(getWidth() - getWidth() / 20 - 10, getHeight() / 2 - 70),
				new Size(40, 150));
		addEntity(speler2);

		// ALLE BORDERS TOEVOEGEN
		Border borderLinksBoven = new Border("sprites/border.png", new Coordinate2D(0, 0),
				new Size(getWidth() / 2, 20));
		addEntity(borderLinksBoven);

		Border borderRechtsBoven = new Border("sprites/border.png", new Coordinate2D(getWidth() / 2, 0),
				new Size(getWidth() / 2, 20));
		addEntity(borderRechtsBoven);

		Border borderLinksOnder = new Border("sprites/border.png", new Coordinate2D(0, getHeight() - 20),
				new Size(getWidth() / 2, 20));
		addEntity(borderLinksOnder);

		Border borderRechtsOnder = new Border("sprites/border.png", new Coordinate2D(getWidth() / 2, getHeight() - 20),
				new Size(getWidth() / 2, 20));
		addEntity(borderRechtsOnder);


	}

	@Override
	public void setupEntitySpawners() {
		PowerUpSpawner powerupSpawner = new PowerUpSpawner(500, getWidth(), getHeight());
		addEntitySpawner(powerupSpawner);
	}

}
