package es.upm.aled.ejercicio7;

	/*
	 *  Dado un árbol binario, valide si cumple con la propiedad de un BST (Binary Search Tree,
 árbol binario de búsqueda): en cada nodo, todos los valores de los nodos del subárbol izquierdo
 son menores al del nodo, y todos los del derecho son mayores. Implemente la función auxiliar
 recursiva que mantiene un rango de valores válidos (min y max): esBSTaux
	 */
public class Nodo {
	int valor;
    Nodo izq, der;

    public Nodo(int valor) {
        this.valor = valor;
        this.izq = null;
        this.der = null;
    }
    public static boolean esBST(Nodo nodo) {
    	 return esBSTAux(nodo, Integer.MIN_VALUE, Integer.MAX_VALUE);
    	 }
    
    
   private static boolean esBSTAux(Nodo nodo, int min, int max) {
   		 // Caso base: si el nodo es nulo, hemos llegado al final de la rama
	   if (nodo == null) {
		   return true;
	   }
	   // Verificamos la condición BST para el nodo actual: si el valor del nodo es menor que el mínimo o mayor que el máximo devolveremos false
	   // es decir, que su valor debe ser mayor que el límite inferior (min) 
       // y menor que el límite superior (max)
	   if (nodo.valor <= min || nodo.valor >= max) {
		   return false;
	   }
	   
	   // Paso recursivo: Validar los subárboles izquierdo y derecho.
	   boolean maxValido = esBSTAux(nodo.izq , min, nodo.valor);
	   boolean minValido = esBSTAux(nodo.der, nodo.valor, max);
	   
	   return maxValido && minValido;
   }
}

