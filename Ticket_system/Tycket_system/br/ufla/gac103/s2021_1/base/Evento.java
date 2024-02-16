package br.ufla.gac103.s2021_1.base;

/**
 * Escreva a descrição da interface Evento aqui.
 * 
 * @author (seu nome aqui) 
 * @version (um número da versão ou data aqui)
 */


public interface Evento
{
    // Nome do evento (ex: "Harry Potter e a Pedra Filosofal", "Músicas Raiz", "Brasil x Argentina")
    String getNome();
    // Tipo do evento (deve indicar se é um filme, um show ou uma partida de futebol)
    String getTipo();    
}
