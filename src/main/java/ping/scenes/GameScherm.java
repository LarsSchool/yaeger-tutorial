package ping.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.scenes.DynamicScene;

import ping.Ping;
import ping.entities.Bal;
import ping.entities.Border;
import ping.entities.Middenlijn;

public class GameScherm extends DynamicScene implements EntitySpawnerContainer {

	Ping ping;

	public GameScherm(Ping ping) {
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
		Bal bal = new Bal();
		Middenlijn middenlijn = new Middenlijn(new Coordinate2D(getWidth() / 2 - 20 - (bal.getAantalBalTouches() * 4)/2, 0),
				new Size(40 + bal.getAantalBalTouches() * 4, getHeight()));
		addEntity(middenlijn);
		Border borderBoven = new Border("sprites/border_dirt.png", new Coordinate2D(0, 0),
				new Size(getWidth(), 20));
		addEntity(borderBoven);

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
