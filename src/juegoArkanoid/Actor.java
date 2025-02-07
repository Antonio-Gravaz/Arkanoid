package juegoArkanoid;

import java.awt.Graphics;

public abstract class Actor {

	protected int x;
	protected int y;
	protected int ancho;
	protected int alto;
	
	public Actor(int x, int y, int ancho, int alto) {
		super();
		this.x = x;
		this.y = y;
		this.ancho = ancho;
		this.alto = alto;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public abstract void paint(Graphics g);
	
	public abstract void actua();
	
}
