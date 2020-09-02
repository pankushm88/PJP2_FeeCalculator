/**
 * 
 */
package com.sapient.Fee_Calculator;

/**
 * @author Pankush
 *
 */
public class AttributesPojo
{

	String Transaction_ID,Client_ID,Security_Id,Transaction_Type,Priority_Flag,Date;
	Double Market_value;
	
	public AttributesPojo(String transaction_ID, String client_ID, String security_Id, String transaction_Type,
			 String date, Double market_value,String priority_Flag)
	{
		super();
		Transaction_ID = transaction_ID;
		Client_ID = client_ID;
		Security_Id = security_Id;
		Transaction_Type = transaction_Type;
		
		Date = date;
		
		Priority_Flag = priority_Flag;
		Market_value = market_value;
	}


	
}
