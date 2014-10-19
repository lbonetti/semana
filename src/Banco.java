
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lucas
 */
public class Banco {
    
    private Connection connection;
    
    public Banco() { /*throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost/pesquisa", "root", "1234");
        System.out.println("Conectado com sucesso.");*/
    }
    public void desconectar(){
        
    }
    
    public boolean insert(boolean satisfeito, int nota, String sugestao, String avaliacao, boolean publicar, String nome){
        try{
            
            
        }
        catch (Exception e){
            
        }
        return true;
    }
}

class TestaConexao {
    
    public static void main(String[] args) {
        try {
            Banco bd = new Banco();
        } catch (Exception e) {
            System.out.println("Não conectado.");
        }
    }
}