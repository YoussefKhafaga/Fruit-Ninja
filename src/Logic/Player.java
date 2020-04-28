package Logic;

public class Player {

  private   int lives ;
    private int score ;
    public Player (){
        this.lives=3 ;
        this.score=0 ;

    }
//    public static Player getP(){
// if (p==null)
// p=new Player();
// return p;
//
//    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
