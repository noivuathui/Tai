package graphics;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Vector;
import main.GameObject;

import javax.imageio.ImageIO;

/**
 * Created by VinhNguyenDinh on 03/13/2016.
 */
public class Animation extends GameObject {
    Vector<Image> imageVector;
    private int delta;
    private int countTime;
    private int index;

    public Animation(int start, int end, int delta) {
        imageVector = new Vector<Image>();
        this.delta = delta;
        this.countTime = 0;
        this.index = 0;
        for(int i = start; i <= end; i+=2) {
            String str = String.format("Resources/image %d.png", i);
            try {
                imageVector.add(ImageIO.read(new File(str)));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Graphics g) {

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
