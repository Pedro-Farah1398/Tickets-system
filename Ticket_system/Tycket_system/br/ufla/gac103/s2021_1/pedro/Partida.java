package br.ufla.gac103.s2021_1.pedro;


/**
 * Escreva uma descrição da classe Partida aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class Partida extends EventosPresenciais
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    private String campeonato;
    private String timeCasa;
    private String tipo = "Partida";
    private int valorBase = 100; 

    /**
     * Construtor para objetos da classe Partida
     */
    public Partida(String nome, String local, String tipo, int valorBase, String campeonato, String timeCasa)
    {
        super(nome, local, valorBase, tipo);
        this.campeonato = campeonato;
        this.timeCasa = timeCasa;
    }

    public String getCampeonato(){
        return campeonato;
    }
    
    public String getTimeCasa(){
        return timeCasa; 
    }
    
    @Override
    public String toString(){
        String desc = super.toString();
        desc = desc + "Campeonato: " + getCampeonato() + " | " + "Time da casa: " + getTimeCasa() ;
        return desc;
    }
}
