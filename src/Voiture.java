import java.util.ArrayList;

public class Voiture {

    //à compléter

    private boolean surRail;
    private int distVoiture;      //distance voiture-barrières

    public Voiture(int distVoiture) {
        this.distVoiture = distVoiture;
        surRail = false;
    }

    public void surRail() {
        if(distVoiture == 0)
            surRail = true;
        surRail = false;
    }

    public void avancerVoiture() {
        distVoiture--;
        if(distVoiture < -15)
            distVoiture = 15;
    }

    public boolean voitureDevantMoi(ArrayList<Voiture> voitures) {
        for(Voiture v : voitures) {
            if(v.getDist() == this.getDist() - 1)
                return true;
        }
        return false;
    }

    public int getDist() {
        return distVoiture;
    }

    public boolean isSurRail() {
        return surRail;
    }

}