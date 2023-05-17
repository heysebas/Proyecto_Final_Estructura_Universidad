/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

/**
 *
 * @author sebas
 */
public class Nodo<T extends Comparable<T>> {

    private Nodo<T> siguiente, anterior;
    private Nodo<T> izquierdo, derecho, padre;
    private T dato;

    public Nodo(Nodo<T> izquierdo, Nodo<T> derecho, Nodo<T> padre, T dato) {
        this.izquierdo = izquierdo;
        this.derecho = derecho;
        this.padre = padre;
        this.dato = dato;
    }

    

    public Nodo(Nodo<T> siguiente, Nodo<T> anterior, T dato) {
        this.siguiente = siguiente;
        this.anterior = anterior;
        this.dato = dato;
    }

    public Nodo(T dato) {
        this.dato = dato;
    }

    public Nodo(Nodo<T> padre, T dato) {
        this.padre = padre;
        this.dato = dato;
    }

    public Nodo<T> getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(Nodo<T> izquierdo) {
        this.izquierdo = izquierdo;
    }

    public Nodo<T> getDerecho() {
        return derecho;
    }

    public void setDerecho(Nodo<T> derecho) {
        this.derecho = derecho;
    }

    public Nodo<T> getPadre() {
        return padre;
    }

    public void setPadre(Nodo<T> padre) {
        this.padre = padre;
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public Nodo<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo<T> siguiente) {
        this.siguiente = siguiente;
    }

    public Nodo<T> getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo<T> anterior) {
        this.anterior = anterior;
    }

    public boolean agregar(T nuevo) {
        if (nuevo.compareTo(dato) < 0) {
            if (izquierdo == null) {
                izquierdo = new Nodo<>(this, nuevo);
                return true;
            } else {
                return izquierdo.agregar(nuevo);
            }
        } else if (nuevo.compareTo(dato) > 0) {
            if (derecho == null) {
                derecho = new Nodo<>(this, nuevo);
                return true;
            } else {
                return derecho.agregar(nuevo);
            }
        }

        return false;
    }

    /**
     * Determina si un Nodo es una Hoja
     *
     * @return true si es Hoja
     */
    public boolean esHoja() {
        return izquierdo == null && derecho == null;
    }

    /**
     *
     * @return
     */
    public boolean tieneUnHijo() {
        return (izquierdo != null && derecho == null) || (derecho != null && izquierdo == null);
    }

}
