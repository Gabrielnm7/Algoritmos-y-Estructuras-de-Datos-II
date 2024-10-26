package aed;

import java.util.*;

// Todos los tipos de datos "Comparables" tienen el método compareTo()
// elem1.compareTo(elem2) devuelve un entero. Si es mayor a 0, entonces elem1 > elem2
public class ABB<T extends Comparable<T>> implements Conjunto<T> {
    // Atributos privados del Conjunto
    private Nodo _raiz;
    private int _cardinal;

    private class Nodo {
        // Atributos privados del Nodo
        T valor;
        Nodo izq;
        Nodo der;
        Nodo padre;
        // Constructor del nodo
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
        Nodo actual = this._raiz;
        while (actual != null){
            // Si es menor, voy a la izquierda
            if (elem.compareTo(actual.valor) < 0){
                actual = actual.izq;
            }
            // Si es mayor, voy a la derecha
            else if (elem.compareTo(actual.valor) > 0){
                actual = actual.der;
            }
            // Si lo encuentro 
            else if (elem.compareTo(actual.valor) == 0){
                // 1er Caso: No tiene hijos -> Elimino el nodo
                if (actual.izq == null && actual.der == null){
                    if (actual.padre == null){
                        this._raiz = null;
                        // si soy el de la izquierda
                    } else if (actual.padre.izq == actual){
                        actual.padre.izq = null;
                        // si soy el de la derecha
                    } else {
                        actual.padre.der = null;
                    }
                }
                
                // 2do Caso: Tiene un hijo -> Reemplazo el nodo por su hijo
                else if (actual.izq == null || actual.der == null){
                    Nodo hijo = (actual.izq != null) ? actual.izq : actual.der;
                    if (actual.padre == null){
                        this._raiz = hijo;
                    } else if (actual.padre.izq == actual){
                        actual.padre.izq = hijo;
                    } else {
                        actual.padre.der = hijo;
                    }
                    hijo.padre = actual.padre;
                }

                // 3er Caso: Tiene dos hijos -> Reemplazo por el minimo del subarbol derecho
                else {
                    Nodo minimo = actual.der;
                    while (minimo.izq != null){
                        minimo = minimo.izq;
                    }
                    // Reemplazo el valor del nodo actual por el valor del minimo
                    actual.valor = minimo.valor;
                    // Eliminamos el minimo, tengo 2 casos: si tiene hijo o no
                    // Si tiene hijo, lo subo
                    if (minimo.der != null){
                        if (minimo.padre.izq == minimo){
                            minimo.padre.izq = minimo.der;
                        } else {
                            minimo.padre.der = minimo.der;
                        }
                        minimo.der.padre = minimo.padre;
                    }
                    // Si no tiene hijo, lo elimino
                    else {
                        // Si soy el hijo izquierdo de mi padre
                        if (minimo.padre.izq == minimo){
                            minimo.padre.izq = null;
                        } else { // Si soy el hijo derecho de mi padre
                            minimo.padre.der = null;
                        }
                    }
                }
              
            // Le resto uno al cardinal y salgo del ciclo
            this._cardinal--;
            break;
            }
        }
    }

    public String toString(){
        String msg = "{";
        Nodo actual = nodoMinimo();
        while (actual != null){
            if (actual.valor == minimo()){
                msg += actual.valor;
            } else {
                msg += "," + actual.valor;
            }
            actual = sucesor(actual);
        }
        return msg + "}";
    }

    // Devuelve el nodo con el valor mínimo en el árbol
    private Nodo nodoMinimo() {
        Nodo actual = this._raiz;
        while (actual != null && actual.izq != null) {
            actual = actual.izq;
        }
        return actual;
    }

    // Sacado de la clase
    private Nodo sucesor(Nodo nodo){
        // caso tiene subarbol derecho
        Nodo res;
        if (nodo.der != null){
            res = nodo.der;
            while (res.izq != null){
                res = res.izq;
            }
        } else {
            // caso contrario: no tiene subarbol derecho
            // en ese caso trepo en el arbol en tanto no encuentre un hijo izq -> CONSULTAR ESTO
            res = nodo.padre;
            while (res!=null && nodo == res.der){
                nodo = res;
                res = res.padre;
            }
        }
        return res;
    }


    private class ABB_Iterador implements Iterador<T> {
        private Nodo _actual = nodoMinimo();

        public boolean haySiguiente() {            
            return _actual != null;
        }
        // Devuelve el valor del nodo actual y avanza al siguiente
        public T siguiente() {
            T valor = _actual.valor;
            _actual = sucesor(_actual);
            return valor;
        }
    }

    public Iterador<T> iterador() {
        return new ABB_Iterador();
    }

}
