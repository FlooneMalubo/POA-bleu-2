package state;

import main.Assets;
import java.awt.Graphics;

import agents.entities.Barriere;
import agents.vehicules.Train;
import agents.vehicules.Voiture;

public class WindowState extends State{
	
	private Voiture voiture;
	private Train train;
	private Barriere fence;
	
	public WindowState() {
		voiture = new Voiture(100, 100);
		train = new Train(0,0,4);
		fence = new Barriere(120, 120);
	}

	@Override
	public void update() {
		voiture.update();
		train.update();
		fence.update();
		
	}

	@Override
	public void render(Graphics g) {
		voiture.render(g);
		train.render(g);
		fence.render(g);
	}

}
