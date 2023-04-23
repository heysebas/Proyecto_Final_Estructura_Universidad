/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

/**
 *
 * @author sebas
 */
public class Pila<T>{

    private Nodo<T> cima;
    private int tamano;

    public boolean estaVacia() {
        return cima == null;
    }

    public void agregar(T dato) {
        Nodo<T> nodo = new Nodo<>(dato);
        nodo.setSiguiente(cima);
        cima = nodo;
    }

    public T quitar() {
        if (estaVacia()) {
            throw new RuntimeException("la pila esta vacia");
        }
        T dato = cima.getDato();
        cima = cima.getSiguiente();
        tamano--;

        return dato;
    }

    public void borraPila() {
        cima = null;
        tamano = 0;
    }

    public T obtenerCima() {
        return cima.getDato();
    }
    
    public void imprimir (){
        Nodo <T> aux = cima;
        while (aux != null){
            System.out.print(aux.getDato()+"\t");
            aux = aux.getSiguiente();
        }
        System.out.println("");
    }
    
}
