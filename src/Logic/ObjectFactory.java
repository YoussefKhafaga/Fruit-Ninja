package Logic;

public class ObjectFactory {
    public GameObject createObject(int num) {
        GameObject object = null;
        if (num == 0) {
            object = new Fruit("watermelon.png", "watermelonSliced.png","watermellon");
        }else if (num == 1) {
            object = new Fruit("strawberry.png", "strawberrySliced.png","strawberry");
        }else if (num == 2) {
                object = new Fruit("Banana.png","bananaSliced1.png","banana");
        } else if (num == 3) {
            object = new DangerousBomb("dangerousbomb.png","boom.png");
        } else if (num == 4) {
            object = new FatalBomb("fatalbomb.png","boom.png");
        } else if (num == 5) {
            object = new SpecialFruit1("Banana.png","bananaSliced1.png");
        } else if (num == 6) {
            object = new SpecialFruit2("watermelon.png","watermelonSliced.png");
        }
        return object;
    }

    public GameObject createObject(String type) {
        GameObject object = null;
        if (type.equals("watermelon")) {
           createObject(0);
        }else if (type.equals("strawberry")) {
            createObject(1);
        }else if (type.equals("banana")) {
            createObject(2);
        }else if (type.equals("DangerousBomb")) {
            createObject(3);
        }else if (type.equals("FatalBomb")) {
            createObject(4);
        }else if (type.equals("SpecialFruit1")) {
            createObject(5);
        }else if (type.equals("SpecialFruit2")) {
            createObject(6);
        }return object;

    }



    }
