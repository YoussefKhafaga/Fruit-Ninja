package sample;

import java.util.Random;

public class FatalBomb extends IsSliced implements GameObject{
    Random random = new Random();
    public FatalBomb() {
    }
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
        return "bomb";
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
