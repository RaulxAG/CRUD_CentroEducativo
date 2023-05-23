/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.iesiliberis.crudcentroeducativo.controladorDAO;

import com.iesiliberis.crudcentroeducativo.entidades.Matricula;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Raul AG
 */
public interface MatriculaDao {
    int add(Matricula a) throws SQLException;
    
    Matricula getById(int id) throws SQLException;
        
    List<Matricula> getAll()  throws SQLException;
    
    int update(Matricula a)  throws SQLException;
    
    void delete(int id)  throws SQLException;
}
