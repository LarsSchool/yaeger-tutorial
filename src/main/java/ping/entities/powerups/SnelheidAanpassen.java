package ping.entities.powerups;



import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;

import ping.entities.Bal;


public class SnelheidAanpassen extends PowerUp {

    public SnelheidAanpassen(String resource, Coordinate2D initialLocation, Size size) {
        super(resource, initialLocation, size);
		setMotionPowerUp();
    }

    public void doPowerUp(){
        int nieuweSnelheid = getRandom(5) + 2;
        while(nieuweSnelheid > 7 || nieuweSnelheid < 2 || Bal.getBalSnelheid() == nieuweSnelheid){
            nieuweSnelheid = getRandom(5) + 2;
        }
        Bal.setBalSnelheid(nieuweSnelheid);
    	remove();
    }

	@Override
	public void setMotionPowerUp() {
		int random = getRandom(2);
		if (random == 0) {
			setMotion(1, 90d);
		} else {
			setMotion(1, 270d);
		}
	}
}
