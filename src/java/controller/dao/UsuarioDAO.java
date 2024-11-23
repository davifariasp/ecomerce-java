/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.dao;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Usuario;

/**
 *
 * @author davifariasp
 */
public class UsuarioDAO {
    private String URL = "jdbc:postgresql://localhost:5432/comercio-eletronico";
    private String USUARIO = "postgres";
    private String SENHA = "0405";
    
    public List<Usuario> listarTodos() throws SQLException{
        List<Usuario> resultado = new ArrayList<>();
        
        try {
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection(URL, USUARIO, SENHA);
            PreparedStatement ps = c.prepareStatement("SELECT id, nome, endereco, email, login, senha, adm FROM usuario");
            ResultSet rs = ps.executeQuery();
            
            
            while(rs.next()){
                Usuario usuario = new Usuario();
                
                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setEndereco(rs.getString("endereco"));
                usuario.setEmail(rs.getString("email"));
                usuario.setLogin(rs.getString("login"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setAdm(rs.getBoolean("adm"));
               
                resultado.add(usuario);
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
    
    public boolean inserir(String nome, String endereco, String email, String login, String senha){
        boolean resultado = false;

        try {
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection(URL, USUARIO, SENHA);
            PreparedStatement ps = c.prepareStatement("INSERT INTO usuario (nome, endereco, email, login, senha) VALUES (?, ?, ?, ?, ?)");
            ps.setString(1, nome);
            ps.setString(2, endereco);
            ps.setString(3, email);
            ps.setString(4, login);
            ps.setString(5, senha);

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
    
    public Usuario procurarUsuario (String login){
        Usuario resultado = null;
        
        try {
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection(URL, USUARIO, SENHA);
            PreparedStatement ps = c.prepareStatement("SELECT id, nome, endereco, email, login, senha, adm FROM usuario WHERE login LIKE ? ");
            ps.setString(1, login);
            ResultSet rs = ps.executeQuery();
            
            
            while(rs.next()){
                Usuario u = new Usuario();
                
                u.setId(rs.getInt("id"));
                u.setNome(rs.getString("nome"));
                u.setEndereco(rs.getString("endereco"));
                u.setEmail(rs.getString("email"));
                u.setLogin(rs.getString("login"));
                u.setSenha(rs.getString("senha"));
                u.setAdm(rs.getBoolean("adm"));
               
                resultado = u;
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
    
    public boolean alterar (int id, String nome, String endereco, String email, String login, String senha){
        boolean resultado = false;
       
        try {
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection(URL, USUARIO, SENHA);
            PreparedStatement ps = c.prepareStatement("UPDATE usuario SET nome = ?, endereco = ?, email = ?, login = ?, senha = ? WHERE id = ?");
            
            ps.setString(1, nome);
            ps.setString(2, endereco);
            ps.setString(3, email);
            ps.setString(4, login);
            ps.setString(5, senha);
            ps.setInt(6, id);
            
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
            PreparedStatement ps = c.prepareStatement("DELETE FROM usuario WHERE id = ?");
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
}
