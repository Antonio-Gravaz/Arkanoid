package juegoArkanoid;

import java.awt.Color;
import java.awt.Graphics;

public class Bloque extends Actor {
	
	private int eleccionColor;
	
	public Bloque(int x, int y, int ancho, int alto, int eleccionColor) {
		super(x, y, ancho, alto);
		this.eleccionColor = eleccionColor;
	}

	@Override
	public void paint(Graphics g) {
		switch (eleccionColor) {
			case 0:
				g.setColor(Color.BLUE);
				break;
			case 1:
				g.setColor(Color.CYAN);
				break;
			case 2:
				g.setColor(Color.PINK);
				break;
			case 3:
				g.setColor(Color.MAGENTA);
				break;
			case 4:
				g.setColor(Color.ORANGE);
				break;
			default:
				g.setColor(Color.WHITE);
				break;
		}
		g.fillRect(x, y, ancho, alto);
	}

	@Override
	public void actua() {		
	}

}
