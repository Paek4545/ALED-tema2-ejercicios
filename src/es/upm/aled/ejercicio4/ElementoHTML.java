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
		 // Caso base:
		 if (elemento == null) {
			 return 0; 
		 }
		 // Inicialización:
		 int contador = 0;
		 
		 if (elemento.getTag().equals(tagBuscado) ) {
			 contador = 1; // Tag actual es el que buscamos
		 }
		 // Paso recursivo: Recorrer todos los hijos del elemento actual.
	      // Sumamos el resultado de las llamadas recursivas al contador.
		 for (ElementoHTML hijo : elemento.getHijos()) {
			 contador += contarEtiquetas(hijo, tagBuscado);
		 }
		 return contador;
	 }
}
