
package com.iesiliberis.crudcentroeducativo.entidades;

import java.sql.Date;

/**
 * @author Raul AG
 */
public class Matricula {
    private int idmatricula;
    private int idalumno;
    private int idunidad;
    private String descripcion;
    private Date fMatricula;
    private Date fBaja;

    public Matricula() {
    }

    public Matricula(int idalumno, int idunidad, String descripcion, Date fMatricula, Date fBaja) {
        this.idalumno = idalumno;
        this.idunidad = idunidad;
        this.descripcion = descripcion;
        this.fMatricula = fMatricula;
        this.fBaja = fBaja;
    }

    public int getIdmatricula() {
        return idmatricula;
    }

    public void setIdmatricula(int idmatricula) {
        this.idmatricula = idmatricula;
    }

    public int getIdalumno() {
        return idalumno;
    }

    public void setIdalumno(int idalumno) {
        this.idalumno = idalumno;
    }

    public int getIdunidad() {
        return idunidad;
    }

    public void setIdunidad(int idunidad) {
        this.idunidad = idunidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getfMatricula() {
        return fMatricula;
    }

    public void setfMatricula(Date fMatricula) {
        this.fMatricula = fMatricula;
    }

    public Date getfBaja() {
        return fBaja;
    }

    public void setfBaja(Date fBaja) {
        this.fBaja = fBaja;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.idmatricula;
        hash = 59 * hash + this.idalumno;
        hash = 59 * hash + this.idunidad;
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
        final Matricula other = (Matricula) obj;
        if (this.idmatricula != other.idmatricula) {
            return false;
        }
        if (this.idalumno != other.idalumno) {
            return false;
        }
        return this.idunidad == other.idunidad;
    }

    @Override
    public String toString() {
        return "Matricula{" + "idmatricula=" + idmatricula + ", idalumno=" + idalumno + ", idunidad=" + idunidad + ", descripcion=" + descripcion + ", fMatricula=" + fMatricula + ", fBaja=" + fBaja + '}';
    }
    
}
