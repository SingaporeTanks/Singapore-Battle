package singaporegame;

/**
 * Created by Dobromir on 4/5/2016.
 */
public  abstract class Tanks {

    protected int x,y;
// coordinates
    protected int velX, velY;
  //speeed

public Tanks(int x, int y){
    this.x=x;
    this.y=y;

}
    public void setX(int x){
        this.x=x;
    }
    public void setY(int y){

        this.y=y;
    }
    public int getX(){
        return x;

    }
    public int getY(){
        return y;
    }


    public  void setVelX(int velX){

        this.velX=velX;
    }
    public  void setVelY(int velY){

        this.velY=velY;
    }
    public int getVelX() {
        return velX;
    }
    public int getVelY() {
        return velY;
    }
}


