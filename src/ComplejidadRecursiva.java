
public class ComplejidadRecursiva {
	
	 public static void metodoRaro(int n) {
		 if (n <= 0) return;
		 System.out.println(n);
		 metodoRaro(n- 1);
		 metodoRaro(n- 1);
		 }
	 public static void main(String[] args) {
		 int n = 3;
		 metodoRaro(n);
	 }
		/* 
		 * a) ¿Cuántas llamadas a metodoRaro se hacen para n=3?
		 * metodoRaro se llamará recursivamente hasta que n = 0 --> n = 3 tenemos que métodoRaro(3-1) --> 1 vez
		 * 1 + T(n-1) + T(n-1) = 2*T(n-1) + 1 = 2^n+1 - 1 = 15
		 * Esquema de recursividad:
		 * Caso base: T(0) = 1 
		 * 1 + 2*T(0) = 1 + 2 = 3 = T(1)
		 * 1 + 2*T(1) = 1 + 2*3 = 7 = T(2)
		 * 1 + 2*T(2) = 1 + 2*7 = 15 = T(3)
		 * 
		 b) ¿Cuál es la complejidad en notación O en función de n? Pista: Fíjese en que cada paso
		 duplica el trabajo
		 En este caso su complejidad algorítmica, sería exponencial, de la forma O(2^n)
		 T(n) = 2T(n-1) + O(1) -> O(2^n) 
		 
		 */
}
