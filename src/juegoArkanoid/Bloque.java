package juegoArkanoid;

import java.awt.Color;
import java.awt.Graphics;

public class Bloque extends Actor {

	public Bloque(int x, int y, int ancho, int alto) {
		super(x, y, alto, ancho);
	}

	@Override
	public void paint(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(x, y, ancho, alto);
	}

	@Override
	public void actua() {		
	}

}
