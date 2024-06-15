/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

/**
 *
 * @author edyne
 */
public class Gestor {

    private int idGestor;
    private String nombre;
    private String telefono;
    private String email;

    // Constructor vacío
    public Gestor() {
    }

    // Constructor con parámetros
    public Gestor(int idGestor, String nombre, String telefono, String email) {
        this.idGestor = idGestor;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
    }

    public int getIdGestor() {
        return idGestor;
    }

    public void setIdGestor(int idGestor) {
        this.idGestor = idGestor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
