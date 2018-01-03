package Arbol;

public class Lista {
	private int cantidad;
	private NodoLista primero;
	private NodoLista ultimo;
	private NodoLista central;

	public Lista() {
		this.primero = null;
		this.ultimo = null;
		this.central = null;
		this.cantidad = 0;
	}

	public NodoLista getPrimero() {
		return primero;
	}

	public void setPrimero(NodoLista primero) {
		this.primero = primero;
	}

	public NodoLista getUltimo() {
		return ultimo;
	}

	public void setUltimo(NodoLista ultimo) {
		this.ultimo = ultimo;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public NodoLista getCentral() {
		return central;
	}

	public void setCentral(NodoLista central) {
		this.central = central;
	}

	public int longitud() {
		int cont = 0;
		NodoLista aux = primero;
		while (aux != null) {
			aux = aux.getSiguiente();
			cont++;
		}
		return cont;
	}

	public boolean vacia() {
		return primero == null;
	}

	public void insertar(int clave) {
		NodoLista nuevo = new NodoLista(clave);
		if (primero == null) {
			primero = nuevo;
			ultimo = nuevo;
			central = nuevo;
			cantidad = 1;
		} else {
			ultimo.setSiguiente(nuevo);
			nuevo.setAnterior(ultimo);
			ultimo = nuevo;
			cantidad++;
		}
	}

	public NodoLista centro() {
		if (cantidad % 2 != 0) {
			NodoLista aux = primero;
			int i = 0, limite = ((cantidad + 1) / 2) - 1;
			aux = primero;
			while (i < limite) {
				aux = aux.getSiguiente();
				i++;
			}
			return central = aux;
		}
		return null;
	}

	public boolean eliminar(int clave) {
		System.out.println("Eliminar " + clave);
		NodoLista aux;
		NodoLista aux2 = primero;
		if (primero != null) {
			if (primero.getClave() == clave) {
				aux = primero;
				primero = primero.getSiguiente();
				aux.setSiguiente(null);
			} else {
				while ((aux2.getSiguiente() != null)
						&& (aux2.getSiguiente().getClave() != clave)) {
					aux2 = aux2.getSiguiente();
				}
				if (aux2.getSiguiente() != null) {
					aux = aux2.getSiguiente();
					aux2.setSiguiente(aux.getSiguiente());
					aux.setSiguiente(null);
				}
			}

			int i = 0, limite = ((longitud() + 1) / 2) - 1;
			aux = primero;
			while (i < limite) {
				aux = aux.getSiguiente();
				i++;
			}
			central = aux;

			return true;
		}
		return false;
	}

	public boolean eliminarEn(int indice) {
		System.out.println("Eliminar en la posicion " + indice);
		if (indice < longitud()) {
			NodoLista aux = primero;
			while (indice > 0) {
				aux = aux.getSiguiente();
				indice--;
			}
			return eliminar(aux.getSiguiente().getClave());
		}
		return false;
	}

	public void imprimir() {
		NodoLista aux = this.getPrimero();
		while (aux != null) {
			System.out.print("\n" + aux.getClave());
			aux = aux.getSiguiente();
		}
		System.out.println();
	}
}
