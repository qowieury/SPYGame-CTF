
import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.*;
import org.newdawn.slick.geom.Transform;
import org.newdawn.slick.state.*;
import org.jbox2d.common.*;
import org.jbox2d.dynamics.*;
import org.jbox2d.collision.*;

public class Player {

    private Image player;
    private String objID;
    private float x,y;
    private Shape shape;



    public Player() throws SlickException {
        player = new Image("img/rect.bmp");
        objID = new String("player");
        




    }
    public void playerPhysic(Vec2 vec,World world){
        world.
    }

    public void transfromXY(float x,float y){
        this.x += x;
        this.y += y;

    }

    public Image getImg(){
        return player;
    }




    public float getX(){
        return x;
    }
    public float getY(){
        return y;
    }
}