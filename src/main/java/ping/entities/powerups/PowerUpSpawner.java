package ping.entities.powerups;

import java.util.Random;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.EntitySpawner;

import ping.entities.Bal;

public class PowerUpSpawner extends EntitySpawner {
	
	private double width;
	private double height;

	public PowerUpSpawner(long interval, double width, double height) {
		super(interval);
		this.width = width;
		this.height = height;
	}

	@Override
	public void spawnEntities() {
		System.out.println(Bal.getAantalBalTouches());
		if(Bal.getAantalBalTouches() % 5 == 0) {
			Random rand = new Random();
			int random = rand.nextInt(1);

			
			switch(random) {
			case 0:
			spawn(new GrootteSpeler("powerUp-paars.png", new Coordinate2D(width/2-15, height/2 - 15), new Size(50,50)));
			break;
//			case 1:
//			spawn(new SnelheidAanpassen(null, new Coordinate2D(getWidth()/2 - (30/2), getHeight()/2 - (30/2)), new Size(30,30));
//			break;
//			case 2:
//			spawn(new Inverter(null, new Coordinate2D(getWidth()/2 - (30/2), getHeight()/2 - (30/2)), new Size(30,30));
//			break;
//			case 3:
//			spawn(new BalToevoegen(null, new Coordinate2D(getWidth()/2 - (30/2), getHeight()/2 - (30/2)), new Size(30,30));
//			break;
		}
	  }
	}

}
