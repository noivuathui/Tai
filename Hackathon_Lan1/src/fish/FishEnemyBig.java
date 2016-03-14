package fish;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

/**
 * Created by noivu on 3/14/2016.
 */
public class FishEnemyBig extends FishEnemyObject {
    Vector<Image> imageVector;
    private int countTime;
    private int index;
    private int delta;

    public FishEnemyBig(int positionX, int positionY, int speed) {
        super(positionX, positionY, speed);
        this.positionX = positionX;
        this.positionY = positionY;
        this.speed = speed;
        imageVector = new Vector<>();
        for(int i = 557; i <= 577; i+=2) {
            String str = String.format("Resources/image %d.png", i);
            try {
                imageVector.add(ImageIO.read(new File(str)));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void move() {
       // double d = 0;
            setPositionX(getPositionX() - speed);
            if (this.positionX <= 0) {
                speed = -speed;
            }
            if (this.positionX >= 800) {
                speed = -speed;
            }
    }

    public void update(){
        this.move();
    }

    public void draw(Graphics g, int x, int y){
        g.drawImage(imageVector.get(index), x, y, null);
        countTime += 17;
        if (countTime >= delta) {
            countTime = 0;
            index++;
            if (index >= imageVector.size()) {
                index = 0;
            }
        }
    }
}
