package es.upm.aled.ejercicio14;

public class BusquedaBinariaModificada {
	 public static int busqueda(int[] arr, int inicio, int fin, int x) {
		 // Caso base:
		 if (fin < inicio) 
		return-1;
		 // Código general:
		 int medio = inicio + (fin- inicio) / 2;
		 if (arr[medio] == x) 
			 return medio;
		 if (arr[medio] > x)
		// Paso recursivo
		 return busqueda(arr, inicio, medio - 1, x);
		 return busqueda(arr, medio + 1, fin, x);
		 }
	 /*
	  *  Dado arr = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91} y buscando x = 23. 
	  */
	 public static void main(String[] args) {
		 int[] arr = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
		 int x = 23;
		 System.out.println("El vaor " + x + " se encuentra en la posición: " + busqueda(arr,0,arr.length -1, x));
		 // a) Indique la secuencia de valores que toma la variable medio hasta encontrar el valor.
		 // Para llegar hasta 23, medio tomará primero los valores de los índices 0 y 9 = 0+9/2 = 4 --> arr[4] = 16, 
		 // como este es menor que 23, inicio = medio + 1 = 4 +1 = 5 -> medio= 5+9/2 = 7 -> arr[7] = 56 --> Al ser mayor
		 // que 23, esta vez cambiamos el limite superior: fin = medio -1 = 7-1 = 6 -> medio = 5+6/2 = 5 --> arr[5] = 23
		 // que es justo el valor que buscamos --> Secuencia de valores: 4->7->5
		 
		 // b)  ¿Qué ocurre si el array no está ordenado previamente?
		 // Si el array no está ordenado, la búsqueda binaria no funciona y puede devolver una posición incorrecta o -1,
		 
		 // c)  ¿Cuál es la complejidad del algoritmo en notación O? Justifique basándose en cómo se
		 // reduce el tamaño del problema en cada llamada recursiva.
		 // Como partimos por la mitad en cada llamada, podemos decir que presenta una complejidad O(logN)
		 }
}
