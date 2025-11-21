package es.upm.aled.ejercicio12;

public class Proceso {
	 public static void procesar(int[] datos) {
		 int n = datos.length; // 6
		 for (int i = 1; i < n; i++) { // Se ejecutará 3 veces si i=2
		 int clave = datos[i]; // clave = datos[2] = 4; datos[4] = 1
		 int j = i- 1;	// j = 1; j = 3; j =5;
		 while (j >= 0 && datos[j] > clave) {
		 datos[j + 1] = datos[j];
		 j = j- 1;
		 }
		 datos[j + 1] = clave;
		 }
	 }
	 /*
	  * 1. Si datos = {5, 2, 4, 6, 1, 3}, ¿qué contendrá el array tras finalizar la iteración en la que i=2?
	  * 
 		2. ¿Qué algoritmo implementa este código?
 		3. ¿Cuál es la complejidad computacional en el peor caso y en el mejor caso? Justifique su respuesta
	  */
}
