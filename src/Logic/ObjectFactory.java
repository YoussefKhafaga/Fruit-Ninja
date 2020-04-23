package Logic;

public class ObjectFactory {
    public GameObject createObject(int num) {
        GameObject object;
        if (num == 0) {
            object = new Fruit("watermelon.png", "watermelonSliced.png");
        }else if (num == 1) {
            object = new Fruit("strawberry.png", "strawberrySliced.png");
        }else if (num == 2) {
                object = new Fruit("Banana.png","bananaSliced1.png");
        } else if (num == 3) {
            object = new DangerousBomb("dangerousbomb.png","boom.png");
        } else if (num == 4) {
            object = new FatalBomb("fatalbomb.png","boom.png");
        } else if (num == 5) {
            object = new SpecialFruit1("Banana.png","bananaSliced1.png");
        } else if (num == 6) {
            object = new SpecialFruit2("watermelon.png","watermelonSliced.png");
        } else {
            object = null;
        }
        return object;
    }



}
