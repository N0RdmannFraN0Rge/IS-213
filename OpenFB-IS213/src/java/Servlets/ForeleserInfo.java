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
import java.text.DecimalFormat;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
  
// Servlet Name 
@WebServlet("/ForeleserInfo") 
public class ForeleserInfo extends HttpServlet { 
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>ForeleserInfo</title>");
            out.println("<meta charset=\"UTF-8\">");
            out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
            out.println("<link href=\"style.css\" rel=\"stylesheet\" type=\"text/css\">");
            out.println("</head>");
            out.println("<body>");
            
            int temp = 0;
            int value = 0;
            int count = 0;
            int green = 0;
            int yellow = 0;
            int red = 0;
            
            
            DBTool dbTool = new DBTool();
            
            try(Connection conn = dbTool.login()){
                
                String query = "SELECT * FROM Signals";
                try(PreparedStatement getSignals = conn.prepareStatement(query)) {
                    try(ResultSet rset = getSignals.executeQuery()) {
                        
                        while(rset.next()) {
                            try {
                                count++;
                                temp = rset.getInt("sigValue");
                                value += temp;
                                if(temp == 10){
                                    green++;
                                }else if(temp == 5){
                                    yellow++;
                                }else if(temp == 1){
                                    red++;
                                }
                                
                                
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
                
                
                HttpSession session = request.getSession();
                out.println("<div id=\"superDiv\">");
                    out.println("<div id=\"change\">");
                        out.println("<h3>Set number of minutes for the database wipe interval and immediately wipe the database.</h3>");
                        out.println("<form action=\"ForeleserInfo\" method=\"POST\">");
                            out.println("<input type=\"Text\" name=\"Seconds\" value=\"5\"></br>");
                            out.println("<input type=\"Submit\" name=\"Update\" value=\"Update\"><br>");
                        out.println("</form>");


                        String button = request.getParameter("Update");
                        String seconds = request.getParameter("Seconds");
                        if (button != null){
                            if(button.equals("Update")){
                                session.setAttribute("Seconds", seconds);
                                RequestDispatcher rd = request.getRequestDispatcher("DBUpdate");
                                rd.forward(request,response);
                                out.println(seconds);
                            }
                        }
                    out.println("</div>");
                    out.println("<div id=\"tabell\">");
                        out.println("<table class=\"table2\">");
                            out.println("<tr class=\"tr2\">");
                                out.println("<th class=\"th2\">Antall Forstått Alt</th>");
                                out.println("<th class=\"th2\">Antall Forstått Litt</th>");
                                out.println("<th class=\"th2\">Antall Forstått Lite</th>");
                            out.println("</tr>");
                            out.println("<tr class=\"tr2\">");
                                out.println("<td class=\"td2\">"+green+"</td>");
                                out.println("<td class=\"td2\">"+yellow+"</td>");
                                out.println("<td class=\"td2\">"+red+"</td>");
                            out.println("</tr>");
                        out.println("</table>");
                    out.println("</div>");
                out.println("</div>");
                            
               
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