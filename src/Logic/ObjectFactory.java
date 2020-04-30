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
           createObject(0);
        }else if (type.equals("strawberry")) {
            createObject(1);
        }else if (type.equals("banana")) {
            createObject(2);
        }else if (type.equals("DangerousBomb")) {
            createObject(3);
        }else if (type.equals("FatalBomb")) {
            createObject(4);
        }else if (type.equals("FreezingFruit")) {
            createObject(5);
        }else if (type.equals("ComboFruit")) {
            createObject(6);
        }return object;

    }



    }
