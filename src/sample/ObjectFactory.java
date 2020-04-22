package sample;

public class ObjectFactory {
    public GameObject createObject(int num) {
        GameObject object;
        if (0 <= num && num <= 5) {
            object = new Fruit();
        } else if (num == 6) {
            object = new DangerousBomb();
        } else if (num == 7) {
            object = new FatalBomb();
        } else if (num == 8) {
            object = new SpecialFruit1();
        } else if (num == 9) {
            object = new SpecialFruit2();
        } else {
            object = null;
        }
        return object;
    }



}
