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
import ping.entities.scorebord.puntenText;
import ping.entities.speler.Speler;
import ping.entities.speler.Speler1;
import ping.entities.speler.Speler2;
import java.util.ArrayList;

public class GameSchermMultiplayer extends DynamicScene implements EntitySpawnerContainer {
	
	Ping ping;

	public GameSchermMultiplayer(Ping ping) {
		this.ping = ping;
	}

	@Override
	public void setupScene() {
		setBackgroundImage("backgrounds/background_ping.png");
	}

	@Override
	public void setupEntities() {
		Bal bal = new Bal("sprites/bal.png", new Coordinate2D(getWidth()/2 - (30/2), getHeight()/2 - (30/2)), new Size(30,30));
		addEntity(bal);
		
		//TO DO aanpassen dat deze steeds breder wordt als er meer baltouches komen
		Middenlijn middenlijn = new Middenlijn(
				new Coordinate2D(getWidth() / 2 - 20 - (bal.getAantalBalTouches() * 4) / 2, 0),
				new Size(40 + bal.getAantalBalTouches() * 4, getHeight()));
		addEntity(middenlijn);

		// SPELERS
		Speler speler1 = new Speler1(new Coordinate2D(getWidth() / 20 - 30, getHeight() / 2 - 70),
				new Size(30, 130));
		addEntity(speler1);

		Speler speler2 = new Speler2(new Coordinate2D(getWidth() - getWidth() / 20 - 10, getHeight() / 2 - 70),
				new Size(30, 130));
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
		
		puntenText puntenSpeler1 = new puntenText(new Coordinate2D(getWidth()/4, getHeight()/8));
		puntenSpeler1.setPuntenText("" + speler1.getPuntenAantal());
		addEntity(puntenSpeler1);
		
		puntenText puntenSpeler2 = new puntenText(new Coordinate2D(getWidth()/4 * 3, getHeight()/8));
		puntenSpeler2.setPuntenText("" + speler2.getPuntenAantal());
		addEntity(puntenSpeler2);


	}

	@Override
	public void setupEntitySpawners() {
		PowerUpSpawner powerupSpawner = new PowerUpSpawner(500, this.getWidth(), this.getHeight());
		addEntitySpawner(powerupSpawner);
	}

}
