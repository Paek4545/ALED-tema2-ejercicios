package es.upm.aled.ejercicio1;

public class CarpetaUtils {
	/*
	 *  Implemente el método recursivo calcularPesoTotal: Este método debe devolver la suma
 		total del peso (en MB) de una Carpeta y todo su contenido (archivos directos y archivos dentro
 		de subcarpetas, recursivamente)
	 */
	 public static double calcularPesoTotal(Carpeta inicio) {
		 // Caso base: no hay carpetas con archivos ni subcarpetas
		 if (inicio == null) {
			 return 0;
		 }
		 double pesoTotal = 0;
		 
		 if(inicio.getArchivos() != null) {
			 // Obtenemos todos los archivos
			 for(Archivo archivo : inicio.getArchivos()) {
			// Obtenemos el pesoTotal de estos archivos:
				 pesoTotal += archivo.getPesoMB();
			 }
		// Por otro lado, obtenemos las subcarpetas:
			 if(inicio.getArchivos() != null) {
				 for(Carpeta carpeta : inicio.getSubcarpetas()) {
		// Actualizamos el peso mediante el paso recursivo:
				pesoTotal += calcularPesoTotal(carpeta);
				 }
					 
			 }
		 }
		 return pesoTotal;
	 }
}
