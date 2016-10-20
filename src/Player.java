
import org.newdawn.slick.*;
import org.newdawn.slick.geom.*;

public class Player {

    private int gameStateDelta;

    private gamePhysics playerPhysics;
    private Image player;
    private String objID;
    private float x,y;
    private Shape boundingBox;

    private float jumpVelocity;
    private boolean isPlayerJump;

    private boolean isCollis;



    public Player() throws SlickException {



        playerPhysics = new gamePhysics();
        player = new Image("img/playerLeft.png");
        objID = new String("player");



        boundingBox = new Rectangle(getX()
                                    ,getY()
                                    ,player.getWidth()
                                    ,player.getHeight());

    }


    public void update(){
        //jump
        if(isPlayerJump == true){
            if(jumpVelocity > 0){
                this.y -=4*gameStateDelta ;
                jumpVelocity -= 0.03*gameStateDelta;
            }else{
                jumpVelocity = 0;
                if(isCollis == true){
                    isPlayerJump = false;
                }
            }
        }//end jump

    }

    public void jump(){
        if(isPlayerJump == false){
            isPlayerJump = true;
            jumpVelocity = 1.5f;
        }

    }

    public void setGameStateDelta(int delta){
        this.gameStateDelta = delta;
    }

    public Shape getBoundingBox(){
        return this.boundingBox;

    }

    public boolean isCollision(Shape otherBox){
        if (this.getBoundingBox() == null) {
            return false;
        }
        isCollis = this.getBoundingBox().intersects(otherBox);
        return isCollis;
    }

    public void transfromXY(float x,float y){
        this.x += x;
        this.y += y;
        boundingBox.setLocation(this.x,this.y);

        if(isCollis == false) {
           this.y = playerPhysics.gravity(this.y,this.gameStateDelta);

        }

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