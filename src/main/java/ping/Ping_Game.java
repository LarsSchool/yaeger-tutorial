package ping;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;

public class Ping_Game extends YaegerGame{

	public Ping_Game() {
		// TODO Auto-generated constructor stub
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
}