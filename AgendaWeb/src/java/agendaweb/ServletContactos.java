/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendaweb;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mañanas
 */
@WebServlet(name = "ServletContactos", urlPatterns = {"/ServletContactos"})
public class ServletContactos extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String accion=request.getParameter("accion");
        if(accion.equals("vercontactos")){
            ArrayList<Contacto> lista_contactos=AccesoBD.listarContactos();
            request.setAttribute("contactos", lista_contactos);
            request.getRequestDispatcher("vercontactos.jsp").forward(request, response);
        }else if (accion.equals("insertar")){
            String nombre=request.getParameter("nombre");
            String email=request.getParameter("email");
            Contacto c=new Contacto(nombre, email);
            try{
            AccesoBD.grabarContacto(c);
                request.setAttribute("estado-insercion", "OK");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }catch (Exception e){
                request.setAttribute("estado-insercion", "KO");
                request.getRequestDispatcher("index.jsp").forward(request, response);
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
