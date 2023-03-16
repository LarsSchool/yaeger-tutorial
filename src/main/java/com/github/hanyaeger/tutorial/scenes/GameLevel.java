package com.github.hanyaeger.tutorial.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import com.github.hanyaeger.tutorial.Waterworld;
import com.github.hanyaeger.tutorial.entities.BubbleSpawner;
import com.github.hanyaeger.tutorial.entities.Hanny;
import com.github.hanyaeger.tutorial.entities.map.CoralTileMap;
import com.github.hanyaeger.tutorial.entities.sharky.Sharky;
import com.github.hanyaeger.tutorial.entities.swordfish.Swordfish;
import com.github.hanyaeger.tutorial.entities.text.BubblesPoppedText;
import com.github.hanyaeger.tutorial.entities.text.HealthText;

public class GameLevel extends DynamicScene implements EntitySpawnerContainer, TileMapContainer {

	Waterworld waterworld;

	public GameLevel(Waterworld waterworld) {
		// TODO Auto-generated constructor stub
		this.waterworld = waterworld;
	}

	@Override
	public void setupScene() {
		// TODO Auto-generated method stub
		setBackgroundAudio("audio/waterworld.mp3");
		setBackgroundImage("backgrounds/background2.jpg");
	}

	@Override
	public void setupEntities() {
		// TODO Auto-generated method stub
		HealthText HealthPoints = new HealthText(new Coordinate2D(getWidth() - 150, 10));
		addEntity(HealthPoints);
		var bubblesPoppedText = new BubblesPoppedText(new Coordinate2D(0, 30));
		addEntity(bubblesPoppedText);
		Swordfish zwaardvis = new Swordfish(new Coordinate2D(500, 150));
		addEntity(zwaardvis);
		Hanny hanny = new Hanny(new Coordinate2D(1, 1), HealthPoints, bubblesPoppedText, waterworld);
		addEntity(hanny);
		Sharky sharky = new Sharky(new Coordinate2D(150, 300));
		addEntity(sharky);

	}

	@Override
	public void setupEntitySpawners() {
		BubbleSpawner airSpawner = new BubbleSpawner(getWidth(), getHeight());
		addEntitySpawner(airSpawner);
	}

	@Override
	public void setupTileMaps() {
		addTileMap(new CoralTileMap());
	}

}
