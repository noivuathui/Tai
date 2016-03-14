package fish;

/**
 * Created by noivu on 3/14/2016.
 */
public class FishEnemyObject extends FishObject {

    public FishEnemyObject(int positionX, int positionY, int speed) {
        super(positionX, positionY, speed);
        this.positionX = positionX;
        this.positionY = positionY;
        this.speed = speed;
    }
}
