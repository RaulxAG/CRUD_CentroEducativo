/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.iesiliberis.crudcentroeducativo.controladorDAO;

import com.iesiliberis.crudcentroeducativo.entidades.Autorizaciones;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Raul AG
 */
public interface AutorizacionesDao {
    int add(Autorizaciones a) throws SQLException;
    
    Autorizaciones getById(int id) throws SQLException;
        
    List<Autorizaciones> getAll()  throws SQLException;
    
    int update(Autorizaciones a)  throws SQLException;
    
    void delete(int id)  throws SQLException;
}
