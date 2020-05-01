package Logic.GameObjects;

import Logic.GameObjects.*;

public class ObjectFactory {
    public GameObject createObject(int num) {
        GameObject object = null;
        if (num == 0) {
            object = new Fruit("watermelon.png", "watermelonSliced.png","watermelon");
        }else if (num == 1) {
            object = new Fruit("strawberry.png", "strawberrySliced.png","strawberry");
        }else if (num == 2) {
                object = new Fruit("Banana.png","bananaSliced1.png","banana");
        } else if (num == 3) {
            object = new DangerousBomb("dangerousbomb.png","boom.png");
        } else if (num == 4) {
            object = new FatalBomb("fatalbomb.png","boom.png");
        } else if (num == 5) {
            Fruit fruit = new Fruit("specialFruit1.png","freeze.png",null);
            object = new FreezingFruit(fruit);
        } else if (num == 6) {
            Fruit fruit = new Fruit("specialFruit2.png","combo.png",null);
            object = new ComboFruit(fruit);
        }
        return object;
    }

    public GameObject createObject(String type) {
        GameObject object = null;
        if (type.equals("watermelon")) {
           object = createObject(0);
        }else if (type.equals("strawberry")) {
           object =  createObject(1);
        }else if (type.equals("banana")) {
           object =  createObject(2);
        }else if (type.equals("DangerousBomb")) {
           object =  createObject(3);
        }else if (type.equals("FatalBomb")) {
            object = createObject(4);
        }else if (type.equals("FreezingFruit")) {
            object =  createObject(5);
        }else if (type.equals("ComboFruit")) {
           object = createObject(6);
        }return object;

    }



    }
