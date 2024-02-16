package br.ufla.gac103.s2021_1.pedro;

import java.util.*; 
import java.io.Serializable; 
/**
 * Escreva uma descrição da classe Filme aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class Filme extends EventosPresenciais implements Serializable
{
  
    private String genero;
    private List<String> atores;
    private String diretor;
    private String tipo = "Filme";
    private int valorBase = 35; 

    /**
     * Construtor para objetos da classe Filme
     */
    public Filme(String nome, String local, String tipo, int valorBase, ArrayList<String> atores, String genero, String diretor)
    {
        super(nome, local, valorBase, tipo);
        this.genero = genero;
        this.diretor = diretor; 
        this.atores = atores;
        
    }

    public String getGenero(){
        return genero; 
    }
    
    public String getDiretor(){
        return diretor; 
    }
    
    @Override
    public String toString(){
        String desc = super.toString();
        List<String> listAtores = Collections.unmodifiableList((atores)); 
        String at = ""; 
        for(String s: listAtores){
            at = at + s + "  ";
        }
        desc = desc + "Gênero: " + getGenero() + " | " + "Atores: " + at + " | " + "Diretor: "+ getDiretor();
        return desc; 
    }
}
