package juegoArkanoid;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Arkanoid {

	public static void main(String[] args) {

		JFrame ventana = new JFrame();
		ventana.setBounds(0,0,500,500);
		
		MiCanvas canvas = new MiCanvas();
		
		ventana.getContentPane().setLayout(new BorderLayout());
		ventana.getContentPane().add(canvas ,BorderLayout.CENTER);
		ventana.setVisible(true);
		
	}

}
