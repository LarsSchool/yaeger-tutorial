package ping.scenes.singleplayer;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.scenes.DynamicScene;

import ping.Ping;
import ping.entities.Bal;
import ping.entities.Border;
import ping.entities.Middenlijn;
import ping.entities.speler.Speler1;
import ping.entities.speler.Speler2;

public class GameSchermSingleplayer extends DynamicScene implements EntitySpawnerContainer {

	Ping ping;

	public GameSchermSingleplayer(Ping ping) {
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
		Speler1 speler1 = new Speler1(new Coordinate2D(getWidth() / 20 - 30, getHeight() / 2 - 70), new Size(40, 150));
		addEntity(speler1);
		Speler2 speler2 = new Speler2(new Coordinate2D(getWidth() - getWidth() / 20 - 10, getHeight() / 2 - 70),
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

		// HealthText HealthPoints = new HealthText(new Coordinate2D(getWidth() - 150,
		// 10));
//		addEntity(HealthPoints);
//		var bubblesPoppedText = new BubblesPoppedText(new Coordinate2D(0, 30));
//		addEntity(bubblesPoppedText);
//		Swordfish zwaardvis = new Swordfish(new Coordinate2D(500, 150));
//		addEntity(zwaardvis);
//		Hanny hanny = new Hanny(new Coordinate2D(1, 1), HealthPoints, bubblesPoppedText, waterworld);
//		addEntity(hanny);
//		Sharky sharky = new Sharky(new Coordinate2D(150, 300));
//		addEntity(sharky);

	}

	@Override
	public void setupEntitySpawners() {
//		BubbleSpawner airSpawner = new BubbleSpawner(getWidth(), getHeight());
//		addEntitySpawner(airSpawner);
	}

}
