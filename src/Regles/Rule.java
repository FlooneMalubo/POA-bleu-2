package Regles;

import Agents2.Train;
import Agents2.Voiture;
import Engine.Environnement;


import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class Rule {

    Environnement e;
    

    public Environnement getE() {
		return e;
	}
	public void setE(Environnement e) {
		this.e = e;
	}
	public Predicate<Train> estDetecte = t -> t.getDist() < e.getRayon() && t.getDist() > -e.getRayon();
	public Predicate<Voiture> estDevantRail = v -> v.getDist()-1 == 0 || v.getDist() == 0;
	public Predicate<Voiture> estPasseV = v -> v.getDist() < 0;
	public Predicate<Train> estPasseT = t -> t.getDist() < (-1) * e.getRayon();
	public Predicate<Voiture> voitureSurRail = v -> v.getDist() == 0;
	public BiPredicate<Voiture, Voiture> voitureDevant = (v1, v2) -> v2.getDist() == v1.getDist() - 1;
	public BiPredicate<Voiture, Voiture> voitureDevantApresRail = (v1, v2) -> (v1.getDist() == 1) && (v2.getDist() == -1);
	
	public Predicate<Voiture> estDevantCroisement = v -> v.getDist() == e.getPosCroisement() + 1;
	public Predicate<Voiture> estSurCroisement = v -> v.getDist() == e.getPosCroisement();
	public Predicate<Voiture> finDeRoute = v -> v.getDist() == 1;
	
}