import java.util.ArrayList;

public class Barrieres {

    private boolean ouvert;         //true = ouvertes, false = fermées
    private final int rayon;        //rayon de détection

    public Barrieres(int rayon, int distanceTrain) {
        ouvert = false;
        this.rayon = rayon;
    }

    public boolean isDetect(Train t) {
        if(Math.abs(t.getDist()) <= rayon) {
            return true;
        }
        return false;
    }

    public void actionBarriere(Train t, ArrayList<Voiture> voitures) {
        if (isDetect(t)) {
            if(voitureSurRail(voitures)) {
                ouvert = true;
            }
            else {
                ouvert = false;
            }
        }
        else
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
