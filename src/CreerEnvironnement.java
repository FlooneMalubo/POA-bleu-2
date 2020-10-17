public class CreerEnvironnement {

    public static void main(String[] args) {

        //changer nbTour et les paramètres de Croisement pour différents scénarios

        final int nbTour = 20;
        Croisement c = new Croisement(6,7,3,4);

        //print état initial 0
        c.printEtat(0);

        for(int i = 1; i <= nbTour; i++) {
            c.avancerSimulation();
            c.printEtat(i);
        }

    }

}
