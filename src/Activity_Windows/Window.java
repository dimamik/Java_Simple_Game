package Activity_Windows;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

import Main_Package.Game;

public class Window extends Canvas {

	private static final long serialVersionUID = -147345094786856929L;

	public Window(int width, int height, String title, Game game) {
		JFrame frame = new JFrame(title);

		frame.setPreferredSize(new Dimension(width, height));
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));

		// Handle the exit button behavior
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setResizable(false);
		frame.setLocationRelativeTo(null);

		// Adding game module to the JFrame object
		frame.add(game);
		frame.setVisible(true);

		game.start();
	}
}
