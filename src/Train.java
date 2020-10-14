public class Train {

    private int dist;
    //on pourra plus tard ajouter une vitesse?

    public Train(int dist) {
        this.dist = dist;
    }

    public int getDist() {
        return dist;
    }

    public void addDist() {
        dist++;
    }

    public void subDist() {
        dist--;
    }

}