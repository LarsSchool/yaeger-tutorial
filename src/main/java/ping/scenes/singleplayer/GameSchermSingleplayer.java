package ping.scenes.singleplayer;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.scenes.DynamicScene;

import ping.Ping;
import ping.entities.Bal;
import ping.entities.Border;
import ping.entities.SingleplayerMuur;
import ping.entities.scorebord.PuntenSpeler1;
import ping.entities.scorebord.PuntenSpeler2;
import ping.entities.speler.Speler;
import ping.entities.speler.Speler1;

public class GameSchermSingleplayer extends DynamicScene implements EntitySpawnerContainer {

	Ping ping;

	public GameSchermSingleplayer(Ping ping) {
		this.ping = ping;
	}

	@Override
	public void setupScene() {
		setBackgroundImage("backgrounds/background_ping.png");
	}

	@Override
	public void setupEntities() {

		// muur
		SingleplayerMuur muur = new SingleplayerMuur(
				new Coordinate2D(0, 0),
				new Size(40, getHeight()));
		addEntity(muur);
		
		//SCOREBORD
		//MET HERMAN NAAR DE PUNTEN KIJKEN, GEEN IDEE HOE DIT PRECIES WERKT, florian heeft even gekeken--------------------------------------------------------------------------------------------
		PuntenSpeler1 puntenSpeler1 = new PuntenSpeler1(new Coordinate2D(getWidth()/2, getHeight()/8));
		addEntity(puntenSpeler1);

		// spelers
		Speler speler1 = new Speler1(new Coordinate2D(getWidth() - getWidth() / 20 - 10, getHeight() / 2 - 70),
				new Size(40, 150), puntenSpeler1);
		addEntity(speler1);
		
		puntenSpeler1.setPuntenText(speler1.getPuntenAantal());
		
		// bal
		Bal bal = new Bal(ping, "sprites/bal.png", new Coordinate2D(getWidth()/2 - (30/2), getHeight()/2 - (30/2)), new Size(30,30), speler1, puntenSpeler1);
		addEntity(bal);

		// borders
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

	}

}
