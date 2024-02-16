package br.ufla.gac103.s2021_1.pedro;
import java.util.*;
import java.io.*;
public  class Ingresso implements Serializable
{
    private String dataSessao;
    private String nomeSessao;
    private String tipo; 
    private String nomeComprador;
    private String numeroCadeira;
    private double valor;
    

    /**
     * Construtor para objetos da classe Ingresso
     */
    public Ingresso(String dataSessao, String nomeSessao,  String tipo,  String nomeComprador, String numeroCadeira, double valor)
    {
        this.dataSessao = dataSessao; 
        this.nomeSessao = nomeSessao;
        this.tipo = tipo; 
        this.nomeComprador = nomeComprador; 
        this.numeroCadeira = numeroCadeira; 
        this.valor = valor; 
    }

    public String getDataSessao(){
        return dataSessao; 
    }
    
    public String getNomeSessao(){
        return nomeSessao; 
    }
    
    public String getTipo(){
        return tipo; 
    }
    
    private static List<String> stringToList (String cadeiras){
        List<String> list = new ArrayList<>();
        list = Arrays.asList(cadeiras.split(","));
        return list;
    }

    
    public String getNomeComprador(){
        return nomeComprador; 
    }
    
    public String getNumeroCadeira(){
        return numeroCadeira; 
    }
    
    @Override
    public String toString(){
        List<String> listCadeiras = Collections.unmodifiableList(stringToList(getNumeroCadeira())); 
        String cad = ""; 
        for(String s: listCadeiras){
            cad = cad + s + "  ";
        }
        String desc = "Evento : " +  getNomeSessao() + "Data : " +  getDataSessao() + " | " +"Cadeira : " +  cad + " | " + "Nome : "  + getNomeComprador() + " | " + "Preço : "  + getValor();
        return desc;
    }
    
    public double getValor(){
        return valor; 
    }
}

