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
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
  
// Servlet Name 
@WebServlet("/IS_213") 
public class IS_213 extends HttpServlet { 
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>IS-213</title>");
            out.println("<meta charset=\"UTF-8\">");
            out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
            out.println("<link href=\"style.css\" rel=\"stylesheet\" type=\"text/css\">");
            out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
            out.println("</head>");
            out.println("<body>");
            
            double value = 0;
            int count = 0;
            
            DBTool dbTool = new DBTool();
            
            try(Connection conn = dbTool.login()){
                out.println("<form action=\"index.html\">");
                    out.println("<input class=\"back\" type=\"Submit\" value=\"Back\">");
                out.println("</form>");
                
                
                out.println("<div class=\"mainDiv\">");
                    out.println("<div id=\"notsomaindiv\">");
                        out.println("<h2>Which of the following statements corresponds with your understanding of the topic?</h2>");

                        out.println("<br>");
                        out.println("<br>");
                        /*out.println("<a id=\"Green\" href=\"InputServlet?sigValue=10\">Jeg forstår alt</a>");
                        out.println("<a id=\"Yellow\" href=\"InputServlet?sigValue=5\">Forklar litt bedre</a>");
                        out.println("<a id=\"Red\" href=\"InputServlet?sigValue=1\">Jeg skjønte ikke dette</a>");*/
                        out.println("<div id=\"buttondiv\">");
                            out.println("<form action=\"IS_213\" method=\"POST\">");
                            out.println("<input id=\"green\" class=\"button\" type=\"Submit\" name=\"Green\" value=\"I understand completely\"><br>");
                            out.println("<input id=\"yellow\" class=\"button\" type=\"Submit\" name=\"Yellow\" value=\"I understand somewhat\"><br>");
                            out.println("<input id=\"red\" class=\"button\" type=\"Submit\" name=\"Red\" value=\"I don't understand anything\"><br>");
                            out.println("</form>");
                        out.println("</div>");
                    out.println("</div>");
                out.println("</div>");
                
                HttpSession session = request.getSession();
                
                
                
                
                String color = request.getParameter("Green");
                if(color != null){
                    if(color.equals("I understand completely")){
                        conn.close();  
                        request.setAttribute("sigValue", "10");
                        session.setAttribute("sigValue", "10");
                        RequestDispatcher rd = request.getRequestDispatcher("InputServlet");
                        rd.forward(request,response);
                    }
                }
                
                color = request.getParameter("Yellow");
                if(color != null){
                    if(color.equals("I understand somewhat")){
                        conn.close();
                        request.setAttribute("sigValue", "5");
                        session.setAttribute("sigValue", "5");
                        RequestDispatcher rd = request.getRequestDispatcher("InputServlet");
                        rd.forward(request,response);
                    }
                }
                    
                color = request.getParameter("Red");
                if(color != null){
                    if(color.equals("I don't understand anything")){
                        conn.close();
                        request.setAttribute("sigValue", "1");
                        session.setAttribute("sigValue","1");
                        RequestDispatcher rd = request.getRequestDispatcher("InputServlet");
                        rd.forward(request,response);
                    }
                }
               
                
                
                
                
                String query = "SELECT * FROM Signals";
                try(PreparedStatement getSignals = conn.prepareStatement(query)) {
                    try(ResultSet rset = getSignals.executeQuery()) {
                        
                        while(rset.next()) {
                            try {
                                count++;
                                value += rset.getInt("sigValue");
                            } catch (Exception exception) {
                                out.println("Unable to map row" + exception);
                            }
                        }   
                        if(value != 0 && count != 0){
                            value = value/count;
                        }
                        
                    }
                }catch (SQLException ex) {
                    out.println("Ikke hentet fra DB liste: "+ex);
                }
                
                
                //out.println("<p>Gjennomsnittsverdi: </p>");
                out.println("<p hidden>"+value+"</p>");
                conn.close();
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