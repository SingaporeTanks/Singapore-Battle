package singaporegame;

/**
 * Created by EViyachev on 6.4.2016 г..
 */

import java.awt.image.BufferedImage;

public class PlayerTank extends Tanks {

    //public final static long DELAY = 10L;
    //public final static int LOOK_LEFT = 0;
    //public final static int LOOK_RIGHT = 1;
    public final static int LOOK_UP = 2;
    //public final static int LOOK_DOWN = 3;

    private BufferedImage itank;
    //private BufferedImage ishot;
    //private bullet         shots;

    private long delay_mt;
    private int key_ctrl;
    private double angle;
    private int offset;
    private int speedX, speedY;
    private int look;
    private int life;
    //private Clip sfire, stank;

    public PlayerTank(int x, int y) {
        super(x, y);
        itank = null;
        //ishot = null;
        delay_mt = 0L;
        key_ctrl = 0;
        angle = 0.0d;
        offset = 0;
        speedX = speedY = 0;
        look = PlayerTank.LOOK_UP;
        life = 10;
        //sfire    = null;
        //stank    = null;
        //shots    = new bullet();
        this.Create();
    }

    public boolean Create() {
        try {
            //why can't find it?
            itank = ToClip32Bits(this.getClass().getResource("../res/tank.jpg"));

            //this works if jpg is in src:
            //itank = ToClip32Bits(this.getClass().getResource("tank.jpg"));

            //ishot = ToClip32Bits(this.getClass().getResource("res/shot.jpg"));

            //sfire  = xUtil.LoadSound(this.getClass().getResource("res/fire.wav"));
            //stank  = xUtil.LoadSound(this.getClass().getResource("res/tank.wav"));

            offset = itank.getWidth() / 2;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static BufferedImage ToClip32Bits(java.net.URL url) {
        BufferedImage simg, dimg;
        try {
            simg = javax.imageio.ImageIO.read(url);
            dimg = new BufferedImage(simg.getWidth(), simg.getHeight(), BufferedImage.TYPE_INT_ARGB);
        } catch (Exception e) {
            e.printStackTrace();
            simg = dimg = null;
            return null;
        }
        int rgb, color = simg.getRGB(0, 0);
        for (int y = 0; y < simg.getHeight(); ++y) {
            for (int x = 0; x < simg.getWidth(); ++x) {
                if ((rgb = simg.getRGB(x, y)) != color)
                    dimg.setRGB(x, y, 0xFF000000 | rgb);
                else
                    dimg.setRGB(x, y, 0);
            }
        }
        simg = null;
        return dimg;
    }


    public static BufferedImage ToClip32Bits(java.net.URL url, int color_key) {
        BufferedImage simg, dimg;
        try {
            simg = javax.imageio.ImageIO.read(url);
            dimg = new BufferedImage(simg.getWidth(), simg.getHeight(), BufferedImage.TYPE_INT_ARGB);
        } catch (Exception e) {
            e.printStackTrace();
            simg = dimg = null;
            return null;
        }
        int rgb;
        for (int y = 0; y < simg.getHeight(); ++y) {
            for (int x = 0; x < simg.getWidth(); ++x) {
                if ((rgb = simg.getRGB(x, y)) != color_key)
                    dimg.setRGB(x, y, 0xFF000000 | rgb);
                else
                    dimg.setRGB(x, y, 0);
            }
        }
        simg = null;
        return dimg;
    }

    //    public void Init(int px, int py) {
//        x = px;
//        y = py;
//        life = 10;
//        delay_mt = 0L;
//        key_ctrl = 0;
//        angle = 0.0d;
//        speedX = speedY = 0;
//        look = PlayerTank.LOOK_UP;
//        shots.reset();
//        this.Stop();
//    }
//
//    public void Stop(){
//        sfire.stop();
//        stank.stop();
//    }
    public int getSize() {
        return itank.getWidth();
    }

    public int getLife() {
        return life;
    }

    public int decLife() {
        return --life;
    }

    //public bullet getBullets(){ return shots; }
}