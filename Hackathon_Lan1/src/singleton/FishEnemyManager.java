package singleton;

import fish.FishEnemyObject;

import java.util.Vector;

/**
 * Created by noivu on 3/14/2016.
 */
public class FishEnemyManager {
    private Vector<FishEnemyObject> vectorFish1;
    private static FishEnemyManager ourInstance = new FishEnemyManager();

    public static FishEnemyManager getInstance() {
        return ourInstance;
    }

    public FishEnemyManager() {
        vectorFish1 = new Vector<FishEnemyObject>();
    }

    public Vector<FishEnemyObject> getVectorFish1() {
        return vectorFish1;
    }

    public void setVectorFish1(Vector<FishEnemyObject> vectorFish1) {
        this.vectorFish1 = vectorFish1;
    }

    public static void setOurInstance(FishEnemyManager ourInstance) {
        FishEnemyManager.ourInstance = ourInstance;
    }
}
