/**
 * 
 */
package com.sapient.Fee_Calculator;

/**
 * @author Pankush
 *
 */
import java.io.IOException;
import java.util.List;

public class Runner {

public static void main(String[] args)  

	{
	String inputFile = "input.csv";
	String outputFile = "output.csv";
	
	ReadWriteFile rwf=new ReadWriteFile();
	List<AttributesPojo> InputList=null;
	
	try {
			InputList = rwf.ReadFile(inputFile);
		} 
	catch (IOException e)
		{
		
			e.printStackTrace();
		}
	
	Feecalculation fc=new Feecalculation();
	List<String> OutputList=fc.calculate(InputList);
	
	try
		{
			rwf.WriteFile(OutputList,outputFile);
		}
	
	catch (IOException e) 
		{
			e.printStackTrace();
		}
	
	}
	
}
