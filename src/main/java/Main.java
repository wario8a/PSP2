import java.sql.*;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;
import java.net.URI;
import java.net.URISyntaxException;

import static spark.Spark.*;
import spark.template.freemarker.FreeMarkerEngine;
import spark.ModelAndView;
import static spark.Spark.get;

import com.heroku.sdk.jdbc.DatabaseUrl;

import java.io.File;
import java.util.LinkedList;

import FileManager.FileManager;
import Statistics.Statistics;

public class Main {

  public static void main(String[] args) {

    port(Integer.valueOf(System.getenv("PORT")));
    staticFileLocation("/public");

    get("/PSP2", (req, res) -> GetResult());
    
    
  }
  
  private static double [] ConvertListToArray(LinkedList<String> linkedList, int column){
		double [] values = new double[linkedList.size()];
		int count=0;
		
		for (String item : linkedList)
		{
			values[count] = new Double(item.split(";")[column]);
			count++;
		}
		
		return values;
	}

  private static StringBuilder GetResult(){
	  
	  StringBuilder result = new StringBuilder();
	  result.append("PSP2 Calculo de Parametros Regresion Lineal!!!\n");
		
		for(int count = 1; count <= 4 ;count++){
		
			result.append("Test" + count +":\n");			
			LinkedList<String> linkedList = FileManager.ReadFile("D:\\ECOS\\Proyects\\PSP2\\src\\main\\java\\data\\test" + count +".txt");			
			double [] xvalues = ConvertListToArray(linkedList,0);
			double [] yvalues = ConvertListToArray(linkedList,1);
			
			double calcb1 = Statistics.LinearRegrationCalcb1(xvalues, yvalues);
			double calcb0 = Statistics.LinearRegrationCalcb0(xvalues, yvalues);
			double correlation = Statistics.LinearRegrationCalcCorrelation(xvalues, yvalues);
			double Yk = calcb0 + calcb1 * 386 ;
			
			result.append("Calculo B0: " +  calcb0 + "\n");
			result.append("Calculo B1: " +  calcb1+ "\n");			
			result.append("Calculo r: " +  correlation+ "\n");
			result.append("Calculo r2: " +  Math.pow(correlation, 2)+ "\n");
			result.append("Calculo Yk = 386: " + Yk + "\n");
		}
		return result;
  }
}
