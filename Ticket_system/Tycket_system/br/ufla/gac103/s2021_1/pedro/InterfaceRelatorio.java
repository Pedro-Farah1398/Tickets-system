package br.ufla.gac103.s2021_1.pedro;
import java.io.*;
import java.util.Scanner; 



/**
 * Escreva uma descrição da classe InterfaceRelatorio aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class InterfaceRelatorio extends InterfaceGeral implements Serializable
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    private static Relatorio rel ;
    private static Administracao adm = getAdm();

    private static InterfaceUsuario ui; 
    /**
     * Construtor para objetos da classe InterfaceRelatorio
     */
     public InterfaceRelatorio (Administracao adm){
        super(adm);    
    }
    
    public static void main(String[] args) {
        rel = new Relatorio (); 
        
        adm = ui.carregarConteudo();
        
        System.out.println("Olá! Este é o Módulo de Relatório! \n");
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
    
    private static void tratarOpcao (int opcao){
        switch (opcao) {
            case 1:
                listarEstatisticasPorTipo();
                break;
            case 2: 
                listarEstatisticasPorEvento();
                break;
            case 3: 
                graficoEstatisticasPorEvento();
                break;
            case 4:
                break;
            default:
                System.out.println("\nOpcao Invalida!\n");
                break;
        }
    }
    
    private static void menu(){
        System.out.println("O que gostaria de fazer?");
        System.out.println("\n\n1) Listar Estatísticas por tipo");
        System.out.println("2)Listar Estatísticas por evento");
        System.out.println("3)Gráfico Estatísticas por evento");
        System.out.println("4)Sair");
    
        System.out.println();
    }
    
    private static void listarEstatisticasPorTipo (){
        System.out.print(rel.getIngressosPorTipo(adm.getListEventos()));
    }
    
    private static void listarEstatisticasPorEvento (){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite o nome do evento que gostaria de ver as estatísticas: ");
        String nome = entrada.nextLine(); 
        
        System.out.print(rel.getIngressosPorEvento(adm.getListEventos(), nome));
    }
    
    private static void graficoEstatisticasPorEvento(){
        adm.exibir(adm.getListEventos());
    }
}
