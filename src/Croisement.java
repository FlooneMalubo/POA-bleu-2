import java.util.ArrayList;

public class Croisement {

    Train train;
    ArrayList<Voiture> voitures;
    Barrieres barrieres;

    public Croisement(int distTrain, int distVoiture, int nbVoiture, int rayonPerception) {
        train = new Train(distTrain);
        voitures = new ArrayList<>();
        for(int i = 0; i < nbVoiture; i++)
            voitures.add(new Voiture(distVoiture + i));
        barrieres = new Barrieres(rayonPerception, distTrain);
        barrieres.actionBarriere(train, voitures);
    }

    public void printEtat(int numeroEtat) {
        boolean surRail = false;
        String res = "\n---------- Tour " + numeroEtat + " ----------\n>>>>> État des barrières : ";

        if(barrieres.isOuvert())
            res += "ouvertes\n";
        else
            res += "fermées\n";

        res += ">>>>> Distance du train : " + train.getDist();

        if(voitures.size() == 1)
            res += "\n>>>>> Distance de la voiture : ";
        else
            res += "\n>>>>> Distance des " + voitures.size() + " voitures : ";

        for(Voiture v : voitures) {
            res += v.getDist() + "; ";
            if(v.getDist() == 0)
                surRail = true;
        }
        res += "\n>>>>> Voiture sur rail : " + surRail;

        System.out.println(res);
    }

    public void avancerSimulation() {
        train.avancerTrain();
        barrieres.actionBarriere(train, voitures);
        for(Voiture v : voitures) {
            if (barrieres.isOuvert() || (!barrieres.isOuvert() && (v.getDist() != 1))) {
                if (!v.voitureDevantMoi(voitures))
                    v.avancerVoiture();
            }
        }
    }

    public void printRayon() {
        System.out.println("Rayon de perception des barrières : " + barrieres.getRayon());
    }

}
