/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author Hernan57
 */
public class Alumno {

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getNombreAalumno() {
        return nombreAalumno;
    }

    public void setNombreAlumno(String nombreAalumno) {
        this.nombreAalumno = nombreAalumno;
    }

    public LocalDate getFn_alumno() {
        return fn_alumno;
    }

    public void setFn_alumno(LocalDate fn_alumno) {
        this.fn_alumno = fn_alumno;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Alumno(int idAlumno, String nombreAalumno, LocalDate fn_alumno, boolean activo) {
        this.idAlumno = idAlumno;
        this.nombreAalumno = nombreAalumno;
        this.fn_alumno = fn_alumno;
        this.activo = activo;
    }

    public Alumno(String nombreAalumno, LocalDate fn_alumno, boolean activo) {
        this.nombreAalumno = nombreAalumno;
        this.fn_alumno = fn_alumno;
        this.activo = activo;
    }

    public Alumno() {
    }

   
    
    private int idAlumno;
    private String nombreAalumno;
    private LocalDate fn_alumno;
    private boolean activo;
    
    
       
}
