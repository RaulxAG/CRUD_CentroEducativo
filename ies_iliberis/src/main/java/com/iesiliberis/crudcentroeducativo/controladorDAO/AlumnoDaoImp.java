/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iesiliberis.crudcentroeducativo.controladorDAO;

import com.iesiliberis.crudcentroeducativo.BD.MyDataSource;
import com.iesiliberis.crudcentroeducativo.entidades.Alumno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sergio
 */
public class AlumnoDaoImp implements AlumnoDao {

     private static AlumnoDaoImp instance;
    
    static{
        instance=new AlumnoDaoImp();
    }
    
    private AlumnoDaoImp(){ }
    
    public static AlumnoDaoImp getInstance(){
        return instance;
    }
    
    
    
    @Override
    public int add(Alumno a) throws SQLException {
        String sql="""
                  insert into alumno(dni,nombre,apellido1,apellido2,fNacimiento,telefono,email,direccion,cp,poblacion,provincia)
                  values (?,?,?,?,?,?,?,?,?,?,?)
                  """;
      int result=0;
       
        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
        
            pstm.setString(1,a.getDni());
            pstm.setString(2,a.getNombre());
            pstm.setString(3,a.getApellido1());
            pstm.setString(4,a.getApellido2());
            pstm.setDate(5,a.getFnacimiento());
            pstm.setInt(6,a.getTelefono());
            pstm.setString(7,a.getEmail());
            pstm.setString(8,a.getDireccion());
            pstm.setInt(9,a.getCp());
            pstm.setString(10,a.getPoblacion());
            pstm.setString(11,a.getProvincia());
            
            result=pstm.executeUpdate();
            
        }
        
        return result;
    }

    @Override
    public Alumno getById(int id) throws SQLException {
        Alumno alum=null;
        String sql="select * from alumno where id=?";

        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
        
            pstm.setInt(1, id);
            
            ResultSet rs=pstm.executeQuery();
            
            if (rs.next()){
                alum=new Alumno();
                
                alum.setId(rs.getInt("id"));
                alum.setDni(rs.getString("dni"));
                alum.setNombre(rs.getString("nombre"));
                alum.setApellido1(rs.getString("apellido1"));
                alum.setApellido2(rs.getString("apellido2"));
                alum.setFnacimiento(rs.getDate("fNacimiento"));
                alum.setTelefono(rs.getInt("telefono"));
                alum.setEmail(rs.getString("email"));
                alum.setDireccion(rs.getString("direccion"));
                alum.setCp(rs.getInt("cp"));
                alum.setPoblacion(rs.getString("poblacion"));
                alum.setProvincia(rs.getString("provincia"));
            }
            
        }
        
        return alum;
    }

    @Override
    public List<Alumno> getAll() throws SQLException {
        Alumno alum=null;
        String sql="select * from alumno";
        
        List<Alumno> result=new ArrayList();

        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
         
            ResultSet rs=pstm.executeQuery();
            
            while (rs.next()){
                alum=new Alumno();
                
                alum.setId(rs.getInt("id"));
                alum.setDni(rs.getString("dni"));
                alum.setNombre(rs.getString("nombre"));
                alum.setApellido1(rs.getString("apellido1"));
                alum.setApellido2(rs.getString("apellido2"));
                alum.setFnacimiento(rs.getDate("fNacimiento"));
                
                
                result.add(alum);
            }
            
        }
        
        return result; 
    }

    @Override
    public int update(Alumno a) throws SQLException {
        
        String sql="update alumno set dni=?, nombre=?, apellido1=?, apellido2=?, fNacimiento=?, telefono=?, email=?, direccion=?, cp=?, poblacion=?, provincia=? where id=?";
        int result=0;
       
        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
            
            pstm.setString(1, a.getDni());
            pstm.setString(2, a.getNombre());
            pstm.setString(3, a.getApellido1());
            pstm.setString(4, a.getApellido2());
            pstm.setString(5, String.valueOf(a.getFnacimiento()));
            pstm.setInt(6, a.getTelefono());
            pstm.setString(7, a.getEmail());
            pstm.setString(8, a.getDireccion());
            pstm.setInt(9, a.getCp());
            pstm.setString(10, a.getPoblacion());
            pstm.setString(11, a.getProvincia());
            pstm.setInt(12, a.getId());
            
            result=pstm.executeUpdate();
            
        }
        
        return result;
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql="""
                  delete from alumno 
                   where id=?
                   """;
        int result=0;
       
        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
            
            pstm.setInt(1, id);
            
            result=pstm.executeUpdate();
            
        }
    }
    
}
