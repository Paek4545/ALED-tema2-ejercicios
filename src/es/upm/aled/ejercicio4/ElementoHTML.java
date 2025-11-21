package es.upm.aled.ejercicio4;

import java.util.List;

public class ElementoHTML {
	
	 private String tag; // Ejemplo: "div", "p", "img"
	 private List<ElementoHTML> hijos;
	 
	 public ElementoHTML(String tag, List<ElementoHTML> hijos) {
		 this.tag = tag;
		 this.hijos = hijos;
	 }
	 
	 public String getTag() { 
		 return this.tag; 
	 }
	 
	 public List<ElementoHTML> getHijos() { 
		 return this.hijos; 
	 }
	 
	 /*Implemente el método recursivo contarEtiquetas. Este método devuelve un entero indicando
	 cuántas veces aparece una etiqueta específica (tagBuscado) dentro del árbol que comienza en
	 elemento. */
	 
	 public static int contarEtiquetas(ElementoHTML elemento, String tagBuscado) {
		// Caso base: si no hay elemento o el tagBuscado no existe, devolveremos 0:
		 if(elemento == null || tagBuscado == null) {
			 return 0;
		 }
		 
		 // Ponemos un contador a 0:
		 int contador = 0;
		 
		 // Comprobamos primero si el elemento coincide:
		 if (elemento.getTag().equals(tagBuscado)) {
			 contador = 1;
		 }
		 
		 // Paso recursivo: si coincide, buscamos ahora en los hijos:
		 if(elemento.getHijos() != null) {
			 for(ElementoHTML hijo : elemento.getHijos()) {
				 contador += contarEtiquetas(hijo,tagBuscado);
			 }
		 }
		 return contador;
	 }
}
