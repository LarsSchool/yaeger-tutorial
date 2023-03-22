package ping.scenes;

import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import ping.Ping;


public class GameScherm extends DynamicScene implements EntitySpawnerContainer, TileMapContainer {

	Ping ping;

	public GameScherm(Ping ping) {
		// TODO Auto-generated constructor stub
		this.ping = ping;
	}

	@Override
	public void setupScene() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setupEntities() {
		// TODO Auto-generated method stub


	}

	@Override
	public void setupEntitySpawners() {

	}

	@Override
	public void setupTileMaps() {

	}

}
