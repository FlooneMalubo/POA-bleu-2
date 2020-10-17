public class Train {

    private int distTrain;  //distance train-barrières
    //on pourra plus tard ajouter une vitesse?
    //pour l'instant, on ne tient pas compte de la longueur du train

    public Train(int dist) {
        this.distTrain = dist;
    }

    public int getDist() {
        return distTrain;
    }

/*
    public void reculerTrain() {
        dist++;
    }
*/

    public void avancerTrain() {
        distTrain--;
        if(distTrain < -20)
            distTrain = 20;
    }

}