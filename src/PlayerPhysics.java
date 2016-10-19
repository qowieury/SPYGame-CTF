import org.newdawn.slick.*;


public class PlayerPhysics {

    public PlayerPhysics(){

    }

    public float gravity(float y,int delta){
        return y+(0.1f * delta);

    }

}
