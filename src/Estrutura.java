
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
    
    public void Verificar(boolean satisfeito, int nota, String sugestao, String avaliacao, boolean publicar, String nome){
        sugestao.trim();
        avaliacao.trim();
        if (sugestao.length()>255)
            JOptionPane.showMessageDialog(null, "O campo sugestão aceita no máximo 250 caracteres.");
        else
            if (avaliacao.length()>255)
                JOptionPane.showMessageDialog(null, "O campo avaliação aceita no máximo 250 caracteres.");
            else
                if((publicar && nome.length()>60) || (publicar && nome.equals("")))
                        JOptionPane.showMessageDialog(null, "Nome inválido");
                else
                    if(bd.insert(satisfeito, nota, sugestao, avaliacao, publicar, nome))
                        JOptionPane.showMessageDialog(null, "Inclusão efetuada com sucesso!");
                    else
                        JOptionPane.showMessageDialog(null, "Erro ao inserir as informações no banco de dados.");
    }
    
}
