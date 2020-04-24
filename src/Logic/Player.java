package Logic;

public class Player {
    private static Player p ;
  private   int lives ;
    private int score ;
    private Player (){
        this.lives=lives ;
        this.score=score ;

    }
    public static Player getP(){
 if (p==null)
 p=new Player();
 return p;

    }
}
