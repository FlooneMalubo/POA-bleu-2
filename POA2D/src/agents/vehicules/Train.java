package agents.vehicules;

import java.awt.Graphics;

import main.Assets;

public class Train extends Vehicule {
	
	private int size;

	public Train(float x, float y, int size) {
		super(x, y, Vehicule.DEFAULT_VEHICULE_WIDTH, Vehicule.DEFAULT_VEHICULE_HEIGHT);
		this.size = size;
	}

	@Override
	public void update() {
		
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.train, (int)x, (int)y, width, height, null);
		for(int i = 1; i < this.size; i++) {
			g.drawImage(Assets.wagon, (int)x + i*20, (int)y, width, height, null);
		}
	}

}
