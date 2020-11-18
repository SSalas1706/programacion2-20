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

	public void borrar(int elemento){
		this.borrar(elemento, this.raiz);
	}

	private Nodo borrar(int elemento, Nodo nodo){
		Nodo retorno = null;
		if(nodo != null){
			if (nodo.elemento > elemento){
				nodo.izq = borrar(elemento, nodo.izq);
			}
			else if(nodo.elemento < elemento) {
				nodo.der = borrar(elemento, nodo.der);
			}
			else{
				// encontramos el nodo! :D 
				if (nodo.izq == null){
					nodo = nodo.der;
				}
				else if (nodo.der == null){
					nodo = nodo.izq;
				}
				else{
					nodo.elemento = valorMenor(nodo.der);
					nodo.der = borrar(nodo.elemento, nodo.der);
					retorno = nodo;
				}
			}
			retorno = nodo;
		}
		return retorno;	
	}

	public int valorMenor(Nodo nodo){
		int menor = nodo.elemento;
		while(nodo.izq != null){
			menor = nodo.izq.elemento;
			nodo = nodo.izq;
		}
		return menor;
	}

	public Nodo buscar(int elemento){
		return buscar(elemento, this.raiz);
	}

	private Nodo buscar (int elemento, Nodo nodo){
		Nodo retorno = null;
		if (nodo != null){
			if(elemento == nodo.elemento){
				retorno = nodo;
			}
			else if (nodo.elemento > elemento){
				retorno = buscar(elemento, nodo.izq);
			}
			else{
				retorno = buscar(elemento, nodo.der);
			}
		}
		return retorno;
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
		System.out.println("Profundidad");
		System.out.println(ab.getProfundidad());

		System.out.println("Borrado 18");
		ab.borrar(18);
		ab.imprimir();

	}


}