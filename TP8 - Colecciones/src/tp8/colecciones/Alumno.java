/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp8.colecciones;

import java.util.TreeSet;
import java.lang.Comparable;

/**
 *
 * @author Hernan57
 */
public class Alumno{

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    private int legajo;
    private String apellido;
    private String nombre;

    public TreeSet<Materia> getMaterias() {
        return materias;
    }
    private TreeSet<Materia> materias = new TreeSet();

    public Alumno(int legajo, String apellido, String nombre) {
        this.legajo = legajo;
        this.apellido = apellido;
        this.nombre = nombre;
    }
    
    public void agregarMateria(Materia m){
            if(materias.contains(m)){
                System.out.println("No ingrese materias repetidas");
            }else{
                materias.add(m);
            }
    }
    public int cantidadDeMaterias(){
        return materias.size();
    }

    
}
