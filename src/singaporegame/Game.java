package singaporegame;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;

public class Game extends Canvas implements Runnable {
    public static final int WIDTH=800, HEIGHT=600;
    private Thread thread;
    boolean running=false;
    private BufferedImage singaporebkg=null;

    public Game(){

        new Window(WIDTH, HEIGHT,"Singapore Battle", this);
    }
    public synchronized void start(){
        thread=new Thread(this);
        thread.start();
        running=true;

    }
    public void run() {

        this.requestFocus();
        long lastTIme=System.nanoTime();
        double amountOfTicks=60;
        double ns=1000000000/amountOfTicks;
        double delta=0;
        long timer=System.currentTimeMillis();
        int frames=0;
        while(running){
            long now=System.nanoTime();
            delta+=(now-lastTIme)/ns;
            lastTIme=now;
            while(delta>=1) {
                refresh();
                delta--;
            }
            if(running)
                render();
            frames++;
            if(System.currentTimeMillis()-timer>1000){
                timer+=1000;
                // System.out.println("FPS:"+frames);
                frames=0;
            }
        }
        stop();


    }

    private void refresh(){

    }
    private void render(){
        BufferStrategy bs=this.getBufferStrategy();
        if(bs==null){
            this.createBufferStrategy(3);
            return;
        }
        Graphics g=bs.getDrawGraphics();
        g.setColor(Color.black);
        g.fillRect(0,0,WIDTH,HEIGHT);

        g.dispose();
        bs.show();

    }

    public void stop(){
        try{
            thread.join();
            running=false;
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
	new Game();


    }



}
