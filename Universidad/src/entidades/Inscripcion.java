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

    public Materia getMateria() {
        return idMateria;
    }

    public void setMateria(Materia idMateria) {
        this.idMateria = idMateria;
    }

    public Alumno getAlumno() {
        return idAlumno;
    }

    public void setAlumno(Alumno idAlumno) {
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
    public Inscripcion(){
        
    }

    public Inscripcion(Materia idMateria, Alumno idAlumno) {
        this.idMateria = idMateria;
        this.idAlumno = idAlumno;
    }

    @Override
    public String toString() {
        return "La inscripcion es: " + idInscripcion;
    }
    private Materia idMateria;
    private Alumno idAlumno;
    private double calificacion;
    private int idInscripcion;
}
