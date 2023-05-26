
package com.iesiliberis.crudcentroeducativo.controladorDAO;

import com.iesiliberis.crudcentroeducativo.BD.MyDataSource;
import com.iesiliberis.crudcentroeducativo.entidades.Autorizaciones;
import com.iesiliberis.crudcentroeducativo.entidades.Matricula;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Raul AG
 */
public class AutorizacionesDaoImp implements AutorizacionesDao {
    
    private static AutorizacionesDaoImp instance;
    
    static{
        instance=new AutorizacionesDaoImp();
    }
    
    private AutorizacionesDaoImp(){ }
    
    public static AutorizacionesDaoImp getInstance(){
        return instance;
    }

    @Override
    public int add(Autorizaciones a) throws SQLException {
        String sql="""
                  insert into autorizaciones(idalumno,idautorizado)
                  values (?,?)
                  """;
      int result=0;
       
        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
        
            pstm.setInt(1, a.getIdalumno());
            pstm.setInt(2, a.getIdautorizado());
            
            result=pstm.executeUpdate();
            
        }
        
        return result;
    }

    public Autorizaciones getByIdAlumno(int id) throws SQLException {
        Autorizaciones auto=null;
        String sql="select * from autorizaciones where idalumno=?";

        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
        
            pstm.setInt(1, id);
            
            ResultSet rs=pstm.executeQuery();
            
            if (rs.next()){
                auto=new Autorizaciones();
                
                auto.setIdalumno(rs.getInt("idalumno"));
                auto.setIdautorizado(rs.getInt("idautorizado"));
                
            }
            
        }
        
        return auto;
    }
    
    public Autorizaciones getByIdAutorizado(int id) throws SQLException {
        Autorizaciones auto=null;
        String sql="select * from autorizaciones where idautorizado=?";

        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
        
            pstm.setInt(1, id);
            
            ResultSet rs=pstm.executeQuery();
            
            if (rs.next()){
                auto=new Autorizaciones();
                
                auto.setIdalumno(rs.getInt("idalumno"));
                auto.setIdautorizado(rs.getInt("idautorizado"));
                
            }
            
        }
        
        return auto;
    }

    @Override
    public List<Autorizaciones> getAll() throws SQLException {
        Autorizaciones auto=null;
        String sql="select * from autorizaciones";
        
        List<Autorizaciones> result=new ArrayList();

        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
         
            ResultSet rs=pstm.executeQuery();
            
            while (rs.next()){
                auto=new Autorizaciones();
                
                auto.setIdalumno(rs.getInt("idalumno"));
                auto.setIdautorizado(rs.getInt("idautorizado"));
                result.add(auto);
            }
            
        }
        
        return result;
    }

    @Override
    public int update(Autorizaciones a) throws SQLException {
        String sql="""
                  update autorizaciones
                  set idalumno=?, idautorizado=?
                   where idalumno=?
                   """;
        int result=0;
       
        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
            
            pstm.setInt(1, a.getIdalumno());
            pstm.setInt(2, a.getIdautorizado());
            
            result=pstm.executeUpdate();
            
        }
        
        return result;
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql="""
                  delete from autorizaciones 
                   where idalumno=?
                   """;
        int result=0;
       
        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
            
            pstm.setInt(1, id);
            
            result=pstm.executeUpdate();
            
        }
    }

    @Override
    public Autorizaciones getById(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
