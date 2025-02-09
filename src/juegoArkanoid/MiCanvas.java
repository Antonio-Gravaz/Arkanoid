package juegoArkanoid;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.List;

public class MiCanvas extends Canvas {
	
	List<Actor> actores = null;
	

	public MiCanvas(List<Actor> actores) {
		super();
		this.actores = actores;
	}



	@Override
	public void paint(Graphics g) {
		this.setBackground(Color.BLACK);
		for (Actor a : actores) {
			a.paint(g);
		}
		Toolkit.getDefaultToolkit().sync();
	}

	
	
}
