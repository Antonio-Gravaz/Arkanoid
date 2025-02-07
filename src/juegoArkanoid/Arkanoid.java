package juegoArkanoid;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;

public class Arkanoid {
	
	
	private static int FPS = 60;
	private static Arkanoid instance = null;
	private static MiCanvas canvas = null;

	public static Arkanoid getArkanoid() {
		if (instance == null) {
			instance = new Arkanoid();
		}
		return instance;
	}
	
	public static void main(String[] args) {

		JFrame ventana = new JFrame();
		ventana.setBounds(0,0,500,500);
		
		List<Actor> actores = new ArrayList<Actor>();
		canvas = new MiCanvas(actores);
		  
		ventana.getContentPane().setLayout(new BorderLayout());
		ventana.getContentPane().add(canvas ,BorderLayout.CENTER);
		ventana.setIgnoreRepaint(true);
		ventana.setVisible(true); 
		
		Nave jugador = new Nave(10, 400, 50, 10);
		actores.add(jugador);
		Bloque bloque = new Bloque(10, 10, 20, 40);
		actores.add(bloque);  
		Pelota pelota = new Pelota(
				numAleatorio(1, 400), 
				numAleatorio(1, 400), 
				10, 10);
		actores.add(pelota);
		
		int millisPorFrame = 1000 / FPS;
		do {
			long millisAntesDeEscena = new Date().getTime();
			
			canvas.repaint();
			
			for (Actor a : actores) {
				a.actua();
			}
			
			long millisDespuesDeEscena = new Date().getTime();
			int millisProcesamientoEscena = (int) (millisDespuesDeEscena - millisAntesDeEscena);
			int millisPausa = millisPorFrame - millisProcesamientoEscena;
			millisPausa = (millisPausa < 0) ? 0 : millisPausa;
			
			try {
				Thread.sleep(millisPausa);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}while(true);
		
	}
	
	private static int numAleatorio (int minimo, int maximo) {
		return (int) Math.round(Math.random() * (maximo - minimo) + minimo);
	}

	public MiCanvas getMiCanvas() {
		return canvas;
	}
}
