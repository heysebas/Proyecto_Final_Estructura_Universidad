/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.util.LinkedList;
import java.util.Queue;
import javax.swing.JPanel;

/**
 *
 * @author sebas
 */
public class ArbolBinario<T extends Comparable<T>> {

    private Nodo raiz;
    int num_nodos;
    int alt;
    private int peso;

    public ArbolBinario() {
        raiz = null;
    }

    public boolean estaVacio() {
        return raiz == null;
    }

    public boolean agregar(T elemento) {
        if (estaVacio()) {
            raiz = new Nodo<>(elemento);
            peso++;
            return true;
        } else if (raiz.agregar(elemento)) {
            peso++;
            return true;
        }
        return false;
    }

    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }

    //Recorrido preorden, recibe el nodo a empezar (raiz) y una linkedlist para ir guardando el recorrido
    public LinkedList preOrden() {
        LinkedList rec = new LinkedList();
        preorden(raiz, rec);
        return rec;
    }

    public void preorden(Nodo aux, LinkedList recorrido) {
        if (aux != null) {
            recorrido.add(aux.getDato());
            preorden(aux.getIzquierdo(), recorrido);
            preorden(aux.getDerecho(), recorrido);
        }
    }

    //Recorrido inorden, recibe el nodo a empezar (raiz) y una linkedlist para ir guardando el recorrido
    public LinkedList inOrden() {
        LinkedList rec = new LinkedList();
        inorden(raiz, rec);
        return rec;
    }

    public void inorden(Nodo aux, LinkedList recorrido) {
        if (aux != null) {
            inorden(aux.getIzquierdo(), recorrido);
            recorrido.add(aux.getDato());
            inorden(aux.getDerecho(), recorrido);
        }
    }

    //Recorrido postorden, recibe el nodo a empezar (raiz) y una linkedlist para ir guardando el recorrido
    public LinkedList postOrden() {
        LinkedList rec = new LinkedList();
        postorden(raiz, rec);
        return rec;
    }

    public void postorden(Nodo aux, LinkedList recorrido) {
        if (aux != null) {
            postorden(aux.getIzquierdo(), recorrido);
            postorden(aux.getDerecho(), recorrido);
            recorrido.add(aux.getDato());
        }
    }

    //Metodo para verificar si hay un nodo en el arbol
    public boolean existe(Nodo<T> n, T elemento) {
        if (n != null) {
            if (elemento.compareTo(n.getDato()) == 0) {
                return true;
            } else if (elemento.compareTo(n.getDato()) < 0) {
                return existe(n.getIzquierdo(), elemento);
            } else if (elemento.compareTo(n.getDato()) > 0) {
                return existe(n.getDerecho(), elemento);
            }
        }
        return false;
    }

    public boolean existe2(T elemento) {
        Nodo<T> aux = raiz;
        while (aux != null) {
            if (elemento.compareTo(aux.getDato()) == 0) {
                return true;
            } else if (elemento.compareTo(aux.getDato()) < 0) {
                return existe(aux.getIzquierdo(), elemento);
            } else if (elemento.compareTo(aux.getDato()) > 0) {
                return existe(aux.getDerecho(), elemento);
            }
        }
        return false;
    }

    private void altura(Nodo aux, int nivel) {
        if (aux != null) {
            altura(aux.getIzquierdo(), nivel + 1);
            alt = nivel;
            altura(aux.getDerecho(), nivel + 1);
        }
    }

    //Devuleve la altura del arbol
    public int getAltura() {
        altura(raiz, 1);
        return alt;
    }

    public JPanel getdibujo() {
        return new ArbolExpresionGrafico(this);
    }

    /**
     * Elimina un elemento del �rbol
     *
     * @param elemento Elemento a borrar
     */
    public boolean eliminar(T elemento) {
        if (estaVacio()) {
            return false;
        } else {
            eliminar(raiz, elemento);
            return true;
        }

    }

    /**
     * Elimina un elemento del �rbol
     *
     * @param n Nodo ra�z
     * @param elemento Elemento a buscar para borrar
     */
    private void eliminar(Nodo<T> n, T elemento) {

        if (n != null) {
            if (elemento.compareTo(n.getDato()) == 0) {
                eliminar(n);
            } else if (elemento.compareTo(n.getDato()) < 0) {
                eliminar(n.getIzquierdo(), elemento);
            } else if (elemento.compareTo(n.getDato()) > 0) {
                eliminar(n.getDerecho(), elemento);
            }
        }

    }

    /**
     * Elimina un Nodo del �rbol
     *
     * @param n Nodo a eliminar
     */
    private void eliminar(Nodo<T> n) {

        Nodo<T> padre = n.getPadre();

        //Caso 1
        if (n.esHoja()) {
            if (padre == null) {
                raiz = null;
            } else if (n.getDato().compareTo(padre.getDato()) > 0) {
                padre.setDerecho(null);
            } else {
                padre.setIzquierdo(null);
            }
            peso--;
            //Caso 2
        } else if (n.tieneUnHijo()) {
            if (padre == null) {
                if (n.getIzquierdo() != null) {
                    raiz = n.getIzquierdo();
                } else {
                    raiz = n.getDerecho();
                }
                raiz.setPadre(null);
            } else if (n.getDato().compareTo(padre.getDato()) > 0) {
                if (n.getIzquierdo() != null) {
                    padre.setDerecho(n.getIzquierdo());
                } else {
                    padre.setDerecho(n.getDerecho());
                }
                padre.getDerecho().setPadre(padre);
            } else {
                if (n.getIzquierdo() != null) {
                    padre.setIzquierdo(n.getIzquierdo());
                } else {
                    padre.setIzquierdo(n.getDerecho());
                }
                padre.getIzquierdo().setPadre(padre);
            }
            peso--;
            //Caso 3
        } else {
            Nodo<T> mayor = obtenerNodoMayor(n.getIzquierdo());
            T aux = mayor.getDato();
            eliminar(mayor);
            n.setDato(aux);
        }

    }

    /**
     * Obtiene el nodo m�s grande de un sub�rbol
     *
     * @param n Nodo Izquierdo del subarbol
     * @return Nodo m�s grande
     */
    public Nodo<T> obtenerNodoMayor(Nodo<T> n) {
        while (n.getDerecho() != null) {
            n = n.getDerecho();
        }
        return n;
    }

    
