/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException; 
import java.io.PrintWriter; 
import java.sql.Connection; 
import java.sql.PreparedStatement; 
  
import javax.servlet.ServletException; 
import javax.servlet.annotation.WebServlet; 
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 
  
// Import Database Connection Class file 
import Classes.DBTool;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;
import javax.servlet.http.HttpSession;
  
// Servlet Name 
@WebServlet("/DBUpdate") 
public class DBUpdate extends HttpServlet { 
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>DBUpdate</title>");
            out.println("<meta charset=\"UTF-8\">");
            out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
            out.println("</head>");
            out.println("<body>");
            HttpSession session = request.getSession();
            String seconds = (String) session.getAttribute("Seconds");
            DBTool dbTool = new DBTool();
            
            int seconds2 = 0;
            
            out.println(seconds);
            
            if(seconds != null){
                seconds2 = Integer.parseInt(seconds);
                seconds2 = seconds2*60;
            }
            
            try(Connection conn = dbTool.login()){
                
                
                
                String update = "SET GLOBAL event_scheduler = ON";
                
                try (PreparedStatement newSignal = conn.prepareStatement(update)) {
                    //newSignal.setInt(1, seconds2);
                    newSignal.executeUpdate();
                }
                
                update = "TRUNCATE TABLE CDDJJT.Signals;";
                
                try (PreparedStatement newSignal = conn.prepareStatement(update)) {
                    //newSignal.setInt(1, seconds2);
                    newSignal.executeUpdate();
                }
                update = "DROP EVENT IF EXISTS e_truncate;";
                
                try (PreparedStatement newSignal = conn.prepareStatement(update)) {
                    //newSignal.setInt(1, seconds2);
                    newSignal.executeUpdate();
                }
                update = "CREATE EVENT IF NOT EXISTS e_truncate ON SCHEDULE EVERY "+seconds2+" SECOND DO TRUNCATE TABLE CDDJJT.Signals;";
                
                try (PreparedStatement newSignal = conn.prepareStatement(update)) {
                    //newSignal.setInt(1, seconds2);
                    newSignal.executeUpdate();
                }
                conn.close();
                /*RequestDispatcher rd = request.getRequestDispatcher("IS_213");
                rd.forward(request,response);*/
             
                    
                out.println("<meta http-equiv=\"refresh\" content=\"0.1;URL=ForeleserInfo\">");
            }catch (Exception ex) {
                out.println("Problem i InsertData " + ex);
            }
        } 
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
} 