/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author Hernan57
 */
public class Inscripcion {

    public Materia getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(Materia idMateria) {
        this.idMateria = idMateria;
    }

    public Alumno getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Alumno idAlumno) {
        this.idAlumno = idAlumno;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    public int getIdInscripcion() {
        return idInscripcion;
    }

    public void setIdInscripcion(int idInscripcion) {
        this.idInscripcion = idInscripcion;
    }

    public Inscripcion(Materia idMateria, Alumno idAlumno, double calificacion, int idInscripcion) {
        this.idMateria = idMateria;
        this.idAlumno = idAlumno;
        this.calificacion = calificacion;
        this.idInscripcion = idInscripcion;
    }

    public Inscripcion(Materia idMateria, Alumno idAlumno, double calificacion) {
        this.idMateria = idMateria;
        this.idAlumno = idAlumno;
        this.calificacion = calificacion;
    }
    private Materia idMateria;
    private Alumno idAlumno;
    private double calificacion;
    private int idInscripcion;
}
