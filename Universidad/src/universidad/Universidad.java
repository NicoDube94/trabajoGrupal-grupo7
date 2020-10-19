/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad;

import entidades.Alumno;
import entidades.Inscripcion;
import entidades.Materia;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

/**
 *
 * @author Hernan57
 */
public class Universidad {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Materia laboratorio = new Materia(20,"Laboratorio3");
        conexion con=new conexion();
        //MateriaData md = new MateriaData(con);
        Alumno jose = new Alumno(7,"Josefu",LocalDate.of(1998, 05, 14),true);
        Alumno pepa = new Alumno("PEPA",LocalDate.of(1998, 05, 11),true);
        //AlumnoData ad = new AlumnoData(con);
        //ad.guardarAlumno(jose);
        //md.guardarMateria(laboratorio);
        //ad.ActualizarAlumno(pepa);
        //Inscripcion ins = new Inscripcion(laboratorio,jose,8);
        InscripcionData id = new InscripcionData(con);
        //id.guardarInscripcion(ins);
        //id.obtenerInscripciones();
        //System.out.println("Las inscripciones son: "+id.obtenerInscripciones());
        System.out.println("Las inscripciones son: "+id.obtenerInscripcionesXAlumno(7));
        
        
        
        
    }
    
}
