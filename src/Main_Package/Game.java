package Main_Package;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable {

	public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
	public int counter = 0;
	private static final long serialVersionUID = -624595824849380933L;
	// Only one thread will be used
	private Thread thread;
	private boolean running = false;
	private Handler handler;
	private Random r;
	private HUD hud;
	private Spawn spawn;
	private Menu menu;
	private GameOver gameOver;

	public enum STATE {
		Menu, Game, GameOver
	};

	public static STATE gameState = STATE.Menu;

	// Main logic
	public Game() {
		// handler need to be launched first
		handler = new Handler();
		hud = new HUD();
		spawn = new Spawn(handler, hud);
		menu = new Menu(this, handler, hud);
		gameOver = new GameOver();
		this.addKeyListener(new KeyInput(handler));
		this.addMouseListener(menu);
		r = new Random();
		new Window(WIDTH, HEIGHT, "Java Simple Game", this);
		if (gameState == STATE.Menu) {
			for (int i = 0; i < 15; i++) {
				handler.addObject(new MenuParicle(r.nextInt(Game.HEIGHT - 50), r.nextInt(Game.WIDTH - 50),
						ID.MenuParticle, handler));
			}

		}
		// Making stack of objects in the center of the screen
		/*
		 * if (gameState == STATE.Game){ handler.addObject(new Player(WIDTH / 2, (int)
		 * HEIGHT / 2, ID.Player, this.handler)); }
		 */

		// r = new Random();
		/*
		 * for (int i = 0; i < 2; i++) { handler.addObject(new
		 * BasicEnemy(r.nextInt(WIDTH), r.nextInt(HEIGHT), ID.BasicEnemy, handler)); }
		 */
		/*
		 * handler.addObject(new SmartEnemy(r.nextInt(Game.HEIGHT-50),
		 * r.nextInt(Game.WIDTH-50), ID.SmartEnemy, handler));
		 */

		/*
		 * handler.addObject(new BossEnemy(Game.WIDTH/2,-120, ID.BossEnemy, handler));
		 */
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

	public static float clamp(int var, int min, int max) {
		if (var >= max)
			return var = max;
		else if (var <= min)
			return var = min;
		else
			return var;
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
		// Not to click to activate the app
		this.requestFocus();
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
		if (gameState == STATE.Game) {
			hud.tick();
			spawn.tick();
		} else if (gameState == STATE.Menu) {
			menu.tick();
		}
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
		if (gameState == STATE.Game) {
			hud.render(g);
			// Than displaying
		} else if (gameState == STATE.Menu) {
			menu.render(g);
		} else if (gameState == STATE.GameOver) {
			gameOver.render(g);
		}
		g.dispose();
		bs.show();
	}

}
