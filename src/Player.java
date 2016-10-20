
import org.newdawn.slick.*;
import org.newdawn.slick.geom.*;

public class Player {

    private int gameStateDelta;

    private GamePhysics playerPhysics;
    private Image player;
    private String objID;
    private float x,y;
    private Shape boundingBox;

    private float jumpVelocity;
    private float walkVelocity;
    private boolean isPlayerJump;
    private float walkSpeed;

    private boolean isCollis;



    public Player() throws SlickException {



        playerPhysics = new GamePhysics();
        player = new Image("img/playerLeft.png");
        objID = new String("player");



        boundingBox = new Rectangle(getX()
                                    ,getY()
                                    ,player.getWidth()
                                    ,player.getHeight());

    }


    public void update() {
        //gravity
        if (isCollis == false) {
            this.y = playerPhysics.gravity(this.y, this.gameStateDelta);
        }//end gravity
        //jump
        if (isPlayerJump == true) {
            if (jumpVelocity > 0) {
                this.y -= 1 * gameStateDelta;
                jumpVelocity -= 0.03 * gameStateDelta;
            } else {
                jumpVelocity = 0;
                if (isCollis == true) {
                    isPlayerJump = false;
                    walkSpeed = 0;
                }
            }
        }//end jump

        //walk smooth
        if (walkVelocity != 0) {
            if (walkVelocity < 0) {
                this.x += (0.2 * gameStateDelta) + walkSpeed;
                this.walkVelocity += 0.08 * gameStateDelta;
                if (walkVelocity > 0) {
                    walkVelocity = 0;
                }
            } else {
                this.x -= (0.2 * gameStateDelta) + walkSpeed;
                this.walkVelocity -= 0.08 * gameStateDelta;
                if (walkVelocity < 0) {
                    walkVelocity = 0;
                }

            }

        }
    }

    public  void walk(String side){
        if("right".equals(side)){
            walkVelocity = -10;
        }
        if ("left".equals(side)){
            walkVelocity = 10;
        }

    }

    public void jump(){
        if(isPlayerJump == false){
            isPlayerJump = true;
            jumpVelocity = 10.f;
            walkSpeed = 0.5f;

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