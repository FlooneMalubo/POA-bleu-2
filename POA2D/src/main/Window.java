package main;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import display.Display;
import state.MenuState;
import state.SettingsState;
import state.State;
import state.WindowState;

public class Window implements Runnable{
	
	private Display display;
	
	public int width, height;
	public String title;
	private boolean running = false;
	private BufferStrategy bs;
	private Graphics g;
	//States
	private State windowState, menuState, settingsState;

	private Thread thread;
	
	public Window(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
		
	}
	
	public synchronized void start() {
		if(running)
			return;
		this.running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop() {
		if(!running)
			return;
		this.running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void init() {
		display = new Display(title, width, height);
		Assets.init();
		
		windowState = new WindowState();
		settingsState = new SettingsState();
		menuState = new MenuState();
		State.setState(windowState);
		
	}
	
	private void update() {
		if(State.getState() != null) {
			State.getState().update();
		}
	}
	
	private void render() {
		bs = display.getCanvas().getBufferStrategy(); // tell computer how to draw using buffers
		if(bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		//clear screen
		g.clearRect(0, 0, width, height);
		//drawing
//		g.drawImage(Assets.car, 0,10,null);
//		g.drawImage(Assets.train, 50,10,null);
//		g.drawImage(Assets.wagon, 50,100,null);
		
		if(State.getState() != null) {
			State.getState().render(g);
		}
		
		//finish drawing
		bs.show();
		g.dispose();
		
	}

	@Override
	public void run() {
		init();
		int fps = 60;
		double timePerTick = 1000000000/fps;
		double delta = 0;
		long currentTime;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		
		while(running) {
			currentTime = System.nanoTime();
			delta += (currentTime - lastTime) / timePerTick;
			timer += currentTime - lastTime;
			lastTime = currentTime;
			if(delta >= 1) {
				update();
				render();
				ticks++;
				delta--;
			}
			if(timer >= 1000000000) {
				System.out.println("FPS : " + ticks);
				ticks = 0;
				timer = 0;
			}
			
		}
		
		stop();
		
	}

}
