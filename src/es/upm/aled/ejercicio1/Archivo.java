package es.upm.aled.ejercicio1;
// Representa un archivo con un tamaño específico
public class Archivo {
	
		 private String nombre;
		 private double pesoMB; // Tamaño en Megabytes
		 
		 
		 public Archivo(String nombre, double peso) { 
			 this.nombre = nombre;
			 this.pesoMB = peso;
		 }
		 
		 public String getNombre() {
			 return nombre;
		 }
		 
		 public double getPesoMB() { 
			 return this.pesoMB; 
			 }
		 
		 public static double calcularPesoTotal(Carpeta inicio) {
			 double total = 0;
			 
			 // Sumar el peso de todos los archivos directos de esta carpeta: CASO BASE
			 for (Archivo archivo : inicio.getArchivos()) {
				 total += archivo.getPesoMB();
			 }
			 
			 // Recorremos sucesivamente todas las carpetas: PASO RECURSIVO
			 for (Carpeta carpetas : inicio.getSubcarpetas()) {
				 total += calcularPesoTotal(carpetas);
			 }
			 return total;
		 }
}
