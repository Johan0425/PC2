/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.io.Serializable;

/**
 *
 * @author joanp
 *
 * @param <S> tipo de dato generico
 */
public class LSE<S> implements Serializable {

    Nodo<S> primero;
    int size;

    public LSE() {

        this.primero = null;
        this.size = 0;
    }

    public int size() {
        return size;
    }

    // metodo creado en clase
    public void addDato(S dato) {
        Nodo<S> nuevo = new Nodo<>(dato);
        if (primero == null) {
            primero = nuevo;
        } else {
            Nodo<S> aux = primero;
            while (aux.nodoSiguiente != null) {
                aux = aux.nodoSiguiente;

            }
            aux.nodoSiguiente = nuevo;

        }
        size++;
    }

    public void add(S dato, int index) {
        verificarIndice(index);
        Nodo<S> nuevo = new Nodo<>(dato);
        if (primero == null || index >= size) {
            if (primero == null) {
                primero = nuevo;
            } else {
                Nodo<S> aux = primero;
                while (aux.nodoSiguiente != null) {
                    aux = aux.nodoSiguiente;

                }
                aux.nodoSiguiente = nuevo;
            }

        } else if (index == 0) {
            nuevo.nodoSiguiente = primero;
            primero = nuevo;
        } else {
            Nodo<S> aux = primero;
            int contador = 0;
            while (contador < index - 1) {
                aux = aux.nodoSiguiente;
                contador++;

            }
            nuevo.nodoSiguiente = aux.nodoSiguiente;
            aux.nodoSiguiente = nuevo;
        }
        size++;

    }

    public S get(int index) {

        if (index == 0) {
            return this.primero.dato;

        } else {
            Nodo<S> aux = primero;
            int contador = 0;
            while (contador < index) {
                aux = aux.nodoSiguiente;
                contador++;

            }
            return aux.dato;
        }
    }

    public void remove(int index) {
        verificarIndice(index);
        if (primero != null) {
            if (index == 0) {
                primero = primero.nodoSiguiente;

            } else {
                Nodo<S> aux = primero;
                int contador = 0;
                while (contador < index - 1 && aux.nodoSiguiente != null) {
                    aux = aux.nodoSiguiente;
                    contador++;

                }
                if (aux.nodoSiguiente != null) {
                    aux.nodoSiguiente = aux.nodoSiguiente.nodoSiguiente;

                }

            }
            size--;

        }
    }

    public void clear() {
        int index = size - 1;
        while (index >= 0) {
            remove(index);
            index--;
        }
    }

    public void verificarIndice(int index) throws IndexOutOfBoundsException {

        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("para el indice: " + index);
        }
    }

    public void edit(S datoNuevo, int index) throws Exception {
        if (primero == null) {
            throw new Exception("La lista está vacía");
        }

        int contador = 0;
        Nodo<S> actual = primero;
        boolean encontrado = false;

        while (actual != null) {
            if (contador == index) {
                actual.dato = datoNuevo;
                encontrado = true;
                break;
            }

            actual = actual.nodoSiguiente;
            contador++;
        }

        if (!encontrado) {
            throw new Exception("El elemento no está en la lista");
        }
    }

}
