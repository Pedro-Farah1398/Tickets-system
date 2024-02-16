package br.ufla.gac103.s2021_1.pedro;
import java.util.*;
import br.ufla.gac103.s2021_1.base.Grafico;
import br.ufla.gac103.s2021_1.base.EstatisticaEvento;

/**
 * Escreva uma descrição da classe Relatorio aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class Relatorio 
{
  
   
    List<EventosPresenciais> eventos;
    
    /**
     * Construtor para objetos da classe Relatorio
     */
    public Relatorio()
    {
        
        eventos = new ArrayList<>();
    }

    // Agrega a quantidade de ingressos por tipo de evento
    public String getIngressosPorTipo(List<EventosPresenciais> listEventos)
    {
        double valorTotalFilme = 0.0;
        int qtdTotalFilme = 0; 
        double valorTotalShow = 0.0;
        int qtdTotalShow = 0; 
        double valorTotalPartida = 0.0;
        int qtdTotalPartida = 0; 
        for(EventosPresenciais e: listEventos){
            // Caso seja Filme, para todas as sessões, pega todos os ingressos e agrega
            if(e.getTipo().equals("Filme")){
                for(Sessao s: e.getSessao()){
                    qtdTotalFilme = qtdTotalFilme + s.getQtdIngressos();
                    if(s.getQtdIngressos() != 0){
                    for (Ingresso i : s.getIngressos()){
                        valorTotalFilme = valorTotalFilme + (i.getValor());
                    }
                }
                    
                }
            }
            
             // Caso seja Show, para todas as sessões, pega todos os ingressos e agrega
            if(e.getTipo().equals("Show")){
                for(Sessao s: e.getSessao()){
                    qtdTotalShow = qtdTotalShow + s.getQtdIngressos();
                    if(s.getQtdIngressos() != 0){
                    for (Ingresso i : s.getIngressos()){
                        valorTotalShow = valorTotalShow + i.getValor();
                    }      
                }
            }
            }
            
             // Caso seja Partida, para todas as sessões (1), pega todos os ingressos e agrega
            if(e.getTipo().equals("Partida")){
                for(Sessao s: e.getSessao()){
                    qtdTotalPartida = qtdTotalPartida + s.getQtdIngressos();
                    if(s.getQtdIngressos() != 0){
                    for (Ingresso i : s.getIngressos()){
                        valorTotalPartida = valorTotalPartida + i.getValor();
                    }
                }      
                }
            }
            
        }
        String desc = " ";
        desc = "Filme (Total Ingressos / Total Valor) " + String.valueOf(qtdTotalFilme) + " / " + String.valueOf(valorTotalFilme) + "\n";
        desc = desc + "Show (Total Ingressos / Total Valor) " + String.valueOf(qtdTotalShow) + " / " + String.valueOf(valorTotalShow) + "\n";
        desc = desc + "Partida (Total Ingressos / Total Valor) " + String.valueOf(qtdTotalPartida) + " / " + String.valueOf(valorTotalPartida) + "\n";
    
        return desc;
 }
 
 // Mesmo comportamento acima, porém para evento específico. 
 public String getIngressosPorEvento(List<EventosPresenciais> listEventos, String nome)
    {
        double valorTotalEvento = 0.0;
        int qtdTotalEvento = 0; 
        for(EventosPresenciais e: listEventos){
            if(e.getNome().equals(nome)){
                for (Sessao s: e.getSessao()){
                    qtdTotalEvento = qtdTotalEvento + s.getQtdIngressos();
                    for(Ingresso i: s.getIngressos()){
                         if(i.getTipo().equals("Comum")){
                            switch(e.getTipo()){
                                case "Filme":
                                valorTotalEvento = s.getQtdIngressos() *  (38.5);
                                break;
                                case "Show":
                                valorTotalEvento = s.getQtdIngressos() *  (550);
                                break;
                                case "Partida":
                                valorTotalEvento = s.getQtdIngressos() * (30.8);
                                break;
                            }
                            
                        }
                        if(i.getTipo().equals("Meia-Entrada")){
                            switch(e.getTipo()){
                                case "Filme":
                                valorTotalEvento = s.getQtdIngressos() *  (19.25);
                                break;
                                case "Show":
                                valorTotalEvento = s.getQtdIngressos() *  (275);
                                break;
                                case "Partida":
                                valorTotalEvento = s.getQtdIngressos() *  (440);
                                break;
                            }
                          
                        }
                        if(i.getTipo().equals("Desconto")){
                            switch(e.getTipo()){
                                case "Filme":
                                valorTotalEvento = s.getQtdIngressos() *  (30.8);
                                break;
                                case "Show":
                                valorTotalEvento = s.getQtdIngressos() *  (550);
                                break;
                                case "Partida":
                                valorTotalEvento = s.getQtdIngressos() *  (88);
                                break;
                            }
                            
                        }
                    }
                }
            }
        }
        String desc = " ";
        desc = " (Total Ingressos / Total Valor) " + String.valueOf(qtdTotalEvento) + " / " + String.valueOf(valorTotalEvento) + "\n";
        
    
        return desc;
    }
 
}
