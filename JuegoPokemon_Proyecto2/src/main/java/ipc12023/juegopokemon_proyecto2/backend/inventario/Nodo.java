/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipc12023.juegopokemon_proyecto2.backend.inventario;

import java.io.Serializable;

/**
 *
 * @author Personal
 */
public class Nodo <T> implements Serializable{
    private static final long serialVersionUID = 050220032147L;
     private T contenido;
     private Nodo siguiente;
     private Nodo anterior;
//creo el nodo
    public Nodo(T contenido) {
        this.contenido = contenido;
    }
//obtener contenido desde afuerta
    public T getContenido() {
        return contenido;
    }
// hacia donde apunta el ultimo nodo ##
    public Nodo getSiguiente() {
        return siguiente;
    }
//
    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
    
    public void setAnterior(Nodo anterior){
        this.anterior = anterior;
    }
    
    public Nodo getAnterior(){
        return anterior;
    }
}
