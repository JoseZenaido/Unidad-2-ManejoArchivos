/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.dao;

import java.util.List;
import utng.model.DevelogSql;
import utng.model.JobHistory;

/**
 *
 * @author ZENAIDO-PC
 */
public interface DevelogSqlDAO {
    void agregarDevelogsql( DevelogSql develogSql);
    void borrarDevelogsql(int id);
    void cambiarDevelogsql( DevelogSql develogsql);
    List< DevelogSql> desplegarDevelogsql();
     DevelogSql elegirDevelogsql(int id);
}
