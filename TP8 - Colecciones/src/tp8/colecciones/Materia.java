/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp8.colecciones;

/**
 *
 * @author Hernan57
 */
public class Materia implements Comparable{

    public Materia(int idMateria, String nombre, int anio) {
        this.idMateria = idMateria;
        this.nombre = nombre;
        this.anio = anio;
    }

    public int getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }
    private int idMateria;
    private String nombre;
    private int anio;
    
    /*@Override
    public boolean equals(Object ob){
        if(!(ob==null) && (ob instanceof Materia)){
            Materia m=(Materia) ob;
            return m.nombre.equals(m.nombre);
        }else{
            return false;
        }
    }
    @Override
    public int hashCode(){
        return nombre.hashCode();
    }*/
    @Override
    public String toString(){
        return nombre;
    }

    @Override
    public int compareTo(Object t) {
        String mat=((Materia) t).nombre;
        return  nombre.compareTo(mat) < 0 ?-1 :(nombre==mat ?0:1);  
    }
}
