package br.ufla.gac103.s2021_1.base;

import javax.swing.JFrame;  
import javax.swing.SwingUtilities;  
import java.util.List;
import java.io.Serializable; 
  
import org.jfree.chart.ChartFactory;  
import org.jfree.chart.ChartPanel;  
import org.jfree.chart.JFreeChart;  
import org.jfree.data.category.DefaultCategoryDataset;  
      
public class Grafico implements Serializable {
    
   
    
    public void exibir(String tituloGrafico, List<EstatisticaEvento> dados) {
        SwingUtilities.invokeLater(() -> {
            GraficoBarra tela = new GraficoBarra(tituloGrafico, dados);
            tela.setAlwaysOnTop(true);
            tela.pack();
            tela.setSize(600, 400);
            tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            tela.setVisible(true);
        });  
    }  
    
    private class GraficoBarra extends JFrame {  
          
        private static final long serialVersionUID = 1L;  
        
        public GraficoBarra(String titulo, List<EstatisticaEvento> dados) {  
            super(titulo);  
              
            DefaultCategoryDataset dataset = criarDataset(dados);
            
            JFreeChart graficoBarra = ChartFactory.createBarChart(
                titulo, // Titulo do Grafico
                "Evento", // Eixo X
                "Numero Ingressos", // Eixo Y
                dataset);
            
            ChartPanel painel = new ChartPanel(graficoBarra);  
            setContentPane(painel); 
        }  
        
        private DefaultCategoryDataset criarDataset(List<EstatisticaEvento> dados) {          
            String serie = "Ingressos por Evento"; 
            
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();  
            
            for (EstatisticaEvento dado : dados) {
                dataset.addValue(dado.totalIngressos(), serie, dado.getEvento().getNome());  
            }
            
            return dataset;  
        }       
    }
}