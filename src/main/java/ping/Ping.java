package ping;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;

import ping.scenes.TitleScene;

public class Ping extends YaegerGame{

	public Ping() {
		
	}
	
	public static void main(String[] args){
	    launch(args);
	}

	@Override
	public void setupGame() {
	    setGameTitle("Ping");
	    setSize(new Size(900, 750));
	}


	@Override
	public void setupScenes(){
	    addScene(0, new TitleScene(this));
	}
	
	public void setScene(int scene) {
		setActiveScene(scene);
	}
}