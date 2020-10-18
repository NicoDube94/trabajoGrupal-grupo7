/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad;

import com.mysql.jdbc.Statement;
import entidades.Materia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JOptionPane;

/**
 *
 * @author Hernan57
 */
public class MateriaData {

    public MateriaData(conexion con) {
        this.con = con.Conectar();
    }
    public MateriaData() {
        
    }
    private Connection con;
    
    
    
    public void guardarMateria(Materia materia){
        String sql="INSERT into materia (nombre) "
                + "VALUES(?);";
        
        try{
            PreparedStatement ps = con.prepareStatement(sql, java.sql.Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, materia.getNombre());
            ps.executeUpdate();
            ResultSet rs= ps.getGeneratedKeys();
            ps.close();
            if(rs.next()){
                materia.setIdMateria(rs.getInt(1));
            }else{
                JOptionPane.showMessageDialog(null,"No puedo obtener id");

            }
            con.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error al guardar materia");
        }
    }
    
    public Materia buscarMateria(int id){
        Materia materia=null;
        String sql=("SELECT * FROM materia WHERE idMateria=?");
        
        try{
            PreparedStatement ps = con.prepareStatement(sql, java.sql.Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            ps.close();
            if(rs.next()){
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
            }else{
                JOptionPane.showMessageDialog(null,"El id especificado no existe");
            }
            con.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error al guardar materia");
        }
        return materia;
    }
    
    public void borrarMateria(int id){
        String sql=("DELETE * FROM materia WHERE idMateria=?");
        
        try{
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
            con.close();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error al borrar materia");
        }
    }
    
    public Set<Materia> ObtenerMateria(){
        Set<Materia> materias=new HashSet();
        Materia materia=null;
        String sql=("SELECT * FROM materia WHERE idMateria=?");
        
        try{
            PreparedStatement ps = con.prepareStatement(sql, java.sql.Statement.RETURN_GENERATED_KEYS);

            ResultSet rs = ps.executeQuery();
            ps.close();
            while(rs.next()){
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materias.add(materia);
            }
            con.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error al obtener materia");
        }
        return materias;
    }
    
    public void ActualizarMateria(Materia materia){
        String sql="UPDATE materia SET nombre=? WHERE idAlumno=?"
                + "VALUES(?);";
        
        try{
            PreparedStatement ps = con.prepareStatement(sql, java.sql.Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getIdMateria());
            ps.executeUpdate();
            
            ps.close();
            con.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error al actualizar materia");
        }
    }
}
