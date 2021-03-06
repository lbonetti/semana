package pesquisa;

import java.sql.*;
import javax.swing.JOptionPane;

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

    public void conectar() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost/pesquisa", "root", "1234");
    }

    public void desconectar() throws SQLException {
        connection.close();
    }

    public boolean insert(boolean satisfeito, int nota, String sugestao, String avaliacao, boolean publicar, String nome) throws SQLException, ClassNotFoundException {
        boolean status=true;
        try {
            conectar();
            String busca = "SELECT MAX(id) AS id FROM questionario"; //busca obter o último ID inserido e incrementar ele
            String insert = "INSERT INTO questionario VALUES (?,?,?,?,?,?,?,false)"; //insert dos dados no banco
            int nextID;
            
            try{
                PreparedStatement stbusca = connection.prepareStatement(busca);
                
                PreparedStatement stinsert = connection.prepareStatement(insert);
                ResultSet rs = stbusca.executeQuery();
                rs.next();
                nextID = rs.getInt("id") + 1;
                
                stinsert.setInt(1, nextID);
                stinsert.setBoolean(2, satisfeito);
                stinsert.setInt(3, nota);
                stinsert.setString(4, sugestao);
                stinsert.setString(5, avaliacao);
                stinsert.setBoolean(6, publicar);
                stinsert.setString(7, nome);
                
                stinsert.execute();
                stinsert.close();
                stbusca.close();
                
                JOptionPane.showMessageDialog(null, "Obrigado por participar! Sua opinião é muito importante para nós.");
            }
            catch(SQLException e) {
                JOptionPane.showMessageDialog(null, "Ocorreu o seguinte erro ao inserir os dados no banco: " + e);
                status=false;
            }
        } 
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu o seguinte erro ao conectar com banco: " + e);
            status=false;
        }
        finally{
            desconectar();
            return status;
        }
      
    }
}