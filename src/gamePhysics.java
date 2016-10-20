import org.newdawn.slick.*;


public class gamePhysics {



    public gamePhysics(){

    }


    public float gravity(float y,int delta){
        return y+(0.3f * delta);

    }

}
