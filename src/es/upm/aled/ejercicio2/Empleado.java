package es.upm.aled.ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Empleado {
	
	private String nombre;
	 private double salario;
	 private List<Empleado> subordinados; // Lista de empleados a su cargo
	 
	 public Empleado(String nombre, double salario) { 
		 this.nombre = nombre;
		 this.salario = salario;
		 this.subordinados = new ArrayList<Empleado>();
	 }
	 
	 public double getSalario() { 
		 return this.salario; 
		 }
	 
	 public List<Empleado> getSubordinados() { 
		 return this.subordinados; 
		 }
	 
	 /* 
	  *  Implemente el método recursivo presupuestoEquipo: Este método debe calcular el coste
 total de salarios de un equipo, incluyendo el salario del Empleado pasado como parámetro y el
 de todos sus subordinados (directos e indirectos)
	  */
	 public static double presupuestoEquipo(Empleado jefe) {
		 // Obtenemos el salario del jefe:
		 double costeTotal = jefe.getSalario();
		 
		 // A partir de este salario lo repartimos a todos los subordinados restantes (paso recursivo)
		 for (Empleado subordinado : jefe.getSubordinados()) {
			 costeTotal += presupuestoEquipo(subordinado);
		 }
		 // Caso base: Se retorna la suma del salario del jefe más los salarios de todos sus equipos.
		 return costeTotal;
	 }
}
