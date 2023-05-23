
package com.iesiliberis.crudcentroeducativo.controladorDAO;

import com.iesiliberis.crudcentroeducativo.BD.MyDataSource;
import com.iesiliberis.crudcentroeducativo.entidades.Curso;
import com.iesiliberis.crudcentroeducativo.entidades.CursoAcademico;
import com.iesiliberis.crudcentroeducativo.entidades.Unidad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Raul AG
 */
public class UnidadDaoImp implements UnidadDao {
    private static UnidadDaoImp instance;
    
    static{
        instance=new UnidadDaoImp();
    }
    
    private UnidadDaoImp(){ }
    
    public static UnidadDaoImp getInstance(){
        return instance;
    }

    @Override
    public int add(Unidad u) throws SQLException {
        String sql="""
                  insert into unidad(codigo,nombre,observaciones,idcurso,idtutor,idaula)
                  values (?,?,?,?,?,?)
                  """;
        int result=0;
       
        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
        
            pstm.setString(1, u.getCodigo());
            pstm.setString(2, u.getNombre());
            pstm.setString(3, u.getObservaciones());
            pstm.setInt(4, u.getIdcurso());
            pstm.setInt(5, u.getIdtutor());
            pstm.setInt(6, u.getIdaula());
            
            result=pstm.executeUpdate();
            
        }
        
        return result;
    }

    @Override
    public Unidad getById(int id) throws SQLException {
        Unidad unidad=null;
        String sql="select * from unidad where id=?";

        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
        
            pstm.setInt(1, id);
            
            ResultSet rs=pstm.executeQuery();
            
            if (rs.next()){
                unidad=new Unidad();
                
                unidad.setId(rs.getInt("id"));
                unidad.setCodigo(rs.getString("codigo"));
                unidad.setNombre(rs.getString("nombre"));
                unidad.setObservaciones(rs.getString("observaciones"));
                unidad.setIdcurso(rs.getInt("idcurso"));
                unidad.setIdtutor(rs.getInt("idtutor"));
                unidad.setIdaula(rs.getInt("idaula"));
            }
            
        }
        
        return unidad;
    }

    @Override
    public List<Unidad> getAll() throws SQLException {
        Unidad unidad=null;
        String sql="select * from unidad";
        
        List<Unidad> result=new ArrayList();

        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
         
            ResultSet rs=pstm.executeQuery();
            
            while (rs.next()){
                unidad=new Unidad();
                
                unidad.setId(rs.getInt("id"));
                unidad.setCodigo(rs.getString("codigo"));
                unidad.setNombre(rs.getString("nombre"));
                unidad.setObservaciones(rs.getString("observaciones"));
                unidad.setIdcurso(rs.getInt("idcurso"));
                unidad.setIdtutor(rs.getInt("idtutor"));
                unidad.setIdaula(rs.getInt("idaula"));
                
                result.add(unidad);
            }
            
        }
        
        return result; 
    }

    @Override
    public int update(Unidad u) throws SQLException {
        String sql="""
                  update unidad
                  set codigo=?, nombre=?, observaciones=?, idcurso=?, idtutor=?, idaula=?
                   where id=?
                   """;
        int result=0;
       
        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
                
                pstm.setString(1, u.getCodigo());
                pstm.setString(2, u.getNombre());
                pstm.setString(3, u.getObservaciones());
                pstm.setInt(4, u.getIdcurso());
                pstm.setInt(5, u.getIdtutor());
                pstm.setInt(6, u.getIdaula());
                pstm.setInt(7, u.getId());
            
            result=pstm.executeUpdate();
            
        }
        
        return result;
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql="""
                  delete from unidad
                   where id=?
                   """;
        int result=0;
       
        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
            
            pstm.setInt(1, id);
            
            result=pstm.executeUpdate();
            
        }
    }

    @Override
    public Unidad getByIdcurso(int id) throws SQLException {
        Unidad unidad=null;
        String sql="select * from unidad where idcurso=?";

        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
        
            pstm.setInt(1, id);
            
            ResultSet rs=pstm.executeQuery();
            
            if (rs.next()){
                unidad=new Unidad();
                
                unidad.setId(rs.getInt("id"));
                unidad.setCodigo(rs.getString("codigo"));
                unidad.setNombre(rs.getString("nombre"));
                unidad.setObservaciones(rs.getString("observaciones"));
                unidad.setIdcurso(rs.getInt("idcurso"));
                unidad.setIdtutor(rs.getInt("idtutor"));
                unidad.setIdaula(rs.getInt("idaula"));
            }
            
        }
        
        return unidad;
    }

    @Override
    public Unidad getByIdtutor(int id) throws SQLException {
        Unidad unidad=null;
        String sql="select * from unidad where idtutor=?";

        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
        
            pstm.setInt(1, id);
            
            ResultSet rs=pstm.executeQuery();
            
            if (rs.next()){
                unidad=new Unidad();
                
                unidad.setId(rs.getInt("id"));
                unidad.setCodigo(rs.getString("codigo"));
                unidad.setNombre(rs.getString("nombre"));
                unidad.setObservaciones(rs.getString("observaciones"));
                unidad.setIdcurso(rs.getInt("idcurso"));
                unidad.setIdtutor(rs.getInt("idtutor"));
                unidad.setIdaula(rs.getInt("idaula"));
            }
            
        }
        
        return unidad;
    }

    @Override
    public Unidad getByIdaula(int id) throws SQLException {
        Unidad unidad=null;
        String sql="select * from unidad where idaula=?";

        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
        
            pstm.setInt(1, id);
            
            ResultSet rs=pstm.executeQuery();
            
            if (rs.next()){
                unidad=new Unidad();
                
                unidad.setId(rs.getInt("id"));
                unidad.setCodigo(rs.getString("codigo"));
                unidad.setNombre(rs.getString("nombre"));
                unidad.setObservaciones(rs.getString("observaciones"));
                unidad.setIdcurso(rs.getInt("idcurso"));
                unidad.setIdtutor(rs.getInt("idtutor"));
                unidad.setIdaula(rs.getInt("idaula"));
            }
            
        }
        
        return unidad;
    }
    
}
