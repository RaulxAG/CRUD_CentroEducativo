
package com.iesiliberis.crudcentroeducativo.entidades;

import java.util.Objects;

/**
 * @author Raul AG
 */
public class Autorizado {
    private int id;
    private String dni;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private Parentesto parentesto;

    public Autorizado() {
    }

    public Autorizado(int id, String dni, String nombre, String apellido1, String apellido2, Parentesto parentesto) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.parentesto = parentesto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public Parentesto getParentesto() {
        return parentesto;
    }

    public void setParentesto(Parentesto parentesto) {
        this.parentesto = parentesto;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + this.id;
        hash = 29 * hash + Objects.hashCode(this.dni);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Autorizado other = (Autorizado) obj;
        if (this.id != other.id) {
            return false;
        }
        return Objects.equals(this.dni, other.dni);
    }

    @Override
    public String toString() {
        return "Autorizado{" + "id=" + id + ", dni=" + dni + ", nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", parentesto=" + parentesto + '}';
    }

}
