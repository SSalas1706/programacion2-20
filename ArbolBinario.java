public class ArbolBinario{
	
	// Nodo del árbol
	// Elemento
	// Dos hijos (referencias a un nodo)
	// Referencia a la raíz
	private Nodo raiz;

	private class Nodo{
		private Nodo izq;
		private Nodo der;
		private int elemento;

		public Nodo(int elemento){
			this.elemento = elemento;
			this.izq = this.der = null;
		}

		public String toString(){
			return  " "+ this.elemento;
		}
	}

	public Nodo insertar(int elemento){
		return insertar(elemento, this.raiz);
	}

	private Nodo insertar(int elemento, Nodo nodo){
		Nodo nodoNuevo = nodo;
		if(nodo == null){
			// caso trivial
			nodoNuevo = new Nodo(elemento);
			if(raiz == null){
				this.raiz = nodoNuevo;
			}
		}
		else{
			if(nodo.elemento >= elemento){
				// Vamos a insertar en la rama izquierda
				nodo.izq = this.insertar(elemento, nodo.izq);
			}
			else{
				// Vamos a insertar en la rama derecha
				nodo.der = this.insertar(elemento, nodo.der);
			}
		}
		return nodoNuevo;
	}

	public void imprimir(){
		imprimir(this.raiz);
	}

	// preorden
	// inorden
	// postorden
	private void imprimir(Nodo nodo){
		if (nodo != null){
			imprimir(nodo.izq);
			System.out.println(nodo);
			imprimir(nodo.der);
		}
	}

	public int getLength(){
		return getLength(this.raiz, 0);
	}

	private int getLength(Nodo nodo, int contador){
		if (nodo != null){
			System.out.println(nodo);
			contador = getLength(nodo.izq, contador);
			System.out.println(nodo);
			contador = getLength(nodo.der, contador+1);
		}
		return contador;
	}

	public int getProfundidad(){
		return this.getProfundidad(this.raiz);
	}

	private int getProfundidad(Nodo nodo){
		int profundidadIzq = 0;
		int profundidadDer = 0;
		if (nodo != null){
			if (nodo.izq != null){
				profundidadIzq = getProfundidad(nodo.izq);
			}
			if (nodo.der != null){
				profundidadDer = getProfundidad(nodo.der);
			}
		}
		return (profundidadIzq > profundidadDer ? profundidadIzq : profundidadDer) + 1;
	}

	public static void main (String args [] ){
		ArbolBinario ab = new ArbolBinario();
		ab.insertar(25);
		ab.insertar(18);
		ab.insertar(23);
		ab.insertar(15);
		ab.insertar(22);
		ab.insertar(70);
		ab.insertar(50);
		ab.insertar(85);
		ab.insertar(6);
		ab.insertar(8);

		
		ab.imprimir();

		System.out.println("Length");
		System.out.println(ab.getLength());

		System.out.println(ab.getProfundidad());
	}


}