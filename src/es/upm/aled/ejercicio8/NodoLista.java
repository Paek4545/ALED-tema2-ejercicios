package es.upm.aled.ejercicio8;

public class NodoLista {
	int dato; 
	NodoLista siguiente; 
			 
	public NodoLista(int dato) {
		this.dato = dato;
		this.siguiente = null;
	}
	public static NodoLista invertirRecursivo(NodoLista actual) {
			 // Caso base: lista vacía o único elemento
			 if (actual == null || actual.siguiente == null) {
			 return actual;
			 }
			 // Paso recursivo:
			 NodoLista nuevaCabecera = invertirRecursivo(actual.siguiente);
			 // Reversión del enlace
		     // El nodo que sigue al actual (actual.siguiente) es ahora el predecesor en la nueva lista.
		     // Hacemos que el predecesor apunte HACIA ATRÁS al nodo 'actual'.
			 actual.siguiente.siguiente = actual;
			// El nodo 'actual' (que ahora es el último de esta subcadena) 
		        // debe apuntar a null. Esto evita ciclos en la lista.
		        // Esto solo se hace en la primera llamada de la cadena, ya que
		        // las llamadas internas apuntan a otros nodos, no a null. Sin embargo, 
		        // solo el nodo que era originalmente la cabecera (al final de la pila)
		        // debe apuntar a null.
			 actual.siguiente = null;
			 
			 return nuevaCabecera; //Último nodo de la lista
}
	public static void imprimirLista(NodoLista cabecera) {
        NodoLista actual = cabecera;
        while (actual != null) {
            System.out.print(actual.dato + " - ");
            actual = actual.siguiente;
        }
        System.out.println("NULL");
    }
	public static void main(String[] args) {
		NodoLista n1 = new NodoLista(1);
        NodoLista n2 = new NodoLista(2);
        NodoLista n3 = new NodoLista(3);
        
        // Enlaces de la lista original
        n1.siguiente = n2;
        n2.siguiente = n3;
        
        NodoLista cabeceraOriginal = n1;
        
        System.out.print("Lista Original: ");
        imprimirLista(cabeceraOriginal);
        
        NodoLista nuevaCabecera = NodoLista.invertirRecursivo(cabeceraOriginal);
        
        System.out.print("Lista Invertida: ");
        imprimirLista(nuevaCabecera); 
        }
}

