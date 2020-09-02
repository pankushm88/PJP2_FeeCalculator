/**
 * 
 */
package com.sapient.Fee_Calculator;

/**
 * @author Pankush
 *
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Feecalculation  {

	public  static HashMap<String,Pair> map=new HashMap<String,Pair>();
	public List<String> OutputList=new ArrayList<String>();
	
	
	public  List<String>  calculate(List<AttributesPojo> InputList)
	{
	
		/*Calculating Fee*/
		
		for(var temp:InputList)
		{
			
			String key=temp.Client_ID+","+temp.Security_Id+","+temp.Date;
			Pair pair;

			/* Intra-Day Transactions*/
			if(map.containsKey(key))
			{
				
				String Type1=((map.get(key)).Transaction).Transaction_Type;
				
				if(temp.Transaction_Type.equals("SELL")&&Type1.equals("BUY")||(temp.Transaction_Type.equals("BUY")&&Type1.equals("SELL")))
				{
					pair=new Pair((map.get(key)).Transaction,10);
					map.put(key,pair);
					
					key+=temp.Transaction_Type;/* Key Extension for Intra-Day Transaction. So that both Transactions can be saved in map*/
					pair=new Pair(temp,10);
					map.put(key, pair);
					
				}
			}
			
			/*Normal Transactions*/
			else
			{
				if(temp.Priority_Flag.equals("Y"))
				{
					pair=new Pair(temp,500);
					map.put(key,pair );
				}
				else if(temp.Priority_Flag.equals("N") && (temp.Transaction_Type.equals("SELL")|| temp.Transaction_Type.equals("WITHDRAW")))
				{
					pair=new Pair(temp,100);
					map.put(key,pair );
				}
				else 
				{
					pair=new Pair(temp,50);
					map.put(key,pair );
				}
				
			}
			
			
		}
		
		MakeListOfOutput();
		Collections.sort(OutputList);
		return OutputList;
	
	}
	
	/*Function to make List of output file*/
	private void MakeListOfOutput() 
	{
		
		
		for(var temp:map.entrySet())
		{	
			Pair pair=temp.getValue();
			AttributesPojo Tx=pair.Transaction;
			int fee=pair.Processing_Fee;
			String s;
			
			s=Tx.Client_ID+","+Tx.Transaction_Type+","+Tx.Date+","+Tx.Priority_Flag+","+fee;
			
			OutputList.add(s);
		}
		
		
		
	}
	
	
	

}

