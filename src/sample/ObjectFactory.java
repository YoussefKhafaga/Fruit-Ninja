package sample;

public class ObjectFactory {
    public GameObject createObject(int num)
    {
        GameObject object;
     if (num==0)
     {
    object = new Fruit();
     }
    else if (num==1)
     {
         object = new Bomb();
     }
    else object = null;
        object.getType();
        object.getXLocation();
        object.getYlocation();
        object.getInitialVelocity();
        object.getFallingVelocity();
    return object;
    }



}
