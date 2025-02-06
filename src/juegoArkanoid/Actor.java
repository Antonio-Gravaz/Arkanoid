package juegoArkanoid;

import java.awt.Graphics;

public abstract class Actor {

	protected int x;
	protected int y;
	
	public Actor(int x, int y) {
		super();
		this.x = x;
		this.y = y;
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
	
}
