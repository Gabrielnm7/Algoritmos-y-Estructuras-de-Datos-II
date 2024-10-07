package aed;

import java.util.*;

public class ListaEnlazada<T> implements Secuencia<T> {
    // Completar atributos privados
    private Nodo primero;
    private int size;

    private class Nodo {
        // Completar
        T valor;
        Nodo anterior;
        Nodo siguiente;

        Nodo(T v) { valor = v; }

    }

    public ListaEnlazada() {
        primero = null;
        size = 0;
    }

    public int longitud() {
        return size;

    }

    public void agregarAdelante(T elem) {
        Nodo nuevo = new Nodo(elem);
        if (primero == null){
            primero = nuevo;
            nuevo.anterior = null;
            nuevo.siguiente = null;
        }
        else {
            nuevo.siguiente = primero;
            primero.anterior = nuevo;
            primero = nuevo;
        }
        size++;
    }

    public void agregarAtras(T elem) {
        Nodo nuevo = new Nodo(elem);
        if (primero == null){
            primero = nuevo;
            nuevo.anterior = null;
            nuevo.siguiente = null;
        }
        else {
            Nodo actual = primero;
            while (actual.siguiente != null){
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
            nuevo.anterior = actual;
            nuevo.siguiente = null;
        }
        size++;
    }

    public T obtener(int i) {
        int n = 0;
        Nodo actual = primero;
        while (n < i){
            actual = actual.siguiente;
            n = n + 1;
        }
        return actual.valor;
    }

    public void eliminar(int i) {
        Nodo actual = primero;
        Nodo prev = primero.anterior;
        Nodo next = primero.siguiente;
        for (int j = 0; j < i; j++){
            prev = actual;
            actual = next;
            next = actual.siguiente;
        }
        if (i == 0){
            primero = next;
            if (next != null){ // si no es null, entonces el anterior de next debe ser null
                next.anterior = null;
                size--; 
            }
            else {
                size = 0;
            }
        }
        else if (i == longitud() - 1){
            prev.siguiente = null;
            size--;
        }
        else {
            prev.siguiente = actual.siguiente;
            next.anterior = actual.anterior;
            size--;
        }
    }

    public void modificarPosicion(int indice, T elem) {
        Nodo actual = primero;
        for (int i = 0; i < indice; i++){
            actual = actual.siguiente;
        }
        actual.valor = elem;
    }

    public ListaEnlazada(ListaEnlazada<T> lista) {
        if (lista.primero == null){
            this.primero = null;
            this.size = 0;
        }
        else {
            // Hay que evitar aliasing
            Nodo actual = lista.primero;
            Nodo nuevo = new Nodo(actual.valor);
            this.primero = nuevo;
            this.size = 1;
            while (actual.siguiente != null){
                actual = actual.siguiente;
                Nodo actualNuevo = new Nodo(actual.valor);
                nuevo.siguiente = actualNuevo;
                actualNuevo.anterior = nuevo;
                nuevo = actualNuevo;
                size++;
            }
        }

    }
    
    @Override
    public String toString() {
        if (primero == null){
            return "[]";
        }
        String mensaje = "[";
        Nodo actual = primero;
        while (actual.siguiente != null){
            mensaje = mensaje + actual.valor + ", ";
            actual = actual.siguiente;
        }
        mensaje = mensaje + actual.valor + "]";
        return mensaje;
    }

    private class ListaIterador implements Iterador<T> {
        int dedito;
        ListaIterador() {
            dedito = 0;
        }

        public boolean haySiguiente() {
            return dedito < size;
        }
        
        public boolean hayAnterior() {
	        return (dedito > 0 && dedito <= size);
        }

        public T siguiente() {
            T valor = obtener(dedito);
            dedito++;
            return valor;
        }
        

        public T anterior() {
            dedito--;
            T valor = obtener(dedito);
            return valor;
        }
    }

    public Iterador<T> iterador() {
        return new ListaIterador();
    }

}
