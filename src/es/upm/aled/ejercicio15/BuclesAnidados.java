package es.upm.aled.ejercicio15;

public class BuclesAnidados {
	 public static void metodoLog(int n) {
		 int a = 0;
		 for (int i = 0; i < n; i++) {
		 for (int j = 1; j < n; j *= 2) { // n=10 --> j = 1, j =2; j=4;j=8
		 a++;
	 }
	}
 }
	 /*
	  *  a) Si n = 10, ¿cuántas veces se ejecuta la línea a++ aproximadamente?
	  *  i = 0; j=1,2, 4, 8.. N --> Es decir, que por cada iteración se ejecutaría log(n)+1 veces.
	  *  Por otra parte el bucle externo se ejecutaría N veces al ser lineal.
	  *  Para n = 10 --> a++ se ejecutaría aproximadamente 10*4 = 40 veces
 		 b) ¿Qué relación matemática tiene la variable índice j con n en el bucle interior?
 		La variable $j$ crece exponencialmente ($\mathbf{2^k}$), 
 		haciendo que el número de iteraciones del bucle interno sea logarítmico respecto a N log(N)
 		 c) Calcule la complejidad del algoritmo en notación O. Justifique su respuesta.
 		 O(N*logN). Producto de una complejidad lineal con una logarítmica.
	  */
}
