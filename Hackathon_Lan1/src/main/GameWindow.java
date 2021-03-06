package main;

import fish.FishEnemyBig;
import fish.FishEnemyObject;
import fish.FishEnemySmall;
import singleton.FishEnemyManager;
import singleton.PlayerManager;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

/**
 * Created by VinhNguyenDinh on 03/13/2016.
 */
public class GameWindow extends Frame implements Runnable {
    Graphics seconds;
    Image image;
    BufferedImage background;
    Vector<FishEnemyObject> vectorFish;

    FishEnemyBig f1;

    public GameWindow() {

        //vectorFish = FishEnemyManager.getInstance().getVectorFish1();
        //init();
        f1 = new FishEnemyBig(200,150,3);
        this.setTitle("FEEDING FRENZY");
        this.setSize(800, 600);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocation(250,80);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });
        try {
            background = ImageIO.read(new File("Resources/image 672.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {

            }

            @Override
            public void mouseMoved(MouseEvent e) {
                PlayerManager.getInstance().getPlayer().move(e.getX(),e.getY());
                // Hàm ẩn chuột
                BufferedImage cursorImg = new BufferedImage(PlayerManager.getInstance().getPlayer().getPositionX(), PlayerManager.getInstance().getPlayer().getPositionY(), BufferedImage.TYPE_INT_ARGB);
                Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImg, new Point(0, 0), "blank cursor");
                setCursor(blankCursor);
            }
        });
    }

    @Override
    public void update(Graphics g){
        if(image == null){
            image = createImage(this.getWidth(), this.getHeight());
            seconds= image.getGraphics();
        }
        seconds.setColor(getBackground());
        seconds.fillRect(0,0,getWidth(),getHeight());
        seconds.setColor(getForeground());
        paint(seconds);
        g.drawImage(image,0,0,null);
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(background,0,0,null);
        PlayerManager.getInstance().getPlayer().draw(g);
        PlayerManager.getInstance().getPlayer().update();
        f1.draw(g);
//        for(FishEnemyObject fishEnemyObject : vectorFish){
//            fishEnemyObject.draw(g);
//        }
    }

    @Override
    public void run() {
        while(true) {
            PlayerManager.getInstance().getPlayer().update();
            f1.update();
//            for(FishEnemyObject fishEnemyObject : vectorFish){
//                fishEnemyObject.update();
//            }
            repaint();
            try {
                Thread.sleep(17);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

//    public void init(){
//
//        vectorFish.add(new FishEnemySmall(100,200,4,3));
//        vectorFish.add(new FishEnemySmall(50,150,2,2));
//        vectorFish.add(new FishEnemySmall(200,50,2,1));
//    }
}
