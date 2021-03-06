import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.state.*;
import org.jbox2d.common.*;
import org.jbox2d.dynamics.*;
import org.jbox2d.testbed.tests.BodyTypes;

public class WorldMap extends BasicGameState {

    private final int ID = 0;
    private Image map;

    private float x,y;
    private float vX,vY;


    private Player player;
    private Input input;


    private Shape boundingBox;



    public WorldMap() throws SlickException {



    }

    public void init(GameContainer gc, StateBasedGame sbg)
            throws SlickException {
        player = new Player();
        map = new Image("img/floor.bmp");
        x = 0;
        y = 576 - map.getHeight();

        boundingBox = new Rectangle(x,y,map.getWidth(),map.getHeight());





    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
            throws SlickException {

        input = gc.getInput();
        g.drawImage(map,x,y);
        g.drawImage(player.getImg(),player.getX(),player.getY());

        g.draw(boundingBox);
        g.draw(player.getBoundingBox());







    }

    public void update(GameContainer gc, StateBasedGame sbg, int delta)
            throws SlickException {
        player.transfromXY(0,0);
        player.setGameStateDelta(delta);
        inputChecker(input);
        player.isCollision(boundingBox);
        player.update();







    }
    public void inputChecker(Input input){
        if(input.isKeyPressed(input.KEY_W)){
            player.jump();
        }

        if(input.isKeyDown(input.KEY_S)){
            //player.transfromXY(0,1);
        }
        if(input.isKeyDown(input.KEY_A)){
            //player.transfromXY(-1,0);
            player.walk("left");
        }
        if(input.isKeyDown(input.KEY_D)){
            //player.transfromXY(1,0);
            player.walk("right");
        }
    }

    public int getID() {
        return ID;
    }
}