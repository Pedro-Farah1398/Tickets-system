package br.ufla.gac103.s2021_1.pedro;
import java.io.*;
import java.util.*;
/**
 * Escreva uma descrição da classe InterfaceGeral aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public abstract class InterfaceGeral
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    private static Administracao adm = new Administracao();
    
    public InterfaceGeral(Administracao adm){
        this.adm = adm;  
    }
    
    /**
     * Construtor para objetos da classe InterfaceGeral
     */
    public static void main(String args[])
    {
       
    }
    
    public static void listarSessoes(){
        try {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite o nome do evento que gostaria de listar as sessões: ");
        String nome = entrada.nextLine();
        System.out.println(adm.getSessoes(nome));
        }
        catch(Exception e){
            System.out.println(e.getMessage() + " -> " + "Algo deu errado ao listar as sessões. Favor tentar novamente.");
        }
        
    }

    public static Administracao getAdm(){
        return adm; 
    }
    
    public static Administracao carregarConteudo (){
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Eventos"));
            
            adm = (Administracao)ois.readObject();
            
            ois.close();
            
        } catch (Exception e){
            System.out.println(e.getMessage()); 
        }
        return adm; 
    }
    
    private static void salvarConteudo (){
        String nomeArquivo; 
        
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Eventos")); 
            
            oos.writeObject(adm);
            System.out.println("Conteúdo salvo com sucesso!"); 
            oos.close();
        }catch(IOException e){
            System.out.println(e.getMessage()); 
        }
    }
    
    public static void listarEventos(){
        try{
          String desc = adm.getEventos();
          if(desc != null){
              System.out.println(desc);
          }
          else{
              System.out.println("Não há eventos cadastrados.");
          }
          
         
        }
        catch (Exception e){
            System.out.println(e.getMessage() + " -> " + "Algo deu errado ao listar os eventos. Favor tentar novamente.");
        }
    }
    
    public static void detalharEvento(Administracao adm){
        try{
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("Digite o nome do evento que gostaria de ver os detalhes: ");
        String nome = entrada.nextLine();
        String detalhe = adm.getDetalhe(nome);
        String sessoes = adm.getSessoes(nome);
        String testeVazio = "";
        if(detalhe != null){
            System.out.println(detalhe);
        }
        else{
            System.out.println("Não foi possível encontrar o evento");
        }
        
        if(!sessoes.equals(testeVazio)){
            System.out.println(sessoes);
        }
        
        else{
            System.out.println("Não há sessões para este evento.");
        }
        
        }
        catch(Exception e){
            System.out.println(e.getMessage() + " -> " + "Algo deu errado ao detalhar o evento. Favor tentar novamente.");
        }
        
    }
    

    
}
