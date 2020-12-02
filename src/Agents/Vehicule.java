package Agents2;

public abstract class Vehicule {

    protected int dist;
    protected int distCroisement;

    public Vehicule(int dist) {
        this.dist = dist;
    }

    public void avance() {
        dist--;
        distCroisement--;
    }
    
    public void setDist(int d) {
    	dist = d;
    }
    
    public int getDist() {
        return dist;
    }

}
