package Engine;

import java.util.ArrayList;
import java.util.List;

import Agents2.Train;
import Agents2.Voiture;
import Regles.Rule;

public class Environnement {


    private Train train;
    private List<Voiture> voitures;
    private List<Voiture> voituresC;
    private int rayon;
    private boolean barrieresOuvertes = true;
    private int posCroisement;


    public Environnement(int distTrain, int distVoiture, int nbVoiture, int rayon, int nbVoitureCroisement, int posCroisement) {
        train = new Train(distTrain);
        voitures = new ArrayList<>();
        voituresC = new ArrayList<>();
        for(int i = 0; i < nbVoiture; i++) {
            Voiture a = new Voiture(distVoiture + i);
            voitures.add(a);
        }

        for(int i = 0; i < nbVoitureCroisement; i++) {
            Voiture a = new Voiture(distVoiture + 2*i);
            a.setDistCroisement(distVoiture + 2*i);
            voituresC.add(a);
        }

        this.rayon = rayon;
        this.posCroisement = -posCroisement;
    }

    public int getRayon() {
        return rayon;
    }

    public int getPosCroisement() {
        return posCroisement;
    }

    public List<Voiture> getVoitures() {
        return voitures;
    }

    public void printRayon() {
        System.out.println("Rayon de detection = " + rayon);
    }

    public void printEtat(int numeroEtat) {
        boolean surRail = false;
        String res = "\n---------- Tour " + numeroEtat + " ----------\n>>>>> Etat des barrieres : ";

        if(barrieresOuvertes)
            res += "ouvertes\n";
        else
            res += "fermees\n";

        res += train.toString();

        if(voitures.size() == 1)
            res += "\n>>>>> Distance de la voiture : ";
        else
            res += "\n>>>>> Distance des " + voitures.size() + " voitures : ";

        for(Voiture v : voitures) {
            res += v.getDist() + "; ";
            if(v.getDist() == 0)
                surRail = true;
        }

        if(voituresC.size() == 1)
            res += "\n>>>>> Distance de la voiture Croisement : ";
        else
            res += "\n>>>>> Distance des " + voituresC.size() + " voitures croisement : ";

        for(Voiture v : voituresC) {
            res += v.getDistCroisement() + "; ";
        }


        res += "\n>>>>> Voiture sur rail : " + surRail;

        System.out.println(res);
    }

    public boolean isGoalReached() {
        if(train.getDist() >= 0 - rayon)
            return false;
        for(Voiture v : voitures) {
            if(v.getDist() > posCroisement - 5)
                return false;
        }
        return true;
    }

    public void avancerSimulation() {
        Rule r = new Rule();
        r.setE(this);
        boolean trainStop = false;
        boolean personneSurRail = true;
        boolean peutAvancer = true;


        for(Voiture v : voitures) {
            for(Voiture y : voitures) {
                if(!v.equals(y) && (r.voitureDevant.test(v, y) || r.voitureDevantApresRail.test(v, y)) || (r.estDevantRail.test(v) && !barrieresOuvertes)) {
                    peutAvancer = false;
                }
            }
            if(peutAvancer) {
                v.avance();
            }
            if(r.voitureSurRail.test(v) && !barrieresOuvertes) {
                trainStop = true;
            }
            if(r.voitureSurRail.test(v)) {
                personneSurRail = false;
            }
        }

        barrieresOuvertes = (!r.estDetecte.test(train)) || (r.estDetecte.test(train) && !personneSurRail);

        if(!trainStop) {
            train.avance();
        }


    }

    public void avancerSimulation2() {
        Voiture transferer = null;
        Rule r = new Rule();
        r.setE(this);
        boolean trainStop = false;
        boolean peutAvancer = true;
        boolean peutTourner = false;
        boolean personneSurRail = true;

        //================================Croisement Train =============================
        for(Voiture v : voitures) {
        	peutAvancer = true;
            for(Voiture y : voitures) {
            	
                if(!v.equals(y) && (r.voitureDevant.test(v, y) || r.voitureDevantApresRail.test(v, y)) || (r.estDevantRail.test(v) && !barrieresOuvertes)) {
                    peutAvancer = false;
                }
            }
            
            for(Voiture y : voituresC) {
            	if(r.estDevantCroisement.test(v) && r.finDeRoute.test(y)) {  //------PRIO A DROITE
            		peutAvancer = false;
                }
            }
            
            if(peutAvancer) {
            	
                v.avance();
            }
            if(r.voitureSurRail.test(v) && !barrieresOuvertes) {
                trainStop = true;
            }
            if(r.voitureSurRail.test(v)) {
                personneSurRail = false;
            }
        }

        barrieresOuvertes = (!r.estDetecte.test(train)) || (r.estDetecte.test(train) && !personneSurRail);
        if(!trainStop) {
            train.avance();
        }

        //================================Croisement Voitures ============================
        for(Voiture v : voituresC) {
        	peutTourner = false;
        	peutAvancer = true;
            for(Voiture y : voitures) { // entre voiture croisement et voitures principales

                if(r.finDeRoute.test(v) && !r.estSurCroisement.test(y)) {
                    peutTourner = true;
                }
                
            }
            
            for(Voiture y : voituresC) { // uniquement voiture croisement
                if(!v.equals(y) && (r.voitureDevant.test(v, y) || r.finDeRoute.test(v)) ) {
                    peutAvancer = false;
                }
            }
            
            if(peutAvancer) {
                v.avance();
            }
            if(peutTourner) {
            	v.setDist(posCroisement);
                transferer = v;
            }
        }
        if(transferer != null) {
            voitures.add(transferer);
            voituresC.remove(transferer);
        }
    }


}
