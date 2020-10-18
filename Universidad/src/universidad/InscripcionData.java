/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad;

import entidades.Alumno;
import entidades.Inscripcion;
import entidades.Materia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Hernan57
 */
public class InscripcionData {

    public InscripcionData(conexion conexion) {
        this.con = conexion.Conectar();
    }
    private Connection con;
    
    public void guardarInscripcion(Inscripcion inscripcion){
       
       String sql="INSERT INTO inscripcion (idAlumno, idMateria, califiicacion)"+"VALUES (?,?,?);";
       try{
           PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
           ps.setInt(1, inscripcion.getAlumno().getIdAlumno());
           ps.setInt(2,inscripcion.getMateria().getIdMateria());
           ps.setDouble(3, inscripcion.getCalificacion());
           
           ps.executeUpdate();
           ResultSet rs= ps.getGeneratedKeys();
           if(rs.next()){
               inscripcion.setIdInscripcion(rs.getInt(1));
           }else{
                JOptionPane.showMessageDialog(null, "No puedo obtener id");
           }
           ps.close();
           con.close();
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "La materia y/0 alumnos no existen en la base de datos");
        }
   }
    public List<Inscripcion> obtenerInscripciones() {
        List<Inscripcion> inscripciones = new ArrayList<>();
        String sql = "SELECT * FROM inscripcion ;";
        AlumnoData alumnoData=null;
        MateriaData materiaData=null;
        Alumno alumno=null;
        Materia materia=null;
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = ps.executeQuery();
            ps.close();
            while(rs.next()){
                materiaData=new MateriaData();
                alumnoData=new AlumnoData();
                alumnoData.buscarAlumno(rs.getInt("idAlumno"));
                materiaData.buscarMateria(rs.getInt("idMateria"));
                Inscripcion inscripcion=new Inscripcion(); 
                inscripcion.setAlumno(alumno);
                inscripcion.setMateria(materia);
                inscripcion.setCalificacion(rs.getDouble("califiicacion"));
                inscripcion.setIdInscripcion(rs.getInt("idInscripcion"));

            }
            
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener Inscripciones");
        }
        return inscripciones;
    }
 public List<Inscripcion>obtenerInscripcionesXAlumno(int id){
       List<Inscripcion> inscripciones=new ArrayList<>();
       String sql= "SELECT * FROM inscripcion WHERE idAlumno=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            ps.close();
            while(rs.next()){
                Inscripcion inscripcion=new Inscripcion();
                
                inscripcion.setIdInscripcion(rs.getInt("idInscripcion"));
                inscripcion.getAlumno().setIdAlumno(rs.getInt("idAlumno"));
                inscripcion.getMateria().setIdMateria(rs.getInt("idMateria"));
                inscripcion.setCalificacion(rs.getDouble("califiicacion"));
                inscripciones.add(inscripcion);
            }
            
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener Inscripciones por Alumno");
        }
        return inscripciones;
   }

   

}
