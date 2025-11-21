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

	    // Asumimos que los valores de las monedas se prueban de mayor a menor {5, 2, 1}
	    private static final int[] VALORES_MONEDAS = {5, 2, 1}; 
	    
	    // Método público de inicio: ajusta los límites al orden {5, 2, 1}
	    public static int contarFormasCambio(int objetivo, int[] monedas) {
	        // Mapeamos el array original {1, 2, 5} -> a la estructura {5, 2, 1} para la recursión
	        int[] limites = {monedas[2], monedas[1], monedas[0]}; 
	        return contarFormasAux(objetivo, limites, 0); // Empezamos en la moneda de 5 (índice 0)
	    }

	    private static int contarFormasAux(int objetivo, int[] limites, int indiceActual) {
	        
	        // 🛑 Caso Base 1: Objetivo alcanzado.
	        if (objetivo == 0) {
	            return 1;
	        }

	        // 🛑 Caso Base 2: Objetivo sobrepasado o no quedan tipos de monedas por probar.
	        if (objetivo < 0 || indiceActual >= VALORES_MONEDAS.length) {
	            return 0;
	        }

	        int valorMoneda = VALORES_MONEDAS[indiceActual];
	        int limiteDisponible = limites[indiceActual];
	        int formasTotales = 0;
	        
	        // 🔄 Paso Recursivo: Probar usar 0, 1, 2, ... hasta el límite de la moneda actual.
	        // i representa el número de monedas de este tipo (valorMoneda) que usamos.
	        for (int i = 0; i <= limiteDisponible; i++) {
	            
	            int nuevoObjetivo = objetivo - (i * valorMoneda);
	            
	            // Si el objetivo ya se pasó al usar 'i' monedas, rompemos.
	            if (nuevoObjetivo < 0) {
	                break;
	            }
	            
	            // Si el objetivo es 0, ya hemos encontrado una forma válida.
	            if (nuevoObjetivo == 0) {
	                 formasTotales++;
	                 continue; // Pasamos a probar la siguiente cantidad 'i' de esta moneda.
	            }

	            // Crear una copia de los límites para pasar el estado.
	            int[] limitesRestantes = limites.clone();
	            
	            // Actualizar el límite de la moneda actual para el resto de la recursión.
	            // Si usamos 'i' monedas en este nivel, quedan 'limiteDisponible - i' para los
	            // niveles inferiores que aún puedan usar monedas de esta denominación
	            // (lo cual es innecesario si pasamos al siguiente índice, pero evita errores).
	            limitesRestantes[indiceActual] -= i;
	            
	            // Llamada Recursiva: Pasamos al SIGUIENTE TIPO de moneda (indiceActual + 1).
	            // Ya que el bucle 'for' probó todas las cantidades (0 a i) para la moneda actual, 
	            // la siguiente llamada debe enfocarse en la siguiente denominación.
	            formasTotales += contarFormasAux(nuevoObjetivo, limitesRestantes, indiceActual + 1);
	        }

	        return formasTotales;
	    }
	public static void main(String[] args) {
		// Para un objetivo de 3:
        // Monedas disponibles: ilimitadas (ponemos un número grande)
        int[] limites = {10, 10, 10}; 
        int resultado = contarFormasCambio(3, limites); 
        System.out.println("Formas de sumar 3 (1+1+1, 1+2): " + resultado); // Debería dar 2
        
        // Para un objetivo de 3:
        // Límites: una de 1, una de 2, una de 5.
        // Formas: (5)
        int[] limites2 = {1, 1, 1}; 
        resultado = contarFormasCambio(5, limites2); 
        System.out.println("Formas de sumar 5 (con límites 1,1,1): " + resultado); // Debería dar 1 (solo 5)

        // Ejemplo: objetivo = 3, con límite de una moneda de 2
        // Formas: (1+1+1)
        int[] limites3 = {3, 0, 1}; 
        resultado = contarFormasCambio(3, limites3); 
        System.out.println("Formas de sumar 3 (con límite 1 de 2): " + resultado); // Debería dar 1
    }
}
