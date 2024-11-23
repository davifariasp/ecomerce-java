/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Categoria;


/**
 *
 * @author davifariasp
 */
public class CategoriaDAO {
    private String URL = "jdbc:postgresql://localhost:5432/comercio-eletronico";
    private String USUARIO = "postgres";
    private String SENHA = "0405";
    
    public boolean inserir(String descricao){
        boolean resultado = false;

        try {
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection(URL, USUARIO, SENHA);
            PreparedStatement ps = c.prepareStatement("INSERT INTO categoria (descricao) VALUES (?)");
            ps.setString(1, descricao);

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
    
    public Categoria procurar (int id){
        Categoria resultado = null;
        
        try {
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection(URL, USUARIO, SENHA);
            PreparedStatement ps = c.prepareStatement("SELECT id, descricao FROM categoria WHERE id LIKE ? ");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            
            while(rs.next()){
                Categoria res = new Categoria();
                
                res.setId(rs.getInt("id"));
                res.setDescricao(rs.getString("descricao"));
               
                resultado = res;
            }
            rs.close();
            ps.close();
            c.close();
            
            
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return resultado;
    }
    
    public boolean alterar (int id, String descricao){
        boolean resultado = false;
       
        try {
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection(URL, USUARIO, SENHA);
            PreparedStatement ps = c.prepareStatement("UPDATE categoria SET descricao = ? WHERE id = ?");
            
            ps.setString(1, descricao);
            ps.setInt(2, id);
            
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
    
    public boolean remover (int id){
        boolean resultado = false;
        
        try {
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection(URL, USUARIO, SENHA);
            PreparedStatement ps = c.prepareStatement("DELETE FROM categoria WHERE id = ?");
            ps.setInt(1, id);
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
    
    public List<Categoria> listarTodos() throws SQLException{
        List<Categoria> resultado = new ArrayList<>();
        
        try {
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection(URL, USUARIO, SENHA);
            PreparedStatement ps = c.prepareStatement("SELECT id, descricao adm FROM categoria");
            ResultSet rs = ps.executeQuery();
            
            
            while(rs.next()){
                Categoria res = new Categoria();
                
                res.setId(rs.getInt("id"));
                res.setDescricao(rs.getString("descricao"));
               
                resultado.add(res);
            }
            rs.close();
            ps.close();
            c.close();
            
            
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return resultado;
    }
}
