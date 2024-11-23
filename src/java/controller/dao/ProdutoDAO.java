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
import model.Produto;

/**
 *
 * @author davifariasp
 */
public class ProdutoDAO {
    private String URL = "jdbc:postgresql://localhost:5432/comercio-eletronico";
    private String USUARIO = "postgres";
    private String SENHA = "0405";
    
    public boolean inserir(String descricao, double preco, String foto){
        boolean resultado = false;

        try {
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection(URL, USUARIO, SENHA);
            //inserindo na tabela produto
            PreparedStatement ps = c.prepareStatement("INSERT INTO produto (descricao, preco, foto) VALUES (?, ?, ?)");
            ps.setString(1, descricao);
            ps.setDouble(2, preco);
            ps.setString(3, foto);

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
    
    public Produto procurar (int id){
        Produto resultado = null;
        
        try {
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection(URL, USUARIO, SENHA);
            PreparedStatement ps = c.prepareStatement("SELECT id, descricao, preco, foto FROM categoria WHERE id LIKE ? ");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            
            while(rs.next()){
                Produto res = new Produto();
                
                res.setId(rs.getInt("id"));
                res.setDescricao(rs.getString("descricao"));
                res.setPreco(rs.getDouble("preco"));
                res.setFoto(rs.getString("foto"));
               
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
    
    public boolean alterar (int id, String descricao, double preco, String foto){
        boolean resultado = false;
       
        try {
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection(URL, USUARIO, SENHA);
            PreparedStatement ps = c.prepareStatement("UPDATE produto SET descricao = ?, preco = ?, foto = ? WHERE id = ?");
            
            ps.setString(1, descricao);
            ps.setDouble(2, preco);
            ps.setString(3, foto);
            ps.setInt(4, id);
            
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
            PreparedStatement ps = c.prepareStatement("DELETE FROM produto WHERE id = ?");
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
    
    public List<Produto> listarTodos() throws SQLException{
        List<Produto> resultado = new ArrayList<>();
        
        try {
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection(URL, USUARIO, SENHA);
            PreparedStatement ps = c.prepareStatement("SELECT id, descricao adm FROM produto");
            ResultSet rs = ps.executeQuery();
            
            
            while(rs.next()){
                Produto res = new Produto();
                
                res.setId(rs.getInt("id"));
                res.setDescricao(rs.getString("descricao"));
                res.setPreco(rs.getDouble("preco"));
                res.setFoto(rs.getString("foto"));
               
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
