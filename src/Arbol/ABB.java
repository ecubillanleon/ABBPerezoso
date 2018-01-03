package Arbol;

public class ABB {
	private Nodo raiz;
	private int cantidad;

	public ABB() {
		this.raiz = null;
	}

	public Nodo getRaiz() {
		return raiz;
	}

	public void setRaiz(Nodo raiz) {
		this.raiz = raiz;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public void insertar(int clave) {
		Nodo nuevo = new Nodo(clave);
		if (raiz == null)
			raiz = nuevo;
		else
			insertar(raiz, nuevo);
	}

	private Nodo insertar(Nodo nodo, Nodo nuevo) {
		if (nodo == null)
			return nuevo;

		if (nuevo.getClave() < nodo.getClave())
			nodo.izquierdo = insertar(nodo.izquierdo, nuevo);
		else
			nodo.derecho = insertar(nodo.derecho, nuevo);

		nodo = verificarDesbalance(nodo);
		return nodo;
	}

	public int cantidadNodos() {
		return cantidadNodos(raiz);
	}

	private int cantidadNodos(Nodo nodo) {
		if (nodo == null)
			return 0;

		return 1 + cantidadNodos(nodo.getIzquierdo())
				+ cantidadNodos(nodo.getDerecho());
	}

	public int altura() {
		return altura(raiz);
	}

	private int altura(Nodo nodo) {
		if (nodo == null)
			return -1;

		int izq = altura(nodo.getIzquierdo());
		int der = altura(nodo.getDerecho());

		if (izq > der)
			return izq + 1;
		else
			return der + 1;
	}

	public Nodo verificarDesbalance(Nodo nuevo) {
		if (altura(nuevo) > 3) {
			if (cantidadNodos(nuevo.getIzquierdo()) >= (cantidadNodos(nuevo.getDerecho()) * 2)) {
				Lista lista = new Lista();
				System.out.println("Balancear Izquierdo. " + nuevo.getClave());
				nuevo = rebalancear(nuevo, lista);
			} else if (cantidadNodos(nuevo.getDerecho()) >= (cantidadNodos(nuevo.getIzquierdo()) * 2)) {
				Lista lista = new Lista();
				System.out.println("Balancear Derecho. " + nuevo.getClave());
				nuevo = rebalancear(nuevo, lista);
			}
		}
		return nuevo;
	}

	public Nodo rebalancear(Nodo nodo, Lista lista) {
		if (nodo != null)
			en_Orden(nodo, lista);
		lista.imprimir();
		nodo = null;

		return null;
	}

	public void en_Orden(Nodo nodo, Lista lista) {

		if (nodo != null) {
			en_Orden(nodo.getIzquierdo(), lista);
			lista.insertar(nodo.getClave());
			en_Orden(nodo.getDerecho(), lista);

		}

	}

	public void tratamiento(Nodo nodo) {
		System.out.println(" " + nodo.getClave());
	}

	public void imprimir() {
		System.out.println("\nAltura del árbol: " + altura());
		System.out.println("Cantidad de nodos: " + cantidadNodos());
	}
}
