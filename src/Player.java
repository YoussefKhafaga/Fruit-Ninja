public class Player {
    private static Player p ;
    int lives ;
    int score ;
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
