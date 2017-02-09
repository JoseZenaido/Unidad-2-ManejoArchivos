/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.dao;

import java.sql.Connection;
import java.util.List;
import utng.model.DevelogSql;
import utng.util.utilDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ZENAIDO-PC
 */
public class DevelogSqlDAOImp  implements  DevelogSqlDAO{

    
    private Connection connection;
    
    public DevelogSqlDAOImp() {
        connection = utilDB.getConnection();
    }
    
    
    @Override
    public void agregarDevelogsql(DevelogSql develogSql) {
            try {
            String query = "INSERT INTO develogsql(\n" +
 "            createe, sql0, sql1, params, tracer, timer)\n"
                        + "    VALUES ( ?, ?, ?, ?, ?, ?);";

                PreparedStatement ps = connection.prepareStatement(query);
                ps.setString(1, develogSql.getCreated());
                ps.setString(2, develogSql.getSql0());
                ps.setString(3, develogSql.getSql1());
                ps.setString(4, develogSql.getParams());
                ps.setString(5, develogSql.getTracer());
                ps.setString(6, develogSql.getTimer());

                ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void borrarDevelogsql(int id) {
       try {
            String query = "DELETE FROM develogsql WHERE "
                    + " id=?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public void cambiarDevelogsql(DevelogSql develogsql) {
        try {
            String query = "UPDATE develogsql\n"
                    + "   SET  createe=?, sql0=?, sql1=?, params=?, tracer=?, timer=?\n"
                    + " WHERE id=?;";

            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, develogsql.getCreated());
            ps.setString(2, develogsql.getSql0());
            ps.setString(3, develogsql.getSql1());
            ps.setString(4, develogsql.getParams());
            ps.setString(5, develogsql.getTracer());
            ps.setString(6, develogsql.getTimer());

            ps.setInt(7, develogsql.getId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<DevelogSql> desplegarDevelogsql() {
        List<DevelogSql> develogsqls = new ArrayList<DevelogSql>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM develogsql");
            while (rs.next()) {
                DevelogSql develogsql = new DevelogSql(rs.getInt("id"),
                        rs.getString("createe"),
                        rs.getString("sql0"),
                        rs.getString("sql1"),
                        rs.getString("params"),
                        rs.getString("tracer"),
                        rs.getString("timer"));
                        
                develogsqls.add(develogsql);
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return develogsqls;
    }

    @Override
    public DevelogSql elegirDevelogsql(int id) {
         DevelogSql develogsql=null;
        try {
            String query = " SELECT * FROM develogsql WHERE id=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            
            if (rs.next()) {
                 develogsql = new DevelogSql(
                        rs.getInt("id"),
                        rs.getString("createe"),
                        rs.getString("sql0"),
                        rs.getString("sql1"),
                        rs.getString("params"),
                        rs.getString("tracer"),
                        rs.getString("timer"));

            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return develogsql;
    }
 
    
    
}
