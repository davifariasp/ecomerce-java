/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import controller.dao.UsuarioDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import model.Usuario;
/**
 *
 * @author davifariasp
 */
public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        
        UsuarioDAO usuarioDAO = new UsuarioDAO();    
        Usuario resultado = usuarioDAO.procurarUsuario(login);
        
        //se os campos nao forem vazios
        if (login != null && senha !=null && !login.isEmpty() && !senha.isEmpty()){
            if(resultado == null) {
                response.sendRedirect("login.jsp");
                out.println("Usuário não existe!");
            } else if (resultado.getLogin().equals(login) && resultado.getSenha().equals(senha)){
                    request.getSession().setAttribute("usuario", resultado);
                    response.sendRedirect("index.jsp");  
            } else {
                response.sendRedirect("login.jsp");
                out.println("Usuário e/ou senha estão incorretos!");
            }         
        } else {
            response.sendRedirect("login.jsp");
            out.println("Usuário e/ou senha estão vazios!");
        }
    }
}
