package Main_Package;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {

	public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
	public int counter = 0;
	private static final long serialVersionUID = -624595824849380933L;
	// Only one thread will be used
	private Thread thread;
	private boolean running = false;
	private Handler handler;

	// Main logic
	public Game() {
		new Window(WIDTH, HEIGHT, "Java Simple Game", this);
		handler = new Handler();
		// Making stack of objects in the center of the screen
		for (int i = 0; i < 50; i++) {
			handler.addObject(new Player(WIDTH / 2, (int) HEIGHT / 2, ID.Player));
		}

	}

	// Starter of main logic
	public static void main(String[] args) {
		new Game();
	}

	// Using synchronized to prevent two outgoing threads calling same method
	public synchronized void start() {
		// Starting the thread
		thread = new Thread(this);

		// Executing the run() method with new thread
		thread.start();
		// At the same time continuing with main thread

		running = true;

	}

	public synchronized void stop() {
		// Stopping the thread
		try {
			thread.join();
			running = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void run() {
		// Code used form StackOverFlow to handle the realtime_fps property
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				tick();
				delta--;
			}
			if (running) {
				render();
			}
			frames++;
			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		stop();
	}

	private void tick() {
		// Method updating an objects
		// Handle every while opening with delta >= 1 (Pseudo time unit)
		handler.tick();

	}

	private void render() {

		// Method rendering a picture (background and so on)
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		// First making the background
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.yellow);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		// Than making foreground
		handler.render(g);
		// Than displaying
		g.dispose();
		bs.show();
	}

}
