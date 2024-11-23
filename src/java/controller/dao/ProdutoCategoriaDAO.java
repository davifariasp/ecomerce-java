/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.ProdutoCategoria;

/**
 *
 * @author davifariasp
 */

//produto_id, categoria_id
public class ProdutoCategoriaDAO {
    private String URL = "jdbc:postgresql://localhost:5432/comercio-eletronico";
    private String USUARIO = "postgres";
    private String SENHA = "0405";
    
    public boolean inserir (int produto_id, int categoria_id){
        boolean resultado = false;
        
        try {
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection(URL, USUARIO, SENHA);
            PreparedStatement ps = c.prepareStatement("INSERT INTO produto_categoria (produto_id, categoria_id) VALUES (?, ?, ?)");
            ps.setInt(1, produto_id);
            ps.setInt(2, categoria_id);

            int r = ps.executeUpdate();
            resultado = (r == 1);
            ps.close();
            c.close();
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return resultado;
    }
    
    public boolean remover (int produto_id, int categoria_id){
        boolean resultado = false;
        
        try {
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection(URL, USUARIO, SENHA);
            PreparedStatement ps = c.prepareStatement("DELETE FROM produto_categoria WHERE produto_id = ? AND categoria_id =?");
            ps.setInt(1, produto_id);
            ps.setInt(2, categoria_id);
            int r = ps.executeUpdate();
            resultado = (r == 1);
            ps.close();
            c.close();
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return resultado;
    }
    
    public boolean alterar (int produto_id, int categoria_id){
        boolean resultado = false;
        
        try {
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection(URL, USUARIO, SENHA);
            PreparedStatement ps = c.prepareStatement("UPDATE produto_categoria SET produto_id = ?, categoria_id = ? WHERE produto_id = ? AND categoria_id =?");
            
            ps.setInt(1, produto_id);
            ps.setInt(2, categoria_id);
            ps.setInt(3, produto_id);
            ps.setInt(4, categoria_id);
            
            int r = ps.executeUpdate();
            resultado = (r == 1);
            
            ps.close();
            c.close();   
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return resultado;
    }
    
    public ProdutoCategoria procurar (int produto_id, int categoria_id){
        ProdutoCategoria resultado = null;
        
        return resultado;
    }
    
}
