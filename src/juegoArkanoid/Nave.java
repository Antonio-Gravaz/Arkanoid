package juegoArkanoid;

import java.awt.Color;
import java.awt.Graphics;

public class Nave extends Actor {

	public Nave(int x, int y, int ancho, int alto) {
		super(x, y, ancho, alto);
	}

	@Override
	public void paint(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(x, y, ancho, alto);
		
	}

	@Override
	public void actua() {
		
	}

}
