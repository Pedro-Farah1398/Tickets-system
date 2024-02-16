package br.ufla.gac103.s2021_1.pedro;
import br.ufla.gac103.s2021_1.base.EstatisticaEvento; 
import br.ufla.gac103.s2021_1.base.Grafico; 
import java.io.Serializable;
import java.util.*; 
import java.io.*;
/**
 * Escreva uma descrição da classe Administracao aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class Administracao implements Serializable
{
    private ArrayList<EventosPresenciais> eventos;
    private static final long serialVersionUID = 1L;
    private ArrayList<EstatisticaEvento> est; 
    private Grafico graf; 
    /**
     * Construtor para objetos da classe Administracao
     */
    public Administracao()
    {
        eventos = new ArrayList <EventosPresenciais>();   
        graf = new Grafico();
        est = new ArrayList<EstatisticaEvento>();
    }

    public void cadastrarFilme(String nome, String local, int valorBase, String tipo,  ArrayList<String> atores, String genero, String diretor)
    {
        eventos.add(new Filme(nome,local, tipo, valorBase, atores, genero, diretor ));
    }
    
    public void cadastrarShow(String nome, String local, int valorBase, String tipo,String cantor, String nomeTurne)
    {
        eventos.add(new Show(nome,local, valorBase, tipo, cantor, nomeTurne));
    }
    
    public void cadastrarPartida(String nome, String local,int valorBase, String tipo,String campeonato, String timeCasa)
    {
        eventos.add(new Partida(nome,local,tipo, valorBase ,campeonato, timeCasa));
    }
    
    public List<EventosPresenciais> getListEventos(){
        return Collections.unmodifiableList(eventos); 
    }
    
    //Lista todos os eventos
    public String getEventos(){
        String desc = ""; 
        if(eventos.isEmpty()){
            return null; 
        }
        else{
        for (EventosPresenciais evento: eventos){
            desc = desc + evento.getTipo() + " -> " + evento.getNome() + "\n";
        }
        }
        return desc; 
    }
    
    // Retorna informações detalhadas de determinado evento
    public String getDetalhe(String nome){
        boolean found = false;
        for (EventosPresenciais e: eventos){
            if(e.getNome().equals(nome)){
                String detalhes = e.toString(); 
                found = true;
                return detalhes; 
                
            }
            
        }
        
        return null; 
   
    }
    
    // Cadastra uma sessão para um evento com este nome
    public int cadastrarSessao(String nome, String data, int qtdPessoas, int qtdIngressos){ 
        for (EventosPresenciais e: eventos){
            if(e.getNome().equals(nome)){
                if(e.getTipo().equals("Partida")){
                    if(e.getSessao().isEmpty() ){
                        e.cadastrarSessao(new Sessao(e.getNome(),data, qtdPessoas, qtdIngressos));
                    }
                    else{
                        return 0; 
                    }
                }
                else{
                    e.cadastrarSessao(new Sessao(e.getNome(),data, qtdPessoas, qtdIngressos));
                }
            }
            }
        return 1; 
        }
    
    // Método que exibe o gráfico (usado na Interface Relatório)
    public void exibir(List<EventosPresenciais> list){
        for(EventosPresenciais e: list){
            est.add(e); 
        }
        graf.exibir("Gráfico Ingressos x Evento", est);
    }
      
    // Retorna as Informações das sessões cadastradas de determinado evento
    public String getSessoes(String nome){
        String sessoes = ""; 
        
         for (EventosPresenciais e: eventos){
             List<Sessao> list = e.getSessao();
            if(e.getNome().equals(nome)){ 
                for (Sessao s: list){
                    String cadOcupadas = "";
                    for(Ingresso i: s.getIngressos()){
                        cadOcupadas = cadOcupadas + " " +  i.getNumeroCadeira();
                    }
                    sessoes = sessoes + s.toString() + " | " + "Cadeiras ocupadas: " + cadOcupadas + "\n"; 
                    
                }
        }
    }
        return sessoes; 
    }
    
    
}
