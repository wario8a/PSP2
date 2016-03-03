//Nombre del Programa: Statistics
//Autor: Mario Andres Ochoa Camacho
//Fecha: 02/02/2016
//Descripcion: Clase que calcula variables estadisticas como Media y Desviaicon Estandar, obteniendo sus datos de una LinkedList
//donde sus componentes son String que deben ser posibles convertibles a numeros decimales

//Import: java.util.LinkedList
//Paquete: Statistics
//Clase: Statistics
//Metodos: Mean, StandardDeviation

//Instrucciones de Uso:
//Tanto el Metodo Media y Desviacion Estandar reciben como parametros una LinkedList las cual debe contener un arreglo de String
//y cada componente debe ser convertible a un numero decimal de lo contrario se generara un error

package Statistics;

import java.util.LinkedList;

public class Statistics {

	public static double Mean(LinkedList<String> _LinkedList){
		
		double Mean = 0.0;
		
		if(!_LinkedList.isEmpty()){
			for (Object item : _LinkedList)
			      Mean += new Double(item.toString());
			
			Mean = Mean/_LinkedList.size();
		}
		
		return Mean;
	}
	
	public static double StandardDeviation(LinkedList<String> _LinkedList){
		double dbStanDev =0.0;
		
		if(!_LinkedList.isEmpty()){
			
			double Mean = Mean(_LinkedList);
			
			for (Object item : _LinkedList)
				dbStanDev += Math.pow(new Double(item.toString()) - Mean,2);
			
			dbStanDev = Math.pow(dbStanDev/(_LinkedList.size() - 1),0.5);
		}
		
		return dbStanDev;
	}
	
	private static double Summatory(double [] values){
		double summatory=0;
		
		for(int count=0; count < values.length; count++){
			summatory += values[count];
		}
		
		return summatory;
	}
	
	private static double PotSummatory(double [] values, int pot){
		double potSummatory=0;
		for(int count=0; count < values.length; count++){
			potSummatory += Math.pow(values[count],2);
		}				
		return potSummatory;
	}
	
	private static double ProdSummatory(double [] xvalues, double [] yvalues){
		double prodsummatory=0;
		
		if(xvalues.length == yvalues.length){
			for(int count=0; count < xvalues.length; count++){
				prodsummatory += xvalues[count] * yvalues[count];
			}		
		}else{
			return 0;
		}		
		return prodsummatory;
	}	
	
	private static double Average(double [] values){
		return Summatory(values)/values.length;
	}
	
	public static double LinearRegrationCalcb0(double [] xvalues, double [] yvalues){
		return Average(yvalues) - LinearRegrationCalcb1(xvalues, yvalues) * Average(xvalues);
	}
	
	public static double LinearRegrationCalcb1(double [] xvalues, double[] yvalues){
		double b1=0;
		double divisor =1;
		if(xvalues.length == yvalues.length){
			b1 = ProdSummatory(xvalues,yvalues) - xvalues.length*Average(xvalues)*Average(yvalues);
			divisor = PotSummatory(xvalues,2) - xvalues.length*Math.pow(Average(xvalues),2);						
		}else{
			return 0;
		}
		return b1/ divisor;
	}
	
	public static double LinearRegrationCalcCorrelation(double [] xvalues, double[] yvalues){
		double correlation=0;
		double divisor =1;
		if(xvalues.length == yvalues.length){
			correlation = xvalues.length * ProdSummatory(xvalues, yvalues) - Summatory(xvalues) * Summatory(yvalues);
			divisor = Math.pow((xvalues.length * PotSummatory(xvalues,2) - Math.pow(Summatory(xvalues), 2))*((yvalues.length * PotSummatory(yvalues,2) - Math.pow(Summatory(yvalues), 2))), 0.5);
		}else{
			return 0;
		}	
		
		return correlation/ divisor;
	}
}
