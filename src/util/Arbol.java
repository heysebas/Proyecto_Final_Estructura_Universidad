/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

/**
 *
 * @author sebas
 */
public class Arbol {
    
    
        
    Nodo raiz;
    
    public  Arbol(){
        raiz = null;
    }
    
    public void insertar(int i, Object fruta){
        Nodo n = new Nodo(i);
        n.contenido = fruta;
        
        if (raiz== null) {
            raiz = n;
        }else{
            Nodo aux = raiz;
            while (aux != null) {
                n.padre = aux;
                if (n.llave >= aux.llave) {
                    aux = aux.derecha;
                }else{
                    aux = aux.izquierda;
                }
            }
            if (n.llave < n.padre.llave) {
                n.padre.izquierda = n;
            }
            else{
                n.padre.derecha = n;
            }
        }
    }
    
    
    public void recorrer(Nodo n){
        if (n != null) {
            recorrer(n.izquierda);
            System.out.println("Indice "+ n.llave + " fruta "+ n.contenido);
            recorrer(n.derecha);
        }
    }
    
    
    private class Nodo{
        public Nodo padre;
        public Nodo derecha;
        public Nodo izquierda;
        public int llave;
        public Object contenido;
        
        public Nodo (int indice){
            llave = indice;
            derecha = null;
            izquierda = null;
            padre = null;
            contenido = null;
        }
    }
//    
//    
    
    
    
    
    

////////    private int dato;
////////    private Arbol hijoIzquierdo;
////////    private Arbol hijoDerecho;
////////    
////////    
////////     public Arbol(int dato) {
////////        this.dato = dato;
////////        this.hijoIzquierdo = null;
////////        this.hijoDerecho = null;
////////    }
////////
////////
////////    public int getDato() {
////////        return dato;
////////    }
////////
////////    public void setDato(int dato) {
////////        this.dato = dato;
////////    }
////////
////////    public Arbol getHijoIzquierdo() {
////////        return hijoIzquierdo;
////////    }
////////
////////    public void setHijoIzquierdo(Arbol hijoIzquierdo) {
////////        this.hijoIzquierdo = hijoIzquierdo;
////////    }
////////
////////    public Arbol getHijoDerecho() {
////////        return hijoDerecho;
////////    }
////////
////////    public void setHijoDerecho(Arbol hijoDerecho) {
////////        this.hijoDerecho = hijoDerecho;
////////    }
////////    
    
    
    
         
     


}
