package es.upm.aled.ejercicio6;

public class PalindromoRecursivo {
	/*
	 *  Escriba un método recursivo esPalindromo(String texto) que devuelva true si la cadena
 texto es un palíndromo (se lee igual al derecho y al revés) y false en caso contrario. Asuma
 que el texto no contiene espacios en blanco y que todos los caracteres están en minúsculas.
 public static boolean esPalindromo(String texto) {}
 
 Si necesita ayuda: El caso base es una cadena de longitud 0 o 1. El caso recursivo compara
 el primer y último carácter y llama a la función con la subcadena interior.
	 */
	 public static boolean esPalindromo(String texto) {
		 // Caso base
		 if (texto == null || texto.length() <= 1) {
			 return true;
		 }
		 // Obtenemos el primer y último carácter:
		 char primerCaracter = texto.charAt(0);
		 char ultimoCaracter = texto.charAt(texto.length()-1);
		 
		 // Paso recursivo: comparamos los extremos
		 if (primerCaracter != ultimoCaracter) {
			 return false;
		 }
		 String subcadena = texto.substring(1, texto.length()-1);
		 return esPalindromo(subcadena);
	 }
	 public static void main(String[] args) {
	        System.out.println("radar: " + esPalindromo("radar"));  
	        System.out.println("reconocer: " + esPalindromo("reconocer")); 
	        System.out.println("hola: " + esPalindromo("hola"));     
	        System.out.println("a: " + esPalindromo("a"));         
	        System.out.println("vaca: " + esPalindromo("vaca"));     
	    }
}
