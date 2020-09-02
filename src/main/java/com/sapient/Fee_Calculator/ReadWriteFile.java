/**
 * 
 */
package com.sapient.Fee_Calculator;

/**
 * @author Pankush
 *
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteFile {

	public List<AttributesPojo> list;
	String line="";
	String[] Fields;
	
	
	public List<AttributesPojo> ReadFile(String inputFile) throws IOException 
	
	{
		list=new ArrayList<AttributesPojo>();
		BufferedReader bf= new BufferedReader(new FileReader(inputFile));
		
		while ((line=bf.readLine())!=null)
			{
				Fields=line.split(",");

				list.add(new AttributesPojo(Fields[0],Fields[1],Fields[2],Fields[3],Fields[4],Double.parseDouble(Fields[5]),Fields[6]));
			}
		
		bf.close();
		
		return list;
		
	}
	
	
	public void WriteFile(List<String> outputList, String outputFile) throws IOException 
	{
		FileWriter MyWriter = new FileWriter(outputFile);

		for (String temp : outputList)
			MyWriter.write(temp + "\n");

			MyWriter.close();
			
			System.gc();
		
	}

}

