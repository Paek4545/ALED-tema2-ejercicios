package es.upm.aled.ejercicio11;

public class Contador {
	private  int contador;
	
	public Contador(int contador) {
		this.contador = contador;
	}
	public void contador(int N) {
	 for (int i = 0; i < N; i++) { 
	 for (int j = 0; j < i; j++) { // Se ejecuta i veces, donde i toma valore de 0 a N-1 --> Suma aritmética: (N-1)N/2
	 contador++;
	 }
	 }
	/* ¿Cuál será su valor final en función de N?
	 * 
	 ¿Cuál es la complejidad computacional en notación O del método?
	 */
	}
}
