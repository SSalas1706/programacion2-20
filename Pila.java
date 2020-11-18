// (Cola) FIFO -> First in First out (el primero que llega, es el primero que se atiende)
// (LIFO) LIFO -> Last in First out (el último que llega es el primero que se atiende)
public class Pila{
	
	//Agregar -> push (elemento)
	//Eliminar -> pop -> Nodo
	private Nodo primero;
	private int longitud;

	private class Nodo{
		private int valor;
		private Nodo siguiente;

		public Nodo(int valor){
			this.valor = valor;
			this.siguiente = null;
		}

		public String toString(){
			return "Nodo: " + this.valor;
		}
	}

	public Pila(){
		primero = null;
		longitud = 0;
	}

	public void push(int elemento){ // Agregar
		Nodo nuevo = new Nodo(elemento);
		nuevo.siguiente = primero;
		primero = nuevo;
		longitud++;
	}

	public Nodo pop(){
		Nodo nodoAEliminar = null;
		if (this.longitud > 0){
			// Eliminar el primer nodo
			nodoAEliminar = this.primero;
			this.primero = this.primero.siguiente;
			this.nodoAEliminar.siguiente = null;
			// decrementar la longitud en 1
			this.longitud--;
		}
		return nodoAEliminar;
	}

	public int getLongitud(){
		return this.longitud;
	}

}