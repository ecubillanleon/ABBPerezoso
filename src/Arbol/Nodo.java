package Arbol;

public class Nodo {
	private int clave;
	Nodo derecho;
	Nodo izquierdo;

	public Nodo(int num) {
		this.clave = num;
		this.derecho = null;
		this.izquierdo = null;
	}

	public int getClave() {
		return clave;
	}

	public void setClave(int clave) {
		this.clave = clave;
	}

	public Nodo getDerecho() {
		return derecho;
	}

	public void setDerecho(Nodo derecho) {
		this.derecho = derecho;
	}

	public Nodo getIzquierdo() {
		return izquierdo;
	}

	public void setIzquierdo(Nodo izquierdo) {
		this.izquierdo = izquierdo;
	}
}
