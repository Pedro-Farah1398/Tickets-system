package br.ufla.gac103.s2021_1.pedro;

import java.util.Scanner;
import java.util.*;
import java.io.*;
/**
 * Escreva uma descrição da classe InterfaceUsuario aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class InterfaceUsuario extends InterfaceGeral implements Serializable 
{
     private static Administracao admIn = getAdm();
     private static CompraIngresso compIng; 
     
    public InterfaceUsuario (Administracao adm){
        super(adm);    
    }
     
     public static void main(String[] args) {
        compIng = new CompraIngresso();
        
        admIn =  carregarConteudo(); 
        
        System.out.println("Olá! Tudo bem? Você está na área de Compra de Ingressos! \n");
        System.out.println("Estes são os eventos cadastrados: \n");
        System.out.println(admIn.getEventos()); 
        
        int opcao;
        Scanner entrada = new Scanner(System.in);
        try{
        do
        {
            menu();
            
            opcao = entrada.nextInt();
            tratarOpcao(opcao);
        
            } while (opcao != 4);  
        }
        catch (Exception e){
            System.out.print(e.getMessage() + " -> " + "Favor digitar a opção corretamente.");
        }
    }
    
    private static void menu(){
        
        System.out.println("\n O que gostaria de fazer? "); 
        System.out.println("\n\n1) Escolher eventos. ");
        System.out.println("2) Comprar Ingresso.");
        System.out.println("3) Imprimir ingressos.");
        System.out.println("4) Sair.");
        System.out.println();
    }
    
    public static Administracao carregarConteudo (){
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Eventos"));
            
            admIn = (Administracao)ois.readObject();
            
            ois.close();
            
        } catch (Exception e){
            System.out.println(e.getMessage()); 
        }
        return admIn;
        
    }
    
    private static void salvarConteudo (){
        String nomeArquivo; 
        
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Eventos")); 
            
            oos.writeObject(admIn);
            System.out.println("Conteúdo salvo com sucesso!"); 
            oos.close();
        }catch(IOException e){
            System.out.println(e.getMessage()); 
        }
    }
    
    private static void tratarOpcao (int opcao){
        switch (opcao) {
            case 1:
                detalharEvento(admIn); 
                break;
            case 2:
                comprarIngresso();
                break; 
            case 3:
                imprimirIngressos(); 
                break; 
            case 4:
                break; 
            default:
                System.out.println("\nOpcao Invalida!\n");
                break;
        }
    }
    
    private static void comprarIngresso(){
        ArrayList<String> cadeiras = new ArrayList<>();
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite o nome do evento que gostaria de escolher uma sessão: ");
        String nomeEvento = entrada.nextLine();
        System.out.println("Digite o tipo do ingresso que gostaria de escolher: ");
        subMenu();
        String tipo = "";
        
        int opcaoIngresso = Integer.parseInt(entrada.nextLine());
        System.out.println("Digite a data da sessão:  ");
        String data = entrada.nextLine();
        System.out.println("Digite o seu nome:  ");
        String nomeUsuario = entrada.nextLine();
        System.out.println("Digite a quantidade de ingressos que você deseja:  ");
        try{
        
        int qtdIngressos = Integer.parseInt(entrada.nextLine());
        
        for(int i = 0; i < qtdIngressos; i++){
                System.out.println("Digite o(s) número(s) da cadeira:  ");
                String numCadeira = entrada.nextLine();
                cadeiras.add(numCadeira);
        }
        
        switch(opcaoIngresso){
            case 1:
                tipo = "Comum";
                break;
            case 2:
                tipo = "Meia-Entrada";
                break;
            case 3:
                tipo = "Desconto";
                break;
                
        }
        try {
            int i = compIng.comprarIngresso(admIn.getListEventos(),nomeEvento, data, nomeUsuario, cadeiras, tipo, qtdIngressos);
            if(i == 1){
                System.out.println(qtdIngressos + "  ingressos do tipo " + tipo + " comprado(s) com sucesso!");
            }
            else{
                System.out.println("Sinto muito, mas não há essa quantidade de ingressos disponíveis.");
            }
        }catch (Exception IndexOutOfBoundsException){
            System.out.println(" - > " + "Uma cadeira que você digitou está ocupada! Verifique quais estão livres");
            
        }
        
        } catch(Exception e){
            System.out.println(e.getMessage() + " -> " + "Favor, digitar um número");
        }
        
    }
    
    private static void subMenu(){
        
        

        System.out.println("\t1) Comum. ");
        System.out.println("\t2) Meia Entrada");
        System.out.println("\t3) Desconto");
        System.out.println();
        
        
        
    }
    
    private static void imprimirIngressos(){
        compIng.imprimirIngressos(admIn.getListEventos());
        salvarConteudo();
        System.out.println("Ingressos impressos com sucesso!");
    }
    
    

}
