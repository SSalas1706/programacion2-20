public class Cola {
	private Nodo nodoInicial;
	private Nodo nodoFinal;
	private int elementosMaximos;
	private int cantidadElementosActuales;

	private class Nodo{
		private Nodo siguiente;
		private int elemento;

		public Nodo(int elemento){
			this.elemento = elemento;
			this.siguiente = null;
		}

		public String toString(){
			return this.elemento + " ";
		}
	}

	public Cola (int capacidadMaxima){
		this.elementosMaximos = capacidadMaxima;
		this.nodoInicial = this.nodoFinal = null;
		cantidadElementosActuales = 0;
	}

	public int getCapacidad(){
		return elementosMaximos;
	}

	public boolean agregar(int elemento){
		boolean agregado = false;
		if (cantidadElementosActuales < elementosMaximos){
			Nodo nuevo = new Nodo(elemento);
			if (nodoInicial == nodoFinal && nodoFinal == null){
				this.nodoInicial = nuevo;
			}
			else{
				this.nodoFinal.siguiente = nuevo;
			}
			this.nodoFinal = nuevo;
			cantidadElementosActuales++;
			agregado = true;
		}
		return agregado;
	}

	// Retorna el elemento del nodo
	public int eliminar() throws ColaVaciaException{
		int valor = 0;
		if(this.nodoInicial != null){
			valor = this.nodoInicial.elemento;
			this.nodoInicial = nodoInicial.siguiente;
			if(nodoInicial == null)
				this.nodoFinal = this.nodoInicial;
			cantidadElementosActuales--;
		}
		else{
			throw new ColaVaciaException("La cola se encuentra vacía");
		}
		return valor;
	}

	public int primerElemento() throws ColaVaciaException{
		int valor = 0;
		if(!estaVacia()){
			valor = this.nodoInicial.elemento;
		}
		else{
			throw new ColaVaciaException("La cola se encuentra vacía");
		}
		return valor;
	}

	public boolean estaVacia(){
		return cantidadElementosActuales == 0;
	}

	public String toString(){
		String contenido = "Cantidad de elementos: " + this.cantidadElementosActuales + "\n";
		Nodo actual = this.nodoInicial;
		while(actual != null){
			contenido += (actual.elemento+" ");
			actual = actual.siguiente;
		}
		return contenido;
	}


	public static void main (String args[]){
		Cola cola = new Cola(10);
		cola.agregar(6);
		System.out.println(cola);
		cola.agregar(7);
		System.out.println(cola);
		cola.agregar(1);
		System.out.println(cola);
		try{
			int elemento = cola.eliminar();
			System.out.println("Elemento eliminado: "+ elemento);	
			System.out.println("Primer Elemento: "+ cola.primerElemento());	
		
		}
		catch(ColaVaciaException e){
			System.out.println("Ocurrió un error al eliminar el elemento");
		}
		System.out.println(cola);
	}



}