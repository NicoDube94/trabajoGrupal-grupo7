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
        Materia materia = new Materia();
        Alumno alumno = new Alumno();
        //Materia laboratorio = new Materia("Laboratorio11");
        conexion con=new conexion();
        MateriaData md = new MateriaData(con);
        AlumnoData ad = new AlumnoData(con);
        InscripcionData id = new InscripcionData(con);
        alumno = id.buscarAlumno(8);
        materia = id.buscarMateria(21);
        Inscripcion ins = new Inscripcion(materia,alumno,8);
        
        //Alumno josefa = new Alumno("Josefa",LocalDate.of(1998, 05, 14),true);
        //Alumno jose = new Alumno(1,"Jose",LocalDate.of(1998, 05, 11),true);
        //ad.guardarAlumno(josefa);
        //md.guardarMateria(laboratorio);
        //ad.ActualizarAlumno(josefa);
        //id.obtenerInscripciones();
        //System.out.println("Las inscripciones son: "+id.obtenerInscripciones());
        //System.out.println("Las inscripciones son: "+id.obtenerInscripcionesXAlumno(7));
        id.guardarInscripcion(ins);
        System.out.println("Las inscripciones son: "+materia);
        System.out.println("Las inscripciones son: "+alumno);
        
        
        
    }
    
}
