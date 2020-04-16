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
         object = new DangerousBomb();
     }
    else if (num==2)
     {
         object = new FatalBomb();

     }
    else if (num==3)
     {
         object = new SpecialFruit1();
     }
    else if (num==4)
     {
         object = new SpecialFruit2();
     }
    else {object=null;}

        object.getType();
        object.getXLocation();
        object.getYlocation();
        object.getInitialVelocity();
        object.getFallingVelocity();
    return object;
    }



}
