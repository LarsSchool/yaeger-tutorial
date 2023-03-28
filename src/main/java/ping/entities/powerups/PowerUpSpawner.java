package ping.entities.powerups;

import java.util.Random;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.EntitySpawner;

import ping.Ping;
import ping.entities.Bal;
import ping.entities.Middenlijn;
import ping.entities.scorebord.ScoreTekst;
import ping.entities.speler.Speler1;
import ping.entities.speler.Speler2;

public class PowerUpSpawner extends EntitySpawner {

	// SCOREBORD
	private ScoreTekst puntenSpeler1;
	private ScoreTekst puntenSpeler2;

	// SPELERS
	private Speler1 speler1;
	private Speler2 speler2;

	private Middenlijn middenlijn;

	Random rand = new Random();
	private static boolean spawnNewBal = false;
	private boolean powerUpGeplaatst = true;
	private double width;
	private double height;

	private Ping ping;

	public PowerUpSpawner(Ping ping, long interval, double width, double height, Speler1 speler1, Speler2 speler2,
			ScoreTekst puntenSpeler1, ScoreTekst puntenSpeler2, Middenlijn middenlijn) {
		super(interval);
		this.ping = ping;
		this.width = width;
		this.height = height;
		this.puntenSpeler1 = puntenSpeler1;
		this.puntenSpeler2 = puntenSpeler2;
		this.speler1 = speler1;
		this.speler2 = speler2;
		this.middenlijn = middenlijn;
	}

	@Override
	public void spawnEntities() {
		if (spawnNewBal) {
			spawn(new Bal(ping, "sprites/bal.png", new Coordinate2D(width / 2 - (30 / 2), height / 2 - (30 / 2)),
					new Size(30, 30), speler1, speler2, puntenSpeler1, puntenSpeler2, middenlijn));
			spawnNewBal = false;
		} else if (Bal.getAantalBalTouches() % 5 == 0 && !powerUpGeplaatst && Bal.getAantalBalTouches() != 0) {
			powerUpGeplaatst = true;
			int random = rand.nextInt(4);
			int x = rand.nextInt(400) + 400;
			int y = rand.nextInt(234) + 233;

			switch (random) {
			case 0:
				spawn(new GrootteSpeler("sprites/powerUp-paars.png", new Coordinate2D(x, y), new Size(50,50), speler1, speler2));
				break;
			case 1:
				spawn(new SnelheidAanpassen("sprites/powerUp-groen.png", new Coordinate2D(x, y), new Size(50, 50)));
				break;
			case 2:
				spawn(new Inverter("sprites/powerUp-blauw.png", new Coordinate2D(x, y), new Size(50, 50)));
				break;
			case 3:
				spawn(new BalToevoegen("sprites/powerUp-rood.png", new Coordinate2D(x, y), new Size(50, 50)));
				break;
			}

		} else if (Bal.getAantalBalTouches() % 5 == 1) {
			powerUpGeplaatst = false;
		}
	}

	public static void spawnNewBal() {
		spawnNewBal = true;
	}
}
