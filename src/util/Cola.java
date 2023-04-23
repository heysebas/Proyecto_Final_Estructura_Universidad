/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

/**
 *
 * @author sebas
 */
public class Cola<T> {

    private Nodo<T> primero, ultimo;
    private int tamano;

    public Nodo<T> getPrimero() {
        return primero;
    }

    public void setPrimero(Nodo<T> primero) {
        this.primero = primero;
    }

    public Nodo<T> getUltimo() {
        return ultimo;
    }

    public void setUltimo(Nodo<T> ultimo) {
        this.ultimo = ultimo;
    }

    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }

    public boolean estaVacia() {
        return primero == null;
    }

    public void encolar(T dato) {
        Nodo<T> nodo = new Nodo<>(dato);
        if (estaVacia()) {
            primero = ultimo = nodo;
        } else {
            ultimo.setSiguiente(nodo);
            ultimo = nodo;
        }
        tamano++;
    }

    public T desecolar() {
        if (estaVacia()) {
            throw new RuntimeException("La cola esta vacia");
        } else {
            T dato = primero.getDato();
            primero = primero.getSiguiente();
            if (primero == null) {
                ultimo = null;
            }

            tamano--;
            return dato;
        }
    }

    public void borrarcola() {
        primero = ultimo = null;
        tamano = 0;
    }

    public void imprimir() {
        Nodo<T> aux = primero;
        while (aux != null) {
            System.out.print(aux.getDato() + "\t");
            aux = aux.getSiguiente();

        }
        System.out.println();
    }

    @Override
    protected Cola<T> clone() {
        Cola<T> nueva = new Cola<>();
        Nodo<T> aux = primero;

        while (aux != null) {
            nueva.encolar(aux.getDato());
            aux = aux.getSiguiente();
        }
        return nueva;
    }

    /**
     * realizar un metodo que verifique que si una cola enviado por parametro es
     * indetica a la actual
     *
     */
    public boolean esIndentica(Cola<T> cola) {
        if (this.tamano != cola.tamano) {
            throw new RuntimeException("El tamañoo de la cola  es Diferentes");
//            return false;
        }
        Nodo<T> nodoActual = primero;
        Nodo<T> nodoParametro = cola.primero;
        while (nodoActual != null && nodoParametro != null) {
            if (!nodoActual.getDato().equals(nodoParametro.getDato())) {
                throw new RuntimeException("La cola del paramentro no son identicas a la actual");
//            return false;
            }
            nodoActual = nodoActual.getSiguiente();
            nodoParametro = nodoParametro.getSiguiente();
        }
        System.out.println("true");
        return true;
    }

}
