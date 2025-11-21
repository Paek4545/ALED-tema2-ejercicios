package es.upm.aled.ejercicio3;

import java.util.List;

public class Habilidad {
	 private String id;
	 private int costePuntos; // Coste para desbloquear esta habilidad
	 private List<Habilidad> desbloqueables; // Habilidades que dependen de esta
	 
	 public int getCoste() { 
		 return this.costePuntos; 
		 
	 }
	 public List<Habilidad> getDesbloqueables() { 
		 return this.desbloqueables; 
	 }
	

	 /*Implemente el método recursivo costeRamaCompleta, que calcula cuántos puntos totales
	 hacen falta para desbloquear la habilidad raíz y todas las habilidades que descienden de ella en
	 el árbol (es decir, la rama completa).
	 */

	 public static int costeRamaCompleta(Habilidad raiz) {
		 // Inicialización:
		 int costeTotal = raiz.getCoste();
		 // Paso recursivo
		 for (Habilidad habilidades : raiz.getDesbloqueables()) {
		costeTotal += costeRamaCompleta(habilidades);
		 }
		 // Caso base:
		 return costeTotal;
		 
		 
	 }
}
