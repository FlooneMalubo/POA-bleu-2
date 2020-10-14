import java.util.ArrayList;

public class Barrieres {

    private boolean ouvert;         //true = ouvertes, false = fermées
    private final int rayon;        //rayon de détection
    private int distanceTrain;      //distance train-barrières ; on suppose 1 seul train

    public Barrieres(int rayon, int distanceTrain) {
        ouvert = false;
        this.rayon = rayon;
    }

    public boolean isDetect(Train t) {
        if(t.getDist() < rayon)
            return true;
        return false;
    }

    public void actionBarriere(boolean isDetect, ArrayList<Voiture> voitures) {
        if (isDetect) {
            if(voitureSurRail(voitures))
                ouvert = true;
            ouvert = false;
        }
        ouvert = true;
    }

    public static boolean voitureSurRail(ArrayList<Voiture> voitures) {
        for(Voiture v : voitures) {
            if (v.isSurRail())
                return true;
        }
        return false;
    }

    public boolean isOuvert() {
        return ouvert;
    }

}
