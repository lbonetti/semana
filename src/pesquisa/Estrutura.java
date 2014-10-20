package pesquisa;


import java.sql.SQLException;
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
public class Estrutura {
    
    Banco bd = new Banco();
    
    public boolean Verificar(boolean satisfeito, int nota, String sugestao, String avaliacao, boolean publicar, String nome) throws SQLException, ClassNotFoundException{
        boolean status=false;
        sugestao.trim();
        avaliacao.trim();
        if (sugestao.length()>500)
            JOptionPane.showMessageDialog(null, "O campo sugestão aceita no máximo 250 caracteres.");
        else
            if (avaliacao.length()>500)
                JOptionPane.showMessageDialog(null, "O campo avaliação aceita no máximo 250 caracteres.");
            else
                if((publicar && nome.length()>60) || (publicar && nome.equals("")))
                        JOptionPane.showMessageDialog(null, "Nome inválido");
                else
                    if(bd.insert(satisfeito, nota, sugestao, avaliacao, publicar, nome)==true)
                        status=true;               
        return status;
    }
    
}
