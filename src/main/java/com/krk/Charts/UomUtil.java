package com.krk.Charts;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.stereotype.Component;
@Component
public class UomUtil {
	public void generatePieChart(String path,List<Object[]> data) {
		DefaultPieDataset dataset=new DefaultPieDataset();
		for(Object[] ob:data) {
			dataset.setValue(String.valueOf(ob[0]), Double.valueOf(ob[1].toString()));
		}
		JFreeChart chart=ChartFactory.createPieChart("UOM Type And Count", dataset);
		   //PiePlot plot=(PiePlot) chart.getPlot();
		 // PieSectionLabelGenerator lable=new StandardPieSectionLabelGenerator("{ 0 } : {1} {2}",new DecimalFormat("0"),new DecimalFormat("0%"));
		  //plot.setLabelGenerator(lable);
		  try {
			ChartUtils.saveChartAsJPEG(new File(path+"/piechart.jpg"), chart, 550, 550);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void generateBarChart(String path,List<Object[]> data) {
		DefaultCategoryDataset dataset=new DefaultCategoryDataset();
		for(Object[] ob:data) {
			//val,key,lable
			dataset.setValue(Double.valueOf(ob[1].toString()),String.valueOf(ob[0]),String.valueOf(ob[0]) );
		}
		//titile,xaxis,y-axis,dataset
		JFreeChart chart =ChartFactory.createBarChart("Uom Type COunt","Uom Type","count", dataset);
		  try {
				ChartUtils.saveChartAsJPEG(new File(path+"/barchart.jpg"), chart, 550, 550);
			} catch (IOException e) {
				e.printStackTrace();
			}
		
	}

}
