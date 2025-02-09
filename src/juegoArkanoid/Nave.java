package juegoArkanoid;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Nave extends Actor { 
	
	private boolean derecha = false, izquierda = false;
	private static int VELOCIDAD = 5;

	public Nave(int x, int y, int ancho, int alto) {
		super(x, y, ancho, alto);
	}

	@Override
	public void paint(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(x, y, ancho, alto);
		
	}

	public void mover(int x, int y) {
		this.x = x;
		this.y = y;
		
		MiCanvas canvas = new Arkanoid().getArkanoid().getMiCanvas();
		
		if (this.x > (canvas.getWidth() - this.ancho)) {
			this.x = canvas.getWidth() - this.ancho;
		}
		
		if (this.x < 0) {
			this.x = 0;
		}
	}
	
	public void keyPressed (KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			izquierda = true; break;
		case KeyEvent.VK_RIGHT:
			derecha = true; break;
		}
	}
	
	public void keyReleased (KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			izquierda = false; break;
		case KeyEvent.VK_RIGHT:
			derecha = false; break;
		}
	}
	
	@Override
	public void actua() {
		if(derecha) this.x += VELOCIDAD;
		if(izquierda) this.x -= VELOCIDAD;
		mover(this.x, this.y);
	}

}
