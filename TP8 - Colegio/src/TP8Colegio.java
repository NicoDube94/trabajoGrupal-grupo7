/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Hernan57
 */
public class TP8Colegio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Materia ingles = new Materia(1,"Ingles 1",1);
        Materia matematicas = new Materia(1,"Matematicas",1);
        Materia laboratorio = new Materia(1,"Laboratorio 1",1);
        Materia datos = new Materia(1,"Laboratorio 1",1);
        
        Alumno lopez = new Alumno(1001,"López","Martin");
        Alumno martinez = new Alumno(1002,"Martinez","Brenda");
        
        lopez.agregarMateria(ingles);
        lopez.agregarMateria(matematicas);
        lopez.agregarMateria(laboratorio);
        lopez.agregarMateria(datos);
        
        martinez.agregarMateria(ingles);
        martinez.agregarMateria(matematicas);
        martinez.agregarMateria(laboratorio);
        martinez.agregarMateria(laboratorio);
        
        System.out.println("Las materias de lopez son: "+lopez.getMaterias()+" Y las materias de Brenda son: "+martinez.getMaterias());
    }
    
}
