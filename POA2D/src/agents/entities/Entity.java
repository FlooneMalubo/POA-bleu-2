package agents.entities;

import agents.Agent;

public abstract class Entity extends Agent{
	public static final int DEFAULT_ENTITY_WIDTH = 10,
							DEFAULT_ENTITY_HEIGHT = 10;
	

	public Entity(float x, float y, int w, int h) {
		super(x, y, w, h);
	}

}
