package Agents2;

import Agents2.Voiture;

public class Voiture extends Vehicule {

    private boolean surRail;
    

    public Voiture(int dist) {
        super(dist);
        distCroisement = dist + 3;
        if(dist != 0)
            surRail = false;
        else
            surRail = true;
    }
    
    

    public int getDistCroisement() {
        return distCroisement;
    }
    public void setDistCroisement(int d) {
        distCroisement = d;
    }

    public boolean isSurRail() {
        return surRail;
    }



}