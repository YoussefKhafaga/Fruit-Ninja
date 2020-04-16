package sample;

public abstract class IsSliced {
    private boolean isSliced;
    private int livesLost ;
    private int pointsScored;

    public IsSliced(boolean isSliced, int livesLost, int pointsScored) {
        this.isSliced = isSliced;
        this.livesLost = livesLost;
        this.pointsScored = pointsScored;
    }

    public IsSliced() {

    }

    public boolean isSliced() {
        return isSliced;
    }

    public void setSliced(boolean sliced) {
        isSliced = sliced;
    }

    public int getLivesLost() {
        return livesLost;
    }

    public void setLivesLost(int livesLost) {
        this.livesLost = livesLost;
    }

    public int getPointsScored() {
        return pointsScored;
    }

    public void setPointsScored(int pointsScored) {
        this.pointsScored = pointsScored;
    }
}
