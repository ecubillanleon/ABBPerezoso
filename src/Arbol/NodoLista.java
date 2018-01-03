package Arbol;

public class NodoLista {
	private int clave;
	private NodoLista siguiente;
	private NodoLista anterior;

	public NodoLista(int clave) {
		this.clave = clave;
		this.siguiente = null;
		this.anterior = null;
	}

	public int getClave() {
		return clave;
	}

	public void setClave(int clave) {
		this.clave = clave;
	}

	public NodoLista getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(NodoLista siguiente) {
		this.siguiente = siguiente;
	}

	public NodoLista getAnterior() {
		return anterior;
	}

	public void setAnterior(NodoLista anterior) {
		this.anterior = anterior;
	}
}
