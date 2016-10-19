import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.jbox2d.common.*;
import org.jbox2d.dynamics.*;
import org.jbox2d.testbed.tests.BodyTypes;

public class WorldMap extends BasicGameState {

    private final int ID = 0;
    private Image map;
    private int x,y;
    private Player player;
    private Input input;
    private World world;
    private Vec2 gravity;



    public WorldMap() throws SlickException {



    }

    public void init(GameContainer gc, StateBasedGame sbg)
            throws SlickException {
        gravity = new Vec2(0,-10);
        world = new World(gravity,false);
        player = new Player();
        map = new Image("img/floor.bmp");
        x = 0;
        y = 576 - map.getHeight();




    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
            throws SlickException {
        input = gc.getInput();
        g.drawImage(map,x,y);
        g.drawImage(player.getImg(),player.getX(),player.getY());









    }

    public void update(GameContainer gc, StateBasedGame sbg, int delta)
            throws SlickException {

        if(input.isKeyDown(input.KEY_W)){
            player.transfromXY(0,-1);
        }
        if(input.isKeyDown(input.KEY_S)){
            player.transfromXY(0,1);
        }
        if(input.isKeyDown(input.KEY_A)){
            player.transfromXY(-1,0);
        }
        if(input.isKeyDown(input.KEY_D)){
            player.transfromXY(1,0);
        }



    }

    public int getID() {
        return ID;
    }
}