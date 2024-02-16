package br.ufla.gac103.s2021_1.pedro;
import java.io.Serializable; 
import java.util.*;
/**
 * Escreva uma descrição da classe Sessao aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class Sessao implements Serializable
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    private String data;
    private int qtdPessoas;
    private int qtdIngressos; 
    private String nome; 
    private ArrayList<Ingresso> ingressos;
    private ArrayList<String> cadeiras;
    /**
     * Construtor para objetos da classe Sessao
     */
    public Sessao(String nome, String data, int qtdPessoas, int qtdIngressos)
    {
        this.nome = nome; 
        this.data = data;
        this.qtdPessoas = qtdPessoas; 
        this.qtdIngressos = qtdIngressos; 
        ingressos = new ArrayList<>(); 
        cadeiras = new ArrayList<>();
    }

    public String getData(){
        return data;
    }
    
    public int getQtdPessoas(){
        return qtdPessoas; 
    }
    
    public int getQtdIngressos(){
        return qtdIngressos; 
    }
    
    public void setQtdIngressos(){
        this.qtdIngressos++; 
    }
    
    public List<Ingresso> getIngressos(){
        return Collections.unmodifiableList(ingressos); 
    }
    
    public List<String> getCadeiras(){
        return Collections.unmodifiableList(cadeiras); 
    }
    
    public void cadastrarIngresso(Ingresso i ){
        ingressos.add(i);
    }
    
    public void addCadeiras (String numero){
        cadeiras.add(numero);
    }
    
    
    @Override
    public String toString(){
        String cadOcupadas = "";
    
        String desc = "Data: " + getData() + " | " + "Capacidade: " + getQtdPessoas() + " | " + "Ingressos vendidos: " + getQtdIngressos() ;
        return desc;
    }
}
