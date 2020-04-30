package Logic;

public class Player {

  private   int lives ;
    private int score ;
    public Player (){
        this.lives=3 ;
        this.score=0 ;

    }

    public int getLives() {
        return lives;
    }

    public void decreaseLives() {
        this.lives -= 1;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
