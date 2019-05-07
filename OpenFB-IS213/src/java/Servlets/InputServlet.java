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
@WebServlet("/InputServlet") 
public class InputServlet extends HttpServlet { 
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>IS-213</title>");
            out.println("<meta charset=\"UTF-8\">");
            out.println("<link href=\"style.css\" rel=\"stylesheet\" type=\"text/css\">");
            out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
            out.println("</head>");
            out.println("<body>");
            
            HttpSession session = request.getSession();
            String sValue = (String) session.getAttribute("sigValue");
            String sIP = (String) request.getRemoteAddr();
            String sIP2 = "";
            
            
            //String sValue = (String)request.getParameter("sigValue");
            //out.println("<p>"+sValue+"</p>");
            int value = Integer.parseInt(sValue);
            //out.println("<p>test1</p>");
            DBTool dbTool = new DBTool();
            
            try(Connection conn = dbTool.login()){
                Boolean ipExists = false;
                String check = "SELECT * FROM Signals";
                try(PreparedStatement checkIP = conn.prepareStatement(check)) {
                    try(ResultSet rset = checkIP.executeQuery()) {
                        
                        while(rset.next()) {
                            try {
                                sIP2 = rset.getString("sigIP");
                                if(sIP.equals(sIP2)){
                                    ipExists = true;
                                }
                            } catch (Exception exception) {
                                out.println("Unable to map row" + exception);
                            }
                        }
                        
                    }
                }catch (SQLException ex) {
                    out.println("Ikke hentet fra DB liste: "+ex);
                }
                
                
                if(ipExists == false){
                    String ins = "INSERT INTO Signals (sigValue, sigIP) VALUES (?, ?)";
                    try (PreparedStatement newSignal = conn.prepareStatement(ins)) {
                        newSignal.setInt(1, value);
                        newSignal.setString(2, sIP);
                        newSignal.executeUpdate();
                    }
                    //out.println("<p>test3</p>");
                    conn.close();
                    /*RequestDispatcher rd = request.getRequestDispatcher("IS_213");
                    rd.forward(request,response);*/

                    out.println("<meta http-equiv=\"refresh\" content=\"0.1;URL=IS_213\">");
                }else{
                    out.println("<p><font size=\"+5\">Only one entry allowed. You will be redirected in 4 seconds.</font></p>");
                    out.println("<p><font size=\"+3\">You can return instantly by pressing the button below.</font></p>");
                    out.println("<form action=\"IS_213\" method=\"POST\">");
                    out.println("<input id=\"tilbake\" class=\"button2\" type=\"Submit\" name=\"Red\"value=\"Back\"><br>");
                    out.println("</form>");
                    
                    out.println("<meta http-equiv=\"refresh\" content=\"4;URL=IS_213\">");
                    
                }
                
                
                
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