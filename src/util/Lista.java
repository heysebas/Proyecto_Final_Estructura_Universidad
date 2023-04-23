/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;


import java.util.Iterator;

/**
 *
 * @author sebas
 */
public class Lista<T> implements Iterable<T> {
    
    private Nodo<T> primero, ultimo;
	private int tamano;
	
	/**
	 * Constructor de la clase
	 */
	public Lista() {
		primero = ultimo = null;
		tamano = 0;
	}
	
	/**
	 * Verifica si la lista est� vac�a
	 * @return true si est� vac�a
	 */
	public boolean estaVacia() {
		return primero==null && ultimo==null;
	}
	
	/**
	 * Agrega un dato al final de la lista enlazada
	 * @param dato
	 */
	public void agregar(T dato) {
		Nodo<T> nodo = new Nodo<>(dato);
		
		if( estaVacia() ) {
			primero = ultimo = nodo;
		}else {
			Nodo<T> nodo1 = ultimo;
			ultimo.setSiguiente(nodo);
			ultimo = nodo;
			ultimo.setAnterior(nodo1);
		}
		
		tamano++;
	}
	
	/**
	 * Agrega un dato al inicio de la lista enlazada
	 * @param dato
	 */
	public void agregarInicio(T dato) {
		
		Nodo<T> nodo = new Nodo<>(dato);
		
		if( estaVacia() ) {
			primero = ultimo = nodo;
		}else {
			primero.setAnterior(nodo);
			nodo.setSiguiente(primero);
			primero = nodo;
		}
		
		tamano++;		
	}
	
	/**
	 * Imprime en consola la lista enlazada
	 */
	public void imprimirAdelante() {
		
		Nodo<T> aux = primero;
		
		while(aux!=null) {
			System.out.print( aux.getDato()+"\t" );
			aux = aux.getSiguiente();			
		}
		
		System.out.println();
	}
	
	
	/**
	 * Imprime en consola la lista enlazada al reves
	 */
	public void imprimirAtras() {
		
		Nodo<T> aux = ultimo;
		
		while(aux!=null) {
			System.out.print( aux.getDato()+"\t" );
			aux = aux.getAnterior();			
		}
		
		System.out.println();
	}
	
	/**
	 * Borra completamente la Lista
	 */
	public void borrarLista() {
		primero = ultimo = null;
		tamano = 0;
	}
	
	/**
	 * Elimina un elemento de la lista
	 * @param dato dato a eliminar
	 */
	public void eliminar(T dato){
		
		Nodo<T> nodo = primero;
		Nodo<T> previo = null;
		Nodo<T> siguiente = null;
		boolean encontrado = false;
		
		while(nodo!=null) {			
			if( nodo.getDato().equals(dato) ) {
				encontrado = true;
				break;
			}
			previo = nodo;
			nodo = nodo.getSiguiente();
			siguiente=nodo.getSiguiente();
		}
		
		if(encontrado) {
			
			if( previo==null ) {
				primero = siguiente;
			}else{if(siguiente==null) {
				ultimo = previo;
			}else{
				previo.setSiguiente(siguiente);
				siguiente.setAnterior(previo);
			}
			}
			
			nodo = null;
			tamano--;
			
		}else {
			throw new RuntimeException("El elemento no existe");
		}
	}
	
	/**
	 * Elimina el primer elemento de la lista
	 * @return El dato borrado
	 */
	public T eliminarPrimero() {
		
		if( !estaVacia() ) {
			Nodo<T> n = primero;
		    T valor = n.getDato();
			primero = n.getSiguiente();
			primero.setAnterior(null);
			
			if(primero==null) {
				ultimo = null;
			}
			
			tamano--;
			return valor;
		}
		
		throw new RuntimeException("Lista vac�a");		
	}
	
	/**
	 * Elimina el �ltimo elemento de la lista
	 * @return El dato borrado
	 */
	public T eliminarUltimo() {
		
		if( !estaVacia() ) {			
			T valor = ultimo.getDato();
			ultimo =ultimo.getAnterior();
			ultimo.setSiguiente(null);
			
			if(ultimo==null) {
				primero=null;
			}			
			
			tamano--;
			return valor;
		}
		
		throw new RuntimeException("Lista vac�a");
	}	
	
	/**
	 * Agrega un valor en la lista en una posici�n espec�fica
	 * @param indice �ndice donde se va a guardar el dato
	 * @param nuevo El valor a guardar
	 */
	public void agregar(int indice, T nuevo) {

		if(esValido(indice)) {
		
			if(indice==0) {
				agregarInicio(nuevo);
			}else if(indice==tamano-1) {
				agregar(nuevo);
			}else {
				Nodo<T> previo = obtenerNodo(indice-1);
				Nodo<T> posterior = obtenerNodo(indice);
 				Nodo<T> nodo = new Nodo<>(nuevo);
				
				nodo.setSiguiente( posterior);
				nodo.setAnterior(previo);
				previo.setSiguiente(nodo);
				posterior.setAnterior(nodo);
				tamano++;
			}
			
		}
		
	}
	
	/**
	 * Verifica si un dato existe dentro de la lista
	 * @param dato Dato s buscar
	 * @return boolean true si existe
	 */
	public boolean existe(T dato) {
		return buscar(dato)!=null;
	}
	
	/**
	 * Devuelve un nodo que contenga un dato espec�fico
	 * @param dato Dato a buscar
	 * @return Nodo 
	 */
	private Nodo<T> buscar(T dato) {
		Nodo<T> aux = primero;
		
		while(aux!=null) {
			if(aux.getDato().equals(dato)) {
				return aux;
			}
			aux = aux.getSiguiente();			
		}
		
		return null;
	}
	
	/**
	 * Verifica que un �ndice est� en un rango permitido
	 * @param indice �ndice a validar
	 * @return boolean true si es v�lido
	 */
	private boolean esValido(int indice) {		
		if( indice>=0 && indice<tamano ) {
			return true;
		}			
		throw new RuntimeException("�ndice no v�lido");
	}
	
	/**
	 * Devuelve el Nodo de una lista dada su posici�n
	 * @param indice �ndice para obtener el Nodo
	 * @return Nodo objeto
	 */
	private Nodo<T> obtenerNodo(int indice) {
	
		if(indice>=0 && indice<tamano) {
		
			Nodo<T> nodo = primero;
			
			for (int i = 0; i < indice; i++) {
				nodo = nodo.getSiguiente();
			}
		
			return nodo;			
		}
		
		return null;
	}
	
	/**
	 * Devuelve un elemento de la lista dado su �ndice
	 * @param indice �ndice de la lista
	 * @return dato guardado en el �ndice especificado
	 */
	public T obtener(int indice) {
		
		if( esValido(indice) ) {
			Nodo<T> n = obtenerNodo(indice);
			
			if(n!=null) {
				return n.getDato();
			}
		}

		return null;		
	}
	
	/**
	 * Cambia el valor de un nodo dada su posici�n en la lista
	 * @param indice posici�n donde se va a cambiar el dato
	 * @param nuevo nuevo valor por el que se actualizar� el nodo
	 */
	public void modificar(int indice, T nuevo) {
		
		if( esValido(indice) ) {			
			Nodo<T> nodo = obtenerNodo(indice);
			nodo.setDato(nuevo);			
		}
		
	}
	
	/**
	 * Retorna la primera posici�n donde est� guardado el dato
	 * @param dato valor a buscar dentro de la lista
	 * @return primera posici�n del dato
	 */
	public int obtenerPosicion(T dato) {

		int i = 0;
		
		for( Nodo<T> aux = primero ; aux!=null ; aux = aux.getSiguiente() ) {
			if( aux.getDato().equals(dato) ) {
				return i;
			}
			i++;
		}
		
		return -1;
	}
	
	/**
	 * Retorna la �ltima posici�n donde est� guardado el dato
	 * @param dato valor a buscar dentro de la lista
	 * @return �ltima posici�n del dato
	 */
	public int obtenerUltimaPosicion(T dato) {
		
		int i = tamano;
		int j = -1;
		
		for( Nodo<T> aux = ultimo ; aux!=null ; aux = aux.getAnterior() ) {
			if( aux.getDato().equals(dato) ) {
				j=i;
			}
			i--;
		}
		
		return j;
	}	
	
	/**
	 * Devuelve una sublista de una lista
	 * @param inicio �ndice inicial 
	 * @param fin �ndice final
	 * @return una nueva Lista
	 */
	public Lista<T> obtenerSublista(int inicio, int fin) {

		if( esValido(inicio) && esValido(fin) && fin>=inicio ) {
			
			Lista<T> sublista = new Lista<>();
			
			for (int i = inicio; i <= fin; i++) {
				sublista.agregar( obtener(i) );
			}
			
			return sublista;			
		}
		
		return null;
	}	
	
	/**
	 * Concatena una lista al final
	 * @param lista Lista a agregar
	 */
	public void agregarLista(Lista<T> lista) {		

		Lista<T> clon = lista.clone();
		
		ultimo.setSiguiente( clon.getPrimero() );
		ultimo = clon.getUltimo();
		tamano+=clon.getTamano();
	}
	
	/**
	 * Concatena una lista desde una posici�n espec�fica
	 * @param indice posici�n donde se agrega la lista
	 * @param lista Lista a agregar
	 */
	public void agregarLista(int indice, Lista<T> lista) {		
		//TODO completar
	}
	
	@Override
	protected Lista<T> clone() {
		
		Lista<T> clon = new Lista<>();
		
		for (Nodo<T> aux = primero; aux!=null; aux = aux.getSiguiente()) {
			clon.agregar( aux.getDato() );
		}
		
		return clon;		
	}
	
	/**
	 * @return the primero
	 */
	public Nodo<T> getPrimero() {
		return primero;
	}

	/**
	 * @return the ultimo
	 */
	public Nodo<T> getUltimo() {
		return ultimo;
	}

	/**
	 * Devuelve el tama�o de la lista
	 * @return Tama�o de la lista
	 */
	public int getTamano() {
		return tamano;
	}

	@Override
	public Iterator<T> iterator() {
		return new IteradorListaDoble(primero);
	}
	
	/**
	 * Clase que representa el Iterador de una Lista Simple
	 * @author dbonilla
	 *
	 */
	protected class IteradorListaDoble implements java.util.ListIterator<T>{

		private Nodo<T> aux;
		private int posicion;
		
		/**
		 * Constructor de la clase Iterador
		 * @param aux Primer Nodo de la lista
		 */
		public IteradorListaDoble(Nodo<T> aux) {
			this.aux = aux;
			posicion=0;
		}
		
		@Override
		public boolean hasNext() {
			return aux!=null;
		}

		@Override
		public T next() {
			T valor = aux.getDato();
			aux = aux.getSiguiente();
			return valor;
		}

		@Override
		public boolean hasPrevious() {
			T valor=aux.getDato();
			aux=aux.getAnterior();
		     return aux==null;
		}

		@Override
		public T previous() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int nextIndex() {
			// TODO Auto-generated method stub
			return posicion+1;
		}

		@Override
		public int previousIndex() {
			// TODO Auto-generated method stub
			return posicion-1;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void set(T e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void add(T e) {
			agregar(e);
			
		}
		
	}

    
}
