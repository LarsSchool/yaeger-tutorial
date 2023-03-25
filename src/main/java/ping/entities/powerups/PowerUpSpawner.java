package ping.entities.powerups;

import java.util.Random;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.EntitySpawner;

import ping.entities.Bal;

public class PowerUpSpawner extends EntitySpawner {
	Random rand = new Random();
	private static boolean spawnNewBal = false;
	private boolean powerUpGeplaatst = true;
	private double width;
	private double height;

	public PowerUpSpawner(long interval, double width, double height) {
		super(interval);
		this.width = width;
		this.height = height;
	}

	@Override
	public void spawnEntities() {
		if(spawnNewBal) {
			spawn(new Bal("sprites/bal.png", new Coordinate2D(width/2 - (30/2), height/2 - (30/2)), new Size(30,30)));
			spawnNewBal = false;
		} else
		if (Bal.getAantalBalTouches() % 5 == 0 && !powerUpGeplaatst && Bal.getAantalBalTouches() != 0) {
			powerUpGeplaatst = true;
			int random = rand.nextInt(2) + 1;
			int x = rand.nextInt(400) + 400;
			int y = rand.nextInt(234) + 233;
//			spawn(new SnelheidAanpassen("sprites/powerUp-groen.png", new Coordinate2D(x, y), new Size(50, 50)));
//			spawn(new Inverter("sprites/powerUp-blauw.png", new Coordinate2D(x, y), new Size(50,50)));
//			spawn(new GrootteSpeler("sprites/powerUp-paars.png", new Coordinate2D(x, y), new Size(50,50)));
			//TO DO, hij verwijderd de ballen niet altijd even goed
//			spawn(new BalToevoegen("sprites/powerUp-rood.png", new Coordinate2D(x, y), new Size(50, 50)));

//			switch(random) {
//			case 0:
//			spawn(new GrootteSpeler("sprites/powerUp-paars.png", new Coordinate2D(x, y), new Size(50,50)));
//			break;
//			case 1:
//			spawn(new SnelheidAanpassen("sprites/powerUp-groen.png", new Coordinate2D(x, y), new Size(50,50)));
//			break;
//			case 2:
//			spawn(new Inverter("sprites/powerUp-blauw.png", new Coordinate2D(x, y), new Size(50,50)));
//			break;
//			case 3:
//			spawn(new BalToevoegen("sprites/powerUp-rood.png", new Coordinate2D(x, y), new Size(50,50)));
//			break;
//		}

		} else if (Bal.getAantalBalTouches() % 5 == 1) {
			powerUpGeplaatst = false;
		}
	}

	public static void spawnNewBal() {
		spawnNewBal = true;
	}
}
