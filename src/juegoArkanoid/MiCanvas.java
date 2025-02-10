package juegoArkanoid;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import java.util.List;

public class MiCanvas extends Canvas {
	
	List<Actor> actores = null;
	private BufferStrategy strategy = null;
	

	public MiCanvas(List<Actor> actores) {
		super();
		this.actores = actores;
	}



	
	public void pintarEscena() {
		if (strategy == null) {
			this.createBufferStrategy(2);
			strategy = getBufferStrategy();
		}
		
		Graphics2D g = (Graphics2D) strategy.getDrawGraphics();
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		for (Actor a : actores) {
			a.paint(g);
		}
		Toolkit.getDefaultToolkit().sync();
		strategy.show();
	}

	
	
}
