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
	 
	 public void addDesbloqueables(Habilidad raiz) {
		this.desbloqueables.add(raiz);
	 }
	

	 /*Implemente el método recursivo costeRamaCompleta, que calcula cuántos puntos totales
	 hacen falta para desbloquear la habilidad raíz y todas las habilidades que descienden de ella en
	 el árbol (es decir, la rama completa).
	 */

	 public static int costeRamaCompleta(Habilidad raiz) {
		 // Caso base: Si no hay habilidades que queden por desbloquear en la raíz, devolverá 0
		 if (raiz == null) {
			 return 0;
		 }
		 
		 // Nos calculamos el costeTotal de la rama:
		 int costeTotal = raiz.getCoste();
		 
		 // Paso recursivo: Ahora, si en una raíz podemos desbloquear habilidades, entonces tenemos que:
		 if(raiz.getDesbloqueables() != null) {
			 for(Habilidad habilidad : raiz.getDesbloqueables()) {
				 costeTotal += costeRamaCompleta(habilidad);
			 }
		 }
		 return costeTotal;
		 
	 }
}
