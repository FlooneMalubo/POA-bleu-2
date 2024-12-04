package agents.vehicules;

import agents.Agent;

public abstract class Vehicule extends Agent{
	protected float velocity, xVelocity, yVelocity;
	public static final float DEFAULT_VELOCITY = 1;
	public static final int DEFAULT_VEHICULE_WIDTH = 16,
							DEFAULT_VEHICULE_HEIGHT = 16;
	
	
	public float getxVelocity() {
		return xVelocity;
	}
	public void setxVelocity(float xVelocity) {
		this.xVelocity = xVelocity;
	}
	public float getyVelocity() {
		return yVelocity;
	}
	public void setyVelocity(float yVelocity) {
		this.yVelocity = yVelocity;
	}
	
	public float getVelocity() {
		return velocity;
	}
	public void setVelocity(float velocity) {
		this.velocity = velocity;
	}
	
	public Vehicule(float x, float y, int w, int h) {
		super(x, y, w, h);
		this.xVelocity = DEFAULT_VELOCITY;
		this.yVelocity = DEFAULT_VELOCITY;
	}

	


}
