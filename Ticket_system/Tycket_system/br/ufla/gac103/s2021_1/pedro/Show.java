package br.ufla.gac103.s2021_1.pedro;
import java.io.Serializable;
import br.ufla.gac103.s2021_1.base.Evento;
/**
 * Escreva uma descrição da classe Show aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class Show extends EventosPresenciais implements Serializable
{ 
    private String cantor;
    private String nomeTurne;
    private String tipo = "Show";
    private int valorBase = 500; 
    /**
     * Construtor para objetos da classe Show
     */
    public Show(String nome, String local, int valorBase, String tipo, String cantor, String nomeTurne)
    {
        super(nome, local, valorBase, tipo);
        this.cantor = cantor;
        this.nomeTurne = nomeTurne;
        
    }

    public String getCantor(){
        return cantor;
    }
    
    public String getNomeTurne(){
        return nomeTurne;
    }
    
    @Override
    public String toString(){
        String desc = super.toString();
        desc = desc + "Cantor: " + getCantor() + " | " + "Nome da Turnê: " + getNomeTurne() ;
        return desc;
    }
    
    
}
