/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.iesiliberis.crudcentroeducativo.controladorDAO;

import com.iesiliberis.crudcentroeducativo.entidades.Curso;
import com.iesiliberis.crudcentroeducativo.entidades.CursoAcademico;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author sergio
 */
public interface CursoDao {
     int add(Curso cu) throws SQLException;
    
    Curso getById(int id) throws SQLException;
        
    List<Curso> getAll()  throws SQLException;
    
    List<Curso> getAllByCursoAcademico(int idcursoacademico)  throws SQLException;
    
    int update(Curso c)  throws SQLException;
    
    void delete(int id)  throws SQLException;
    
    CursoAcademico getCursoAcademico(Curso cu) throws SQLException;
    
    
    
}