//////       public void editarDato(T dato) {
//////        raiz = editarNodo(raiz, dato);
//////    }
//////
//////    private Nodo editarNodo(Nodo nodo, T dato) {
//////        if (nodo == null) {
//////            return null;
//////        } else if (dato == nodo.getDato()) {
//////            nodo.getDato = nuevoDato;
//////        } else if (datoAnterior < nodo.dato) {
//////            nodo.izquierdo = editarNodo(nodo.izquierdo, datoAnterior, nuevoDato);
//////        } else {
//////            nodo.derecho = editarNodo(nodo.derecho, datoAnterior, nuevoDato);
//////        }
//////        return nodo;
//////    }
    
////////    public void editarDato(int datoAnterior, int nuevoDato) {
////////        raiz = editarNodo(raiz, datoAnterior, nuevoDato);
////////    }
////////
////////    private Nodo editarNodo(Nodo nodo, int datoAnterior, int nuevoDato) {
////////        if (nodo == null) {
////////            return null;
////////        } else if (datoAnterior == nodo.dato) {
////////            nodo.dato = nuevoDato;
////////        } else if (datoAnterior < nodo.dato) {
////////            nodo.izquierdo = editarNodo(nodo.izquierdo, datoAnterior, nuevoDato);
////////        } else {
////////            nodo.derecho = editarNodo(nodo.derecho, datoAnterior, nuevoDato);
////////        }
////////        return nodo;
////////    }
}
