package clases;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Logica {

	int indice=0;	
	Map<Integer,ObjetoAprendizaje> problematicas = new HashMap<Integer,ObjetoAprendizaje>();
	
	public Logica(){
		inicializaProblematicas();
	}
	
	public void inicializaProblematicas() {
		String nombre="",descripcion="", solucion="";
		ObjetoAprendizaje objetos;
		nombre="Generar Reporte en iReport";
		descripcion+="Se presenta un error al momento de generar un reporte en iReport cuando se usa" +
				" una variable que no existe";
		solucion+="Se debe declarar la variable para que el programa la use, para esto" +
				" seleccionamos en propiedades nueva variable";
		objetos= new ObjetoAprendizaje();
		objetos.setNombre(nombre);
		objetos.setDescripcion(descripcion);
		objetos.setSolucion(solucion);
		
		problematicas.put(0, objetos);
		indice++;
		nombre="NullPointerException.";
		descripcion+="Se presenta un error al momento de usar un objeto en java, arrojando NullPointerException por" +
				" consola";
		solucion+="Se debe verificar si el objeto fue instanciado, este error se presenta porque se intenta" +
				" acceder a un objeto null, la forma de instanciarlo es Objeto miObjeto= new Objeto();";
		objetos= new ObjetoAprendizaje();
		objetos.setNombre(nombre);
		objetos.setDescripcion(descripcion);
		objetos.setSolucion(solucion);
		problematicas.put(1, objetos);
		indice++;
		
	//	System.out.println(problematicas.size());
		
	}

	
	public void iniciaPrograma() {
		int ingreso=0;
		try {
		BufferedReader entrada= new BufferedReader(new InputStreamReader(System.in));
		do {
			presentaAsteriscos();
			System.out.println("\nREPOSITORIO DE CONOCIMIENTO\n");
			System.out.println("1. Consultar Lección ");
			System.out.println("2. Registrar Lección ");
			System.out.println("3. Salir \n");
			
			System.out.println("Seleccione una opción del menú principal\n");
			
			presentaAsteriscos();
			ingreso= Integer.parseInt(entrada.readLine());
			
			mostrarMenu(ingreso);
			//System.out.println("ingreso= "+ingreso);	
		} while (ingreso!=3);
		
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void presentaAsteriscos() {
		System.out.println();
		for (int i = 0; i < 500; i++) {
			System.out.print("*");
		}
		System.out.println();
	}

	public void mostrarMenu(int ingreso) {

		switch (ingreso) {
		case 1: consultarTema();
			break;
		case 2: registrarProblematica();
		break;
		case 3: System.out.println("El sistema Ha finalizado Exitosamente");
		break;
		default: System.out.println("el valor ingresado no corresponde a una opción del menú, intentelo nuevamente\n");
			break;
		}
	}

	public void registrarProblematica() {
		String ingreso="";
		ObjetoAprendizaje miObjetoAprendizaje;
		try {
			BufferedReader entrada= new BufferedReader(new InputStreamReader(System.in));
			presentaAsteriscos();
			System.out.println("\nREGISTRO DE LECCIONES\n");
			miObjetoAprendizaje=new ObjetoAprendizaje();
			System.out.println("Ingrese el Nombre de la Lección");
			ingreso= entrada.readLine();
			miObjetoAprendizaje.setNombre(ingreso);
			System.out.println("Ingrese La descripción de la problematica");
			ingreso= entrada.readLine();
			miObjetoAprendizaje.setDescripcion(ingreso);
			System.out.println("Ingrese la solución encontrada");
			ingreso= entrada.readLine();
			miObjetoAprendizaje.setSolucion(ingreso);
			
			problematicas.put(indice, miObjetoAprendizaje);
			indice++;
			System.out.println();
			System.out.println("El registro se ha efectuado exitosamente!!!\n");
			presentaAsteriscos();
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	public void consultarTema() {
		int ingreso=0;
		try {
		BufferedReader entrada= new BufferedReader(new InputStreamReader(System.in));
		presentaAsteriscos();
		System.out.println("LECCIONES DISPONIBLES\n");
		muestraTemas();
		System.out.println("Seleccione alguna de las siguientes Lecciones");
		ingreso= Integer.parseInt(entrada.readLine());
		presentaAsteriscos();
		realizaBusqueda(ingreso-1);
		
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String realizaBusqueda(int ingreso) {
		ObjetoAprendizaje objeto=new ObjetoAprendizaje();
		objeto=problematicas.get(ingreso);
		String resultado="";
		if (objeto!=null) {
			resultado+="Problematica : \n"+objeto.getNombre()+"\n\n";
			resultado+="Causa : \n"+objeto.getDescripcion()+"\n\n";
			resultado+="Solución : \n"+objeto.getSolucion()+"\n\n";
			System.out.println("Problematica : \n"+objeto.getNombre()+"\n");
			System.out.println("Causa : \n"+objeto.getDescripcion()+"\n");
			System.out.println("Solución : \n"+objeto.getSolucion()+"\n");	
		
		}else{
			resultado="No es una Opción Valida";
			System.out.println("No es una Opción Valida\n");
		}
		return resultado;
	}

	public String muestraTemas() {
		String nombreTema="";
		
		for (int i = 0, j=1; i < problematicas.size(); i++) {
			nombreTema+=j+". "+problematicas.get(i).getNombre()+"\n";
			//System.out.println(j+". "+nombreTema);
			j++;
		}
		System.out.println();
		return nombreTema;
	}
	
}
