package br.ufla.gac103.s2021_1.pedro;

import java.util.*;
import br.ufla.gac103.s2021_1.base.Evento;
import br.ufla.gac103.s2021_1.base.EstatisticaEvento;
import java.io.*;
/**
 * Escreva uma descrição da classe EventosPresenciais aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public abstract class EventosPresenciais implements Evento, Serializable, EstatisticaEvento
{ 
    private String nome;
    private String local; 
    private float valorBase;
    private String tipo; 
    private ArrayList<Sessao> sessoes; 
 
    
    /**
     * Construtor para objetos da classe Show
     */
    public EventosPresenciais(String nome, String local, float valorBase, String tipo)
    {
        this.nome = nome;
        this.local = local;
        this.valorBase = valorBase;
        this.tipo = tipo; 
        sessoes = new ArrayList<>();
        
    }
    
    @Override
    public EventosPresenciais getEvento(){
        return this; 
    }
    
    @Override
    public int totalIngressos(){
        EventosPresenciais e = this; 
        int total = 0; 
        for (Sessao s: e.getSessao()){
            total = total + s.getQtdIngressos();
        }; 
        return total; 
    }

    @Override
    public String getNome(){
        return nome;
    }
    
    
    public List<Sessao> getSessao(){
        return Collections.unmodifiableList(sessoes); 
    }
    
    @Override
    public String getTipo(){
        return tipo;
    }
    
    public String getLocal () {
        return local;
    }
    
    public float getValorBase(){
        return valorBase;
    }
    
    @Override
    public String toString(){
        String desc = "Nome: " + getNome() + " | " + "Tipo: " + getTipo() + " | " + "Local: " + getLocal() + " | ";
        return desc;
    }

    public void cadastrarSessao(Sessao s){
            sessoes.add(s) ;
        
    }
    
}
