package agents.vehicules;

import java.awt.Graphics;

import main.Assets;

public class Voiture extends Vehicule{

	public Voiture(float x, float y) {
		super(x, y, Vehicule.DEFAULT_VEHICULE_WIDTH, Vehicule.DEFAULT_VEHICULE_HEIGHT);
		
	}

	@Override
	public void update() {
		
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.car, (int)x, (int)y, width, height, null);
	}

}
