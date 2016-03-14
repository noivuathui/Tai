package fish;

import graphics.Topic;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

/**
 * Created by noivu on 3/14/2016.
 */
public class FishEnemySmall extends FishEnemyObject {
    private int xVelocity = 5;
    private int yVelocity = 5;
    private static final int RIGHT_WALL = 400;
    private static final int LEFT_WALL = 200;
    private static final int DOWN_WALL = 370;
    private static final int UP_WALL = 50;

    Vector<Image> imageVector;
    private  double elip = 0;
    private int moveType;

    public FishEnemySmall(int positionX, int positionY, int speed, int moveType) {
        super(positionX, positionY, speed);
        this.positionX = positionX;
        this.positionY = positionY;
        this.moveType = moveType;
        imageVector = new Vector<>();
            //duyet anh..
        for(int i = 257; i <= 285; i+=2) {
            String str = String.format("Resources/image %d.png", i);
            try {
                imageVector.add(ImageIO.read(new File(str)));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void move() {
        double d = 0;
        if(moveType == 1) {
            setPositionX(getPositionX()- speed);
            if (this.positionX <= 0) {
                speed = -speed;
            }
            if (this.positionX >= 800) {
                speed = -speed;
            }
        }
        if (moveType == 2) {
            elip++;
            setPositionX(getPositionX() + (int) (15 * Math.sin(elip * 0.09)));
            setPositionY(getPositionY() + (int) (4 * Math.cos(elip * 0.09)));
        }
        if(moveType == 3) {
            setPositionX(getPositionX() + xVelocity);
            setPositionY(getPositionY() + yVelocity);

            if (getPositionX() >= RIGHT_WALL)
            {
                setPositionX( RIGHT_WALL);

                randomDirection();
            }

            if (getPositionY() <= UP_WALL)
            {
                setPositionY(UP_WALL);

                randomDirection();
            }

            if (getPositionX() <= LEFT_WALL)
            {
                setPositionX(LEFT_WALL);

                randomDirection();
            }
            if (getPositionY() >= DOWN_WALL)
            {
                setPositionY( DOWN_WALL);

                randomDirection();
            }
        }
    }
    private void randomDirection()
    {
        double speed2 = 2.0;
        double direction = Math.random() * 2 * Math.PI;
        xVelocity = (int) (speed2 * Math.cos(direction));
        yVelocity = (int) (speed2 * Math.sin(direction));
    }

    public void update(){
        this.move();
    }

    public void draw(Graphics g){
        g.drawImage(sprite,(int) positionX,(int)positionY,null);
    }
}
