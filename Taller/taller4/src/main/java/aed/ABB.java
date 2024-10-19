package aed;

import java.util.*;

// Todos los tipos de datos "Comparables" tienen el método compareTo()
// elem1.compareTo(elem2) devuelve un entero. Si es mayor a 0, entonces elem1 > elem2
public class ABB<T extends Comparable<T>> implements Conjunto<T> {
    // Agregar atributos privados del Conjunto
    private Nodo _raiz;
    private int _cardinal;

    private class Nodo {
        // Agregar atributos privados del Nodo
        T valor;
        Nodo izq;
        Nodo der;
        Nodo padre;
        // Crear Constructor del nodo
        Nodo(T valor) {
            this.valor = valor;
            this.izq = null;
            this.der = null;
            this.padre = null;
        }
    }

    public ABB() {
        this._raiz = null;
        this._cardinal = 0;
    }

    public int cardinal() {
        return this._cardinal;
    }

    public T minimo(){
        Nodo actual = this._raiz;
        while (actual.izq != null) {
            actual = actual.izq;
        }
        return actual.valor;
    }

    public T maximo(){
        Nodo actual = this._raiz;
        while (actual.der != null) {
            actual = actual.der;
        }
        return actual.valor;
    }

    public void insertar(T elem){
        Nodo nuevo = new Nodo(elem);
        if (this._raiz == null) {
            this._raiz = nuevo;
            this._cardinal++;
        } else {
            Nodo actual = this._raiz;
            while (true) {
                if (elem.compareTo(actual.valor) < 0) {
                    if (actual.izq == null) { // Si no hay nodo izquierdo
                        actual.izq = nuevo;
                        nuevo.padre = actual;
                        this._cardinal++; // Le sumo uno al cardinal
                        break;
                    } else {
                        actual = actual.izq;
                    }
                } else if (elem.compareTo(actual.valor) > 0) {
                    if (actual.der == null) { // Si no hay nodo derecho
                        actual.der = nuevo;
                        nuevo.padre = actual;
                        this._cardinal++; // Le sumo uno al cardinal
                        break;
                    } else {
                        actual = actual.der;
                    }
                } else {
                    break; // No se permiten elementos repetidos
                }
            }
        }
    }

    public boolean pertenece(T elem){
        Nodo actual = this._raiz;
        while (actual != null) {
            if (elem.compareTo(actual.valor) < 0) {
                actual = actual.izq;} 
            else if (elem.compareTo(actual.valor) > 0) {
                actual = actual.der;} 
            else {
                return true;
            }
        }
        return false; // Si no se encontro el elemento
    }

    public void eliminar(T elem){
        throw new UnsupportedOperationException("No implementada aun");
    }

    public String toString(){
        throw new UnsupportedOperationException("No implementada aun");
    }

    private class ABB_Iterador implements Iterador<T> {
        private Nodo _actual;

        public boolean haySiguiente() {            
            throw new UnsupportedOperationException("No implementada aun");
        }
    
        public T siguiente() {
            throw new UnsupportedOperationException("No implementada aun");
        }
    }

    public Iterador<T> iterador() {
        return new ABB_Iterador();
    }

}
