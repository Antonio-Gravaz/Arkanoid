package juegoArkanoid;

import java.awt.BorderLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Arkanoid {
	
	
	private static int FPS = 60;
	private JFrame ventana = null;
	private MiCanvas canvas = null;
	private List<Actor> actores = new ArrayList<Actor>();
	Nave jugador = null;
	
	private static Arkanoid instance = null;
	
	public static Arkanoid getArkanoid() {
		if (instance == null) {
			instance = new Arkanoid();
		}
		return instance;
	}
	
	public Arkanoid() {
		ventana = new JFrame("Arkanoid");
		ventana.setBounds(0,0,500,500);
		
		ventana.getContentPane().setLayout(new BorderLayout());
		
		actores = crearActores();
		
		canvas = new MiCanvas(actores);
		
		canvas.addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				super.mouseMoved(e);
				jugador.mover(e.getX(), e.getY());
			}			
		});
		
		canvas.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				super.keyPressed(e);
				jugador.keyPressed(e);
			}

			@Override
			public void keyReleased(KeyEvent e) {
				super.keyReleased(e);
				jugador.keyReleased(e);
			}
		});
		
		ventana.getContentPane().add(canvas ,BorderLayout.CENTER);
		ventana.setIgnoreRepaint(true);
		ventana.setVisible(true);
		
		canvas.requestFocus();
		
		ventana.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		ventana.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				cerrarAplicacion();
			}
		});
	}
	
	
	
	public static void main(String[] args) {
		Arkanoid.getArkanoid().juego();
	}
	
	private void cerrarAplicacion() {
		String [] opciones ={"Aceptar","Cancelar"};
		int eleccion = JOptionPane.showOptionDialog(ventana,"¿Desea cerrar la aplicación?","Salir de la aplicación",
		JOptionPane.YES_NO_OPTION,
		JOptionPane.QUESTION_MESSAGE, null, opciones, "Aceptar");
		if (eleccion == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
	
	public void juego() {
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
			
		} while(true);
	}
	
	
	
	/**
	 * 
	 * @return
	 */
	
	public List<Actor> crearActores() {
		List<Actor> actores = new ArrayList<Actor>();
		
		jugador = new Nave(10, 400, 50, 10);
		actores.add(jugador);
		Bloque bloque = null;
		int separacion = 4;
		int posicionY = 2;
		for (int i = 0; i < 5; i++) {
			int posicionX = 2;
			for (int j = 0; j < 10; j++) {
				bloque = new Bloque(posicionX, posicionY, 45, 20, i);
				actores.add(bloque);
				posicionX += bloque.ancho + separacion;
			}
			posicionY += bloque.alto + separacion;
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
