package juegoArkanoid;

import java.awt.Color;
import java.awt.Graphics;

public class Pelota extends Actor {
	
	private int velocidadX = -2;
	private int velocidadY = -2;

	public Pelota(int x, int y, int ancho, int alto) {
		super(x, y, alto, ancho);
	}

	@Override
	public void paint(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillOval(x, y, ancho, alto);
		
	}

	@Override
	public void actua() {
		this.x += this.velocidadX;
		
		if (this.x < 0 || (this.x + this.ancho) > Arkanoid.getArkanoid().getMiCanvas().getWidth()) {
			this.velocidadX = -velocidadX;
		}
		
		this.y += this.velocidadY;
		
		if (this.y < 0 || (this.y + this.alto) > Arkanoid.getArkanoid().getMiCanvas().getHeight()) {
			this.velocidadY = -velocidadY;
		}
	}

	public int getVelocidadX() {
		return velocidadX;
	}

	public void setVelocidadX(int velocidadX) {
		this.velocidadX = velocidadX;
	}

	public int getVelocidadY() {
		return velocidadY;
	}

	public void setVelocidadY(int velocidadY) {
		this.velocidadY = velocidadY;
	}

	@Override
	public void colisionCon(Actor a) {
		super.colisionCon(a);
		if (a instanceof Bloque ||a instanceof Nave) {
			this.velocidadY = -this.velocidadY;
		}
	}
	
}
