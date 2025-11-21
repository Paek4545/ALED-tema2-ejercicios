package es.upm.aled.ejercicio13;

public class Contador {
	 public static long calcular(int n) {
		 long contador = 0;
		 for (int i = 0; i < n; i++) {
		 for (int j = 0; j < i; j++) {
		 contador++;
		 }
		 }
		 return contador;
		 }
	 /*
	  * a) Si n=5, ¿cuál es el valor final de contador?
	  * para i = 0, j= 0 --> 0 veces
	  * para i = 1, j = 0, 1 -> 1 vez
	  * para i = 2, j= 0, 1, 2 -> 2 veces
	  * para i = 3, j = 0, 1, 2, 3 -> 3 veces
	  * para i = 4, j = 0, 1, 2, 3, 4 -> 4 veces
	  * Sumando todo --> contador = 0+1+2+3+4 = 10
 		b) ¿Cuántas veces se ejecuta la instrucción contador++ en función de n? 
 		Exprese el resultado como una suma aritmética.
 		En función de n, se ejecutará 10 veces.
 		Suma aritmética: (N-1)*N/2
 		c) Deduzca la complejidad O del algoritmo
 		O((N-1)*N/2) = O(N^2/2)-O(N/2) = O(N^2)
	  */
}
