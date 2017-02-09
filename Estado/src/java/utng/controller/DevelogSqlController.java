/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.controller;


import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utng.dao.DevelogSqlDAOImp;
import utng.model.DevelogSql;
import utng.dao.DevelogSqlDAO;


public class DevelogSqlController extends HttpServlet {
    
     
    private static final String LISTA_Develogsql= "/listarDevelogsql.jsp";
    private static final String AGREGAR_O_CAMBIAR = "/develogsql.jsp";
    private DevelogSqlDAO dao;
    
    public DevelogSqlController() {
        dao = new  DevelogSqlDAOImp();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String forward = "";
        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("borrar")) {
            forward = LISTA_Develogsql;
            
            
            int id = Integer.parseInt(request.getParameter("id"));
            dao.borrarDevelogsql(id);
            request.setAttribute("develogsqls", dao.desplegarDevelogsql());
            
        } else if (action.equalsIgnoreCase("cambiar")) {
            forward = AGREGAR_O_CAMBIAR;
            int id = Integer.parseInt(request.getParameter("id"));
            DevelogSql develogsql = dao.elegirDevelogsql(id);
            request.setAttribute("develogsql", develogsql);
            
        } else if (action.equalsIgnoreCase("agregar")) {
            forward = AGREGAR_O_CAMBIAR;
        } else {
            forward = LISTA_Develogsql;
            request.setAttribute("develogsqls", dao.desplegarDevelogsql());
        }
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DevelogSql develogsql = new DevelogSql();
        String id = request.getParameter("id");
        develogsql.setCreated(request.getParameter("created")); 
        develogsql.setSql0(request.getParameter("sql0")); 
        develogsql.setSql1(request.getParameter("sql1")); 
        develogsql.setParams(request.getParameter("params")); 
        develogsql.setTracer(request.getParameter("tracer")); 
        develogsql.setTimer(request.getParameter("timer")); 
     
        
        
        if (id == null || id.isEmpty()) {
            dao.agregarDevelogsql(develogsql);
        } else {
            develogsql.setId(Integer.parseInt(id));
            dao.cambiarDevelogsql(develogsql);
        }
        RequestDispatcher view = request.getRequestDispatcher(LISTA_Develogsql);
        request.setAttribute("develogsqls", dao.desplegarDevelogsql());
        view.forward(request, response);
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

    
}
