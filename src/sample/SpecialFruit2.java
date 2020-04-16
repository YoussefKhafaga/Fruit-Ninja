package sample;

import java.util.Random;

public class SpecialFruit2 extends IsSliced implements GameObject{
    Random random = new Random();
    public SpecialFruit2() {
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
