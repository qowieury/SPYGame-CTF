import org.newdawn.slick.*;
import org.newdawn.slick.state.*;


public class Main extends StateBasedGame{

    public static final String GAMENAME = "MyGameName";
    public static final int play = 0;
    public static final int WINDOWWIDTH = 1024;
    public static final int WINDOWHEIGHT = 576;

    public Main(String GAMENAME) throws SlickException {
        super(GAMENAME);
        this.addState(new WorldMap());
        //this.addState(new Play());
    }

    public void initStatesList(GameContainer gc) throws SlickException{
        this.getState(play).init(gc, this);
        this.enterState(play);
    }

    public static void main(String[] args) {
        AppGameContainer appgc;
        try{
            appgc = new AppGameContainer(new Main(GAMENAME));
            appgc.setDisplayMode(WINDOWWIDTH ,WINDOWHEIGHT,false);
            appgc.setTargetFrameRate(600);
            appgc.start();
        }catch(SlickException e){
            e.printStackTrace();
        }
    }
}