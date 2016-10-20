import org.newdawn.slick.*;


public class GamePhysics {



    public GamePhysics(){

    }


    public float gravity(float y,int delta){
        return y+(0.4f*delta);

    }

}
