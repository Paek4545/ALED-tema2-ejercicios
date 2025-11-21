package es.upm.aled.ejercicio5;

import java.util.ArrayList;
import java.util.List;

public class Pieza {
	
	 private String nombre;
	 private boolean esDefectuosa;
	 private List<Pieza> componentes; // Piezas necesarias para montar esta
	 
	 public Pieza(String nombre, boolean esDefectuosa, List<Pieza> componentes) {
		 this.nombre = nombre;
		 this.esDefectuosa = esDefectuosa;
		 this.componentes = new ArrayList<Pieza>();
	 }
	 public boolean isDefectuosa() {  
		 return this.esDefectuosa; 
	 }
	 
	 public List<Pieza> getComponentes() { 
		 return this.componentes; 
	 }
	 
	 /*
	  *  Implemente el método recursivo contieneDefectos: Devuelve true si la piezaPrincipal o
 cualquiera de sus componentes (en cualquier nivel de profundidad) está marcado como defectuoso.
 Si todas las piezas están bien, devuelve false.
	  */
	 public static boolean contieneDefectos(Pieza piezaPrincipal) {
		// Caso base:
		 if(piezaPrincipal == null) {
			 return true;
		 }
		 if (piezaPrincipal.isDefectuosa()) {
			 return true;
		 }
		 // Paso recursivo
		 for (Pieza pieza : piezaPrincipal.getComponentes()) {
			if(contieneDefectos(pieza)) {
				return true;
			}
		 }
		 return false;
	 }

}
