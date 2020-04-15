package sample;

import java.util.Random;

public class Fruit implements GameObject{
    public Random random = new Random();
    @Override
    public int getXLocation() {
        return random.nextInt(100);
    }

    @Override
    public int getYlocation() {
        return random.nextInt(100);
    }

    @Override
    public String getType() {
        return "fruit";
    }

    @Override
    public int getInitialVelocity() {
        return random.nextInt(80);
    }

    @Override
    public int getFallingVelocity() {
        return random.nextInt(100);
    }
}
