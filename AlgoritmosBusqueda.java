import java.time.Instant;
import java.time.Duration;

public class AlgoritmosBusqueda {
	
	public int busquedaSecuencial (int [] arreglo, int valor){
		int posicion = -1;
		int contador = 0;
		while(contador < arreglo.length && posicion == -1){
			if (arreglo[contador] == valor){
				posicion = contador;
			}
			contador++;
		}
		return posicion;
	}

	public int busquedaBinaria(int[] arreglo, int valor){
		return busquedaBinaria(arreglo, valor, 0, arreglo.length);
	}

	private int busquedaBinaria(int [] arreglo, int valor, int limInf, int limSup){
		int resultado = -1;
		int celda = (limInf + limSup)/2;
		if (limInf <= limSup && celda >= 0 && celda < arreglo.length){
			if(arreglo[celda] == valor){
				// Caso trivial Encontramos el valor
				resultado = celda;
			}
			else if (arreglo[celda] > valor){
				// Casos recursivos
				resultado = busquedaBinaria(arreglo, valor, limInf, celda-1);
			}
			else{
				resultado = busquedaBinaria(arreglo, valor, celda+1, limSup);
			}
		}
		return resultado;
	}




	public static void main (String [] args){
		AlgoritmosBusqueda busqueda = new AlgoritmosBusqueda();
		int [] arreglo = {5,10,20,1,6,7,8,1,90};

		int indice = busqueda.busquedaSecuencial(arreglo, 1);
		System.out.println(indice);

		int [] arreglo2 = {1,2,4,6,8,9,10,15,20,30,90};
		indice = busqueda.busquedaBinaria(arreglo2,30);
		System.out.println(indice);		



		int [] arreglo3 = new int [1000000000];
		for (int i = 0 ; i < arreglo3.length ; i++){
			arreglo3[i] = 2*i;
		}
		
		Instant tiempoInicial = Instant.now();
		indice = busqueda.busquedaSecuencial(arreglo3, 1);
		Instant tiempoFinal = Instant.now();
		long tiempoTranscurrido = Duration.between(tiempoInicial, tiempoFinal).toMillis();
		System.out.println("Tiempo busqueda secuencial: " + tiempoTranscurrido/1000.0);


		tiempoInicial = Instant.now();
		indice = busqueda.busquedaBinaria(arreglo3,1);
		tiempoFinal = Instant.now();
		tiempoTranscurrido = Duration.between(tiempoInicial, tiempoFinal).toMillis();
		System.out.println("Tiempo busqueda binaria: " + tiempoTranscurrido/1000.0);

	}
}