package br.ufla.gac103.s2021_1.pedro;

import java.util.Scanner;
import java.util.*;
import java.io.*;
public class InterfaceAdm extends InterfaceGeral implements Serializable 
{
    private static final long serialVersionUID = 1L; 
    
    
    public InterfaceAdm (Administracao adm){
        super(adm);    
    }
    
     public static void main(String[] args) {
        
 
        int opcao;
        Scanner entrada = new Scanner(System.in);
        try{
        do
        {
            menu();
            
            opcao = entrada.nextInt();
            tratarOpcao(opcao);
        
            } while (opcao != 7);  
        }
        catch (Exception e){
            System.out.print(e.getMessage() + " -> " + "Favor digitar a opção corretamente.");
        }
    }
      
    private static void tratarOpcao (int opcao){
        switch (opcao) {
            case 1:
                cadastrarEvento();
                break;
            case 2:
                cadastrarSessao();                
                break;
            case 3:
                listarEventos();
                break;
            case 4:
                detalharEvento(getAdm()); 
                break;
            case 5:
                listarSessoes(); 
                break;
            case 6:
                salvarConteudo();
                break; 
            case 7:
                break; 
            default:
                System.out.println("\nOpcao Invalida!\n");
                break;
        }
    }

    
    public static void menu(){
        System.out.println("\n\n1) Cadastre um novo evento no Sistema!");
        System.out.println("2) Cadastre uma nova sessão para um evento!");
        System.out.println("3) Liste todos os eventos!");
        System.out.println("4) Detalhes sobre um evento.");
        System.out.println("5) Liste as sessões de um evento.");
        System.out.println("6) Salvar.");
        System.out.println("7) Sair.");
        System.out.println();
    }
    
    
    private static  void cadastrarEvento() {
        String tipo; 
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite o tipo do evento que gostaria de cadastrar: ");
        tipo = entrada.nextLine();
        
        switch(tipo){
            case "Filme":
                ArrayList<String> atores = new ArrayList<>();
                System.out.println("Digite o nome do filme: ");
                String nomeFilme = entrada.nextLine();
                System.out.println("Digite o local do filme: ");
                String localFilme = entrada.nextLine();
                System.out.println("Digite o gênero do filme: ");
                String generoFilme = entrada.nextLine();
                System.out.println("Digite a quantidade de atores principais: ");
                int qtdAtores = Integer.parseInt(entrada.nextLine());
                for(int i = 0; i < qtdAtores; i++){
                    System.out.println("Digite o nome do ator: ");
                    String ator = entrada.nextLine();
                    atores.add(ator);
                }
                System.out.println("Digite o diretor do filme: ");
                String diretorFilme = entrada.nextLine();
                System.out.println("Filme cadastrado!");
                
                
                getAdm().cadastrarFilme(nomeFilme, localFilme, 35, "Filme", atores, generoFilme, diretorFilme);
                break; 
                                
            case "Show":
                System.out.println("Digite o nome do show: ");
                String nomeShow = entrada.nextLine();
                System.out.println("Digite o local do show: ");
                String localShow = entrada.nextLine();
                System.out.println("Digite o nome do cantor: ");
                String nomeCantor = entrada.nextLine();
                System.out.println("Digite o nome da turnê do show: ");
                String nomeTurne = entrada.nextLine();
                System.out.println("Show cadastrado!");
                
                getAdm().cadastrarShow(nomeShow, localShow, 500, "Show", nomeCantor, nomeTurne);
                break; 
                
            case "Partida":
                System.out.println("Digite o nome da partida: ");
                String nomePartida = entrada.nextLine();
                System.out.println("Digite o local da partida: ");
                String localPartida = entrada.nextLine();
                System.out.println("Digite o nome do campeonato: ");
                String nomeCampeonato = entrada.nextLine();
                System.out.println("Digite o nome do time da casa: ");
                String nomeTime = entrada.nextLine();
    
                getAdm().cadastrarPartida(nomePartida, localPartida, 100, "Partida", nomeCampeonato, nomeTime);
                System.out.println("Partida cadastrada!");
                break;  
                
            default:
                System.out.println("\nOpcao Invalida!\n");
                break;
        }    
        
    }
    
    private  static void cadastrarSessao(){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite o nome do evento que gostaria de cadastrar uma sessão: ");
        String nome = entrada.nextLine();
       
        System.out.println("Digite a data da sessão: ");
        String data = entrada.nextLine();
        System.out.println("Digite a quantidade de pessoas permitidas: ");
        int qtdPessoas = Integer.parseInt(entrada.nextLine());
        System.out.println("Digite a quantidade de ingressos vendidos: ");
        int ingressos = Integer.parseInt(entrada.nextLine());
        try{
            int check = getAdm().cadastrarSessao(nome, data, qtdPessoas, ingressos);
            if(check == 1){
                System.out.println("Sessão cadastrada!");
            }
            else{
                 System.out.println("Não foi possível cadastrar! Partidas só podem ter uma sessão!");
            }
        }
        catch(NumberFormatException e){
            System.out.print(e.getMessage() + " -> " + "Você deve digitar um número!");
        }
        catch (Exception e){
            System.out.println(e.getMessage() + " -> " + "Algo deu errado ao cadastrar a sessão. Favor tentar novamente. "); 
        }
    }
        
    
    private  static void salvarConteudo (){
        
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Eventos")); 
            
            oos.writeObject(getAdm());
            System.out.println("Conteúdo salvo com sucesso!"); 
            oos.close();
        }catch(IOException e){
            System.out.println(e.getMessage()); 
        }
    }
}

