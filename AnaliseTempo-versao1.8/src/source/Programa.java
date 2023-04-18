package source;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.BorderFactory;
import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class Programa extends JFrame {
	long t[];

	public Programa() {
		initUI();
	}
	
	public void initUI() {
		XYDataset dataset = createDataset();
        JFreeChart chart = createChart(dataset);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel.setBackground(Color.white);
        add(chartPanel);

        pack();
        setTitle("Line chart");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	 private XYDataset createDataset() {
		 
		 Principal p = new Principal();
		 Heapsort h = new Heapsort();
		 XYSeries series = new XYSeries("bubblesort");
	        /*series.add(18, 567);
	        series.add(20, 612);
	        series.add(25, 800);
	        series.add(30, 980);
	        series.add(40, 1410);
	        series.add(50, 2350);*/
		 
		 
		 long t[] = p.executeBubble();
		 for(int x=0;x<t.length;x++) {
			 series.add(x,t[x]);
		 }

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);
        series = new XYSeries("heapsort");
        
		t = h.execute();
		for(int x=0;x<t.length;x++) {
			series.add(x,t[x]); 
		}
		dataset.addSeries(series);
		
		series = new XYSeries("selectionsort");
		t = p.executeSelection();
		for(int x=0;x<t.length;x++) {
			series.add(x,t[x]); 
		}
		dataset.addSeries(series);
		
		series = new XYSeries("Radixsort");
		t = new Radix().execute();
		for(int x = 0; x<t.length;x++) {
			series.add(x, t[x]);
		}
		dataset.addSeries(series);
        return dataset;
	    }
	 
	 private JFreeChart createChart(XYDataset dataset) {

	        JFreeChart chart = ChartFactory.createXYLineChart(
	                "Tempo de execucao de algoritmo",
	                "Tamanho dados",
	                "Tempo execucao",
	                dataset,
	                PlotOrientation.VERTICAL,
	                true,
	                true,
	                false
	        );

	        XYPlot plot = chart.getXYPlot();

	        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
	        renderer.setSeriesPaint(0, Color.RED);
	        renderer.setSeriesStroke(0, new BasicStroke(2.0f));
	        
	        renderer.setSeriesPaint(1, Color.GREEN);
	        renderer.setSeriesStroke(1, new BasicStroke(2.0f));
	        
	        renderer.setSeriesPaint(2, Color.CYAN);
	        renderer.setSeriesStroke(2, new BasicStroke(2.0f));
	        
	        renderer.setSeriesPaint(3, Color.LIGHT_GRAY);
	        renderer.setSeriesStroke(3, new BasicStroke(2.0f));

	        plot.setRenderer(renderer);
	        plot.setBackgroundPaint(Color.white);

	        plot.setRangeGridlinesVisible(true);
	        plot.setRangeGridlinePaint(Color.BLACK);

	        plot.setDomainGridlinesVisible(true);
	        plot.setDomainGridlinePaint(Color.BLACK);

	        chart.getLegend().setFrame(BlockBorder.NONE);

	        chart.setTitle(new TextTitle("Tempo de execucao de algoritmos",
	                        new Font("Serif", java.awt.Font.BOLD, 18)
	                )
	        );

	        return chart;
	    }

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		EventQueue.invokeLater(() -> {

			Programa ex = new Programa();
            ex.setVisible(true);
        });
	}

}
