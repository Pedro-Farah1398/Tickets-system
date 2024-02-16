package br.ufla.gac103.s2021_1.pedro;

import java.io.Serializable;
import java.util.*; 
import java.io.*;
/**
 * Escreva uma descrição da classe CompraIngresso aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class CompraIngresso implements Serializable
{
   private ArrayList<Ingresso> ingressos;
   private Administracao adm; 
   ArrayList<String> cadeiras; 
   
   public CompraIngresso()
    {
        adm = new Administracao();
        ingressos = new ArrayList<>();
        cadeiras = new ArrayList<>();
    }
    
   // Método para comprar ingressos
   public int comprarIngresso(List<EventosPresenciais> list, String nome, String dataSessao, String nomeComprador, ArrayList<String>numeroCadeira, 
   String tipoIngresso, int qtdIngressos){
       
       double valorTotal = 0.0;
       // Verifica o tipo do ingresso
       for (EventosPresenciais e: list){
           if(e.getNome().equals(nome)){
               switch(tipoIngresso){
                   case "Comum":
                   valorTotal = (e.getValorBase());
                   break; 
                   case "Meia-Entrada":
                   valorTotal = e.getValorBase()/2;
                   break;
                   case "Desconto":
                   valorTotal = e.getValorBase() * 0.8;
                   break;
               
               }
               // Cadastra um ingresso para uma sessão com data específica. Verifica se a cadeira está desocupada. 
               for(int i = 0; i < qtdIngressos; i++){
                   for(Sessao s: e.getSessao()){
                       if(s.getData().equals(dataSessao)){
                           if(s.getQtdIngressos() < s.getQtdPessoas()){
                               if(s.getCadeiras().contains(numeroCadeira.get(i))){
                                   throw new IndexOutOfBoundsException();
                               }
                               s.cadastrarIngresso((new Ingresso( dataSessao,e.getNome(), tipoIngresso,  nomeComprador, numeroCadeira.get(i), (valorTotal + 0.10*valorTotal))));
                               s.addCadeiras(numeroCadeira.get(i)); 
                           // Aumenta a quantidade de Ingressos vendidos para esta sessão    
                           if(s.getData().equals(dataSessao)){
                               s.setQtdIngressos();
                           }
                       }
                       else{
                           return 0; 
                       }
                    }
                   }
                }
           }
       }
       return 1; 
    }
    
    // Imprime os ingressos em um txt
    public void imprimirIngressos(List<EventosPresenciais> list){
        try{
            FileWriter arq = new FileWriter("Ingressos.txt");
            for (EventosPresenciais e: list){    
                for(Sessao s: e.getSessao()){
                    for(Ingresso i: s.getIngressos()){
                        arq.write( i.toString() + "\n");
                    }
                }
            }
            arq.close();
            } catch(Exception e){
            e.getMessage();
        }
    }
}
