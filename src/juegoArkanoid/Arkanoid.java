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
	private static List<Actor> actores = new ArrayList<Actor>();
	
	public static Arkanoid getArkanoid() {
		if (instance == null) {
			instance = new Arkanoid();
		}
		return instance;
	}
	
	public static void main(String[] args) {

		JFrame ventana = new JFrame();
		ventana.setBounds(0,0,500,500);
		
		canvas = new MiCanvas(actores);
		  
		ventana.getContentPane().setLayout(new BorderLayout());
		ventana.getContentPane().add(canvas ,BorderLayout.CENTER);
		ventana.setIgnoreRepaint(true);
		ventana.setVisible(true); 
		
		crearActores();
		
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
	
	
	/**
	 * 
	 * @return
	 */
	
	public static List<Actor> crearActores() {
		Nave jugador = new Nave(10, 400, 50, 10);
		actores.add(jugador);
		int separacion = 2;
		Bloque mBloques[][]
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 10; j++) {
				
				Bloque bloque = new Bloque(2,2,
						getArkanoid().getMiCanvas().getWidth() / 10,
						getArkanoid().getMiCanvas().getHeight() / 3 / 5);
				actores.add(bloque);
				
			}
		}
		  
		Pelota pelota = new Pelota(
				numAleatorio(1, 400), 
				numAleatorio(1, 400), 
				10, 10);
		actores.add(pelota);
		return actores;
	}
	
	/**
	 * 
	 * @param minimo
	 * @param maximo
	 * @return
	 */
	
	private static int numAleatorio (int minimo, int maximo) {
		return (int) Math.round(Math.random() * (maximo - minimo) + minimo);
	}

	/**
	 * 
	 * @return
	 */
	
	public MiCanvas getMiCanvas() {
		return canvas;
	}
}
