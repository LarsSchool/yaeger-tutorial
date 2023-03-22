package ping;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;

import ping.scenes.GameScherm;
import ping.scenes.TitelScherm;

public class Ping extends YaegerGame{

	public Ping() {
		
	}
	
	public static void main(String[] args){
	    launch(args);
	}

	@Override
	public void setupGame() {
	    setGameTitle("Ping");
	    setSize(new Size(700, 600));
	}


	@Override
	public void setupScenes(){
	    addScene(0, new TitelScherm(this));
	    addScene(0, new GameScherm(this));
	}
	
	public void setScene(int scene) {
		setActiveScene(scene);
	}
}