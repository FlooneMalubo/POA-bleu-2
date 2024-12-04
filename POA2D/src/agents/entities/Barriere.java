package agents.entities;

import java.awt.Color;
import java.awt.Graphics;

public class Barriere extends Entity{
	
	private boolean state;

	public Barriere(float x, float y) {
		super(x, y, Entity.DEFAULT_ENTITY_WIDTH,Entity.DEFAULT_ENTITY_HEIGHT);
		this.state = false;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	@Override
	public void update() {
		
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect((int)x, (int)y, width, height);
	}

}
