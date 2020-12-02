package Engine;


public class CreerEnvironnement {

    public static void main(String[] args) {

        //changer nbTour et les parametres de Croisement pour differents scenarios
        int distTrain = 11;
        int distVoiture = 1;
        int nbVoiture = 7;
        int nbVoitureCroisement = 10;
        int rayon = 5;
        int posCroisement = 4;

        int nbTour = 0;
        Environnement e = new Environnement(distTrain, distVoiture, nbVoiture, rayon, nbVoitureCroisement, posCroisement);

        //print etat initial 0
        System.out.println("########## DEBUT DE LA SIMULATION ##########\n");
        e.printRayon();
        System.out.print("Etat initial :");
        e.printEtat(0);

        while(!e.isGoalReached()) {
        	nbTour++;
        	e.avancerSimulation2();
            e.printEtat(nbTour);
        }

        System.out.println("\n########## Le train et les voitures ont atteint leur goal : fin de la simulation. ##########");
        System.out.println("Goal du train : depasser le passage a niveau");
        System.out.println("Goal des voitures : depasser le croisement");

    }

}