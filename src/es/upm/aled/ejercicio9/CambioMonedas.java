package es.upm.aled.ejercicio9;

public class CambioMonedas {
	/**
     * Calcula de cuántas formas distintas se puede sumar la cantidad objetivo 
     * usando monedas de valores 1, 2 y 5, con un límite de cantidad para cada tipo.
     *
     * @param objetivo La cantidad total que se desea alcanzar.
     * @param monedas Array [num_1, num_2, num_5] con el límite de monedas disponibles.
     * @return El número total de formas de lograr el objetivo.
     */

	public static int contarFormasCambio(int objetivo, int[] monedas) {
		// Definimos los valores de las monedas según el índice del array
		// 0->1, 1->2, 2->5
		// Así podemos reutilizar este array con otros tipos de monedas
		int[] valores = { 1, 2, 5 };
		// Llamada al auxiliar empezando por la moneda más grande (índice 2)
		return contarAux(objetivo, monedas, valores, 2);
	}

	// Para evitar contar permutaciones (ej: 1+2 y 2+1) como distintas, usamos un
	// método auxiliar que impone un orden en el uso de monedas
	private static int contarAux(int objetivo, int[] cantidades, int[] valores, int indiceMoneda) {
		// Casos base
		if (objetivo == 0)
			return 1; // Solución encontrada, ya tenemos 1 forma
		if (objetivo < 0)
			return 0; // Se pasó
		if (indiceMoneda < 0)
			return 0; // No quedan tipos de monedas para probar

		int valorActual = valores[indiceMoneda]; // Guardamos la moneda con la que vamos a trabajar
		int cantidadDisponible = cantidades[indiceMoneda];
		int formas = 0;

		// Probamos a usar desde 0 hasta cantidadDisponible monedas de este tipo
		for (int i = 0; i <= cantidadDisponible; i++) {
			int sumaActual = i * valorActual;

			// Si nos pasamos, dejamos de probar (optimización)
			if (sumaActual > objetivo)
				break;

			// Llamada recursiva con el objetivo restante y pasando al siguiente tipo de moneda
			// Pasamos cantidades tal cual porque vamos a trabajar con otro tipo de moneda
			formas += contarAux(objetivo - sumaActual, cantidades, valores, indiceMoneda - 1);
		}

		return formas;
	}

	public static void main(String[] args) {
		// Para un objetivo de 3:
        // Monedas disponibles: ilimitadas (ponemos un número grande)
        int[] limites = {10, 10, 10}; 
        int resultado = contarFormasCambio(3, limites); 
        System.out.println("Formas de sumar 3 (1+1+1, 1+2): " + resultado);
        
        // Para un objetivo de 3:
        // Límites: una de 1, una de 2, una de 5.
        // Formas: (5)
        int[] limites2 = {1, 1, 1}; 
        resultado = contarFormasCambio(5, limites2); 
        System.out.println("Formas de sumar 5 (con límites 1,1,1): " + resultado);

        // Ejemplo: objetivo = 3, con límite de una moneda de 2
        // Formas: (1+1+1)
        int[] limites3 = {3, 0, 1}; 
        resultado = contarFormasCambio(3, limites3); 
        System.out.println("Formas de sumar 3 (con límite 1 de 2): " + resultado); 
    }
}
