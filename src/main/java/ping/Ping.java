package ping;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;

public class Ping extends YaegerGame{

	public Ping() {
		water
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
	}
	
	public void setScene(int scene) {
		setActiveScene(scene);
	}
}