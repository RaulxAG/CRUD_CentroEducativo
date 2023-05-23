
package com.iesiliberis.crudcentroeducativo.controladorDAO;

import com.iesiliberis.crudcentroeducativo.BD.MyDataSource;
import com.iesiliberis.crudcentroeducativo.entidades.CursoAcademico;
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
public class MatriculaDaoImp implements MatriculaDao {
    private static MatriculaDaoImp instance;
    
    static{
        instance=new MatriculaDaoImp();
    }
    
    private MatriculaDaoImp(){ }
    
    public static MatriculaDaoImp getInstance(){
        return instance;
    }

    @Override
    public int add(Matricula m) throws SQLException {
        String sql="""
                  insert into matricula(idalumno,idunidad,descripcion,fMatricula,fBaja)
                  values (?,?,?,?,?)
                  """;
      int result=0;
       
        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
        
            pstm.setInt(1, m.getIdalumno());
            pstm.setInt(2, m.getIdunidad());
            pstm.setString(3, m.getDescripcion());
            pstm.setDate(4, m.getfMatricula());
            pstm.setDate(5, m.getfBaja());
            
            result=pstm.executeUpdate();
            
        }
        
        return result;
    }

    @Override
    public Matricula getById(int id) throws SQLException {
        Matricula matri=null;
        String sql="select * from matricula where idmatricula=?";

        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
        
            pstm.setInt(1, id);
            
            ResultSet rs=pstm.executeQuery();
            
            if (rs.next()){
                matri=new Matricula();
                
                matri.setIdmatricula(rs.getInt("idmatricula"));
                matri.setIdalumno(rs.getInt("idalumno"));
                matri.setIdunidad(rs.getInt("idunidad"));
                matri.setDescripcion(rs.getString("descripcion"));
                matri.setfMatricula(rs.getDate("fMatricula"));
                matri.setfMatricula(rs.getDate("fBaja"));
                
            }
            
        }
        
        return matri;
    }

    @Override
    public List<Matricula> getAll() throws SQLException {
        Matricula matri=null;
        String sql="select * from matricula";
        
        List<Matricula> result=new ArrayList();

        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
         
            ResultSet rs=pstm.executeQuery();
            
            while (rs.next()){
                matri=new Matricula();
                
                matri.setIdmatricula(rs.getInt("idmatricula"));
                matri.setIdalumno(rs.getInt("idalumno"));
                matri.setIdunidad(rs.getInt("idunidad"));
                matri.setDescripcion(rs.getString("descripcion"));
                matri.setfMatricula(rs.getDate("fMatricula"));
                matri.setfBaja(rs.getDate("fBaja"));
                
                result.add(matri);
            }
            
        }
        
        return result;
    }

    @Override
    public int update(Matricula m) throws SQLException {
        String sql="""
                  update matricula
                  set idalumno=?, idunidad=?, descripcion=?, fmatricula=?, fbaja=?
                   where idmatricula=?
                   """;
        int result=0;
       
        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
            
            pstm.setInt(1, m.getIdalumno());
            pstm.setInt(2, m.getIdunidad());
            pstm.setString(3, m.getDescripcion());
            pstm.setDate(4, m.getfMatricula());
            pstm.setDate(5, m.getfBaja());
            pstm.setInt(6, m.getIdmatricula());
            
            result=pstm.executeUpdate();
            
        }
        
        return result;
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql="""
                  delete from matricula 
                   where idmatricula=?
                   """;
        int result=0;
       
        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
            
            pstm.setInt(1, id);
            
            result=pstm.executeUpdate();
            
        }
    }
    
    
}
