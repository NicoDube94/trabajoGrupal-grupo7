/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad;

import entidades.Alumno;
import entidades.Materia;
import java.time.LocalDate;
import java.time.Month;

/**
 *
 * @author Hernan57
 */
public class Universidad {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        conexion con = new conexion();
        Materia laboratorio = new Materia("Laboratorio");
        MateriaData md = new MateriaData(con);
        md.guardarMateria(laboratorio);
        Alumno jose = new Alumno("Jose",LocalDate.of(1998, 05, 14),true);
        AlumnoData ad = new AlumnoData(con);
        ad.guardarAlumno(jose);
        
    }
    
}
