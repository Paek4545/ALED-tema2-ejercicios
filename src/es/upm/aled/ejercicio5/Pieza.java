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
		// Si no hay pieza, no puede estar defectuosa
		 if(piezaPrincipal == null) {
			 return false;
		 }
		// Caso base: la pieza principal es defectuosa:
		 if(piezaPrincipal.isDefectuosa()) {
			 return true;
		 }
		 // Por otro lado, las componentes existen, tenemos que hacer el paso recursivo, donde si encontramos alguno defectuoso
		 // Habrá que devolver un true:
		 if(piezaPrincipal.getComponentes()!= null) {
			 for(Pieza componentes : piezaPrincipal.getComponentes()) {
				 if(contieneDefectos(componentes)) {
					 return true;
			 }	 
			 }
			 
		 }
		// Si no se cumplen las condiciones de defecto, devolveremos false:
		 return false;
	 }

}
