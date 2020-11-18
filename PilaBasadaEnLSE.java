public class PilaBasadaEnLSE{
	
	private ListaSimplementeEnlazada lista;
	private int longitud;

	// pop
	// push

	public PilaBasadaEnLSE(){
		lista = new ListaSimplementeEnlazada();
		longitud = 0;
	}

	public void push(int elemento){
		lista.agregarAlInicio(elemento);
		this.longitud++;
	}

	public Nodo pop(){
		Nodo nodo = lista.getPrimerElemento();
		if (nodo != null){
			longitud--;
			lista.eliminar(0);
		}
	}

}