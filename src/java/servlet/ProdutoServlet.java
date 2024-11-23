/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import controller.dao.ProdutoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author davifariasp
 */

public class ProdutoServlet extends HttpServlet {

    //para inserir
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String descricao = request.getParameter("descricao");
        double preco = Double.parseDouble(request.getParameter("preco")); // string p double
        String foto = request.getParameter("foto");
        
        ProdutoDAO produtoDAO = new ProdutoDAO();    
        boolean resultado = produtoDAO.inserir(descricao, preco, foto);
        
        response.setContentType("text/html;charset=UTF-8");
        
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CadastroServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            if (resultado) {
                out.println("<h1>Produto " +  descricao + " cadastrado com sucesso!</h1>");
                out.println("<a href='login.jsp'>Fazer Login</a>");
            } else {
                out.println("<h1>Erro ao cadastrar, tente novamente!</h1>");
            }
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    //pra pegar as Produtos
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    }
}
