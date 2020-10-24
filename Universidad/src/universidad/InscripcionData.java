/*
 * To change this licens☺e header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad;

import entidades.Alumno;
import entidades.Inscripcion;
import entidades.Materia;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.Date;
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
        
        //List<Inscripcion> inscripcione = new ArrayList<>();
        //inscripcione = obtenerInscripciones();
        //int esta=0;
        //int x=0;
        //for
          
         //if
            
               /*
                   for(x=0;x<inscripcione.size();x++){
                        Inscripcion inscripcion1=inscripcione.get(x);
                        if(inscripcion1.getAlumno().getIdAlumno()== inscripcion.getAlumno().getIdAlumno() && inscripcion1.getMateria().getIdMateria()== inscripcion.getMateria().getIdMateria()){
                            esta++;
                        }
                }
               if(esta==0){*/
               try{
               String sql="INSERT into inscripcion (idAlumno, idMateria, califiicacion) "+"VALUES ( ?, ?, ?);";
               
               PreparedStatement ps = con.prepareStatement(sql, java.sql.Statement.RETURN_GENERATED_KEYS);
               ps.setInt(1, inscripcion.getAlumno().getIdAlumno());
               ps.setInt(2,inscripcion.getMateria().getIdMateria());
               ps.setDouble(3, inscripcion.getCalificacion());

               ps.executeUpdate();
               ResultSet rs= ps.getGeneratedKeys();
                    if(rs.next()){
                        inscripcion.setIdInscripcion(rs.getInt(1));
                    }else {
                     JOptionPane.showMessageDialog ( null , " No puedo obtener id " );
                    }
               ps.close();
               rs.close();
               /*}
                 else{
                   JOptionPane.showMessageDialog(null, "Che el alumno/a ya estan inscriptos");
            }*/
            } catch (SQLException e) {
                
                JOptionPane.showMessageDialog(null, "La materia y/o alumnos no se pueden guardar");
            }                
            

            
        
   }

    public List<Inscripcion> obtenerInscripciones() {
        List<Inscripcion> inscripciones = new ArrayList<>();
        String sql = "SELECT * FROM alumno A, materia M, inscripcion C WHERE A.idAlumno=C.idAlumno AND M.idMateria=C.idMateria;";
        Alumno alumno=null;
        Materia materia=null;
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = ps.executeQuery();
            ps.close();
            while(rs.next()){
                alumno= new Alumno();
                materia=new Materia();
                Inscripcion inscripcion=new Inscripcion();
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setNombreAlumno(rs.getString("nombre"));
                alumno.setFn_alumno(rs.getDate("fn_alumno").toLocalDate());
                alumno.setActivo(rs.getBoolean("activo"));
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                inscripcion.setAlumno(alumno);
                inscripcion.setMateria(materia);
                inscripcion.setCalificacion(rs.getDouble("califiicacion"));
                inscripcion.setIdInscripcion(rs.getInt("idInscripcion"));
                inscripciones.add(inscripcion);
            }
            
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener Inscripciones");
        }
        return inscripciones;
    }
    public List<Inscripcion>obtenerInscripcionesXAlumno(int id){
       List<Inscripcion> inscripciones=new ArrayList<>();
       Alumno alumno=null;
       Materia materia=null;
       String sql= "SELECT * FROM alumno a, inscripcion i WHERE a.idAlumno=? AND i.idAlumno=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            ps.setInt(2, id);
            ResultSet rs = ps.executeQuery();
            ps.close();
            while(rs.next()){
                Inscripcion inscripcion=new Inscripcion();
                alumno= new Alumno();
                materia=new Materia();
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setNombreAlumno(rs.getString("nombre"));
                alumno.setFn_alumno(rs.getDate("fn_alumno").toLocalDate());
                alumno.setActivo(rs.getBoolean("activo"));
                inscripcion.setAlumno(alumno);
                inscripcion.setMateria(materia);
                inscripcion.setCalificacion(rs.getDouble("califiicacion"));
                inscripcion.setIdInscripcion(rs.getInt("idInscripcion"));
                inscripciones.add(inscripcion);
            }
            
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener Inscripciones por Alumno");
        }
        return inscripciones;
   }
    public double obtenerCalificacion(int idAlumno){
           String sql = "SELECT c.idAlumno, c.calificacion FROM inscripcion C WHERE c.idAlumno=? ORDER BY c.calificacion DESC LIMIT 1";
           double calificacion=0;
           int idalumno;
           
           try{
               PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
               ps.setInt(1, idAlumno);
               
               ResultSet rs = ps.executeQuery();
              
                if (rs.next()) {
              idalumno = rs.getInt("idAlumno");
                   calificacion = rs.getDouble("calificacion");
           } else {
                JOptionPane.showMessageDialog ( null , " No puedo obtener id " );
           }
                  
           }
           catch ( SQLException e) {
               
               JOptionPane.showMessageDialog ( null , " Error al obtener calificacion por Alumno " );
           }
           
           return calificacion;
       }
    public void ActualizarInscripcion(int calificacion, int id){
        
        String sql="UPDATE inscripcion SET califiicacion=? WHERE idAlumno=? AND idMateria=?";
        
        
        try{
            PreparedStatement ps = con.prepareStatement(sql, java.sql.Statement.RETURN_GENERATED_KEYS);
            ps.setDouble(1, calificacion);
            ps.setInt(2, id);
            ps.executeUpdate();
            
            ps.close();
            con.close();
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error al actualizar alumno");
        }
    }
    public void borrarInscripcion(int idInscripcion) {
        String sql = "DELETE FROM inscripcion WHERE idInscripcion=?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idInscripcion);
            ps.executeUpdate();
            ps.close();
        }catch(HeadlessException | SQLException e ){
            JOptionPane.showMessageDialog(null, "No se pudo eliminar la inscripcion","Error",JOptionPane.WARNING_MESSAGE);

        }
    }
    public void actualizarInscripcion (Inscripcion inscripcion) {
       String sql = "UPDATE inscripcion SET califiicacion=? WHERE inscripcion.idInscripcion=?";
       try{
           PreparedStatement ps = con.prepareStatement(sql);
           ps.setDouble(1, inscripcion.getCalificacion());
           ps.setInt(2, inscripcion.getIdInscripcion());
           ps.executeUpdate();
           ps.close();
       }catch (HeadlessException | SQLException e ){
           JOptionPane.showMessageDialog(null, "No se pudo actualizar la inscripcion","Error",JOptionPane.WARNING_MESSAGE);
       }
           
       }
    public Alumno buscarAlumno(int idAlumno){
            conexion c=new conexion();
            AlumnoData ad = new AlumnoData(c);
            return ad.buscarAlumno(idAlumno);
   }
   
    public Materia buscarMateria(int idMateria){
            conexion c = new conexion();
            MateriaData md = new MateriaData(c);
            return md.buscarMateria(idMateria);
   }
    

 
}
