// Will MacLean
// CSPP 51060
// portfolio.java

import java.io.*;
import java.lang.String;

class portfolio
{
	public static void main(String[] args)
	{
		String filename = "portfolio.txt";
		float total = 0;
		float shares = 0;
		float price = 0;

		String record = null;
		int count = 0;

		System.out.println("\nName \tShares \t  Price");
		System.out.println("---- \t------ \t  -----");
		
		try
		{
			FileReader fr = new FileReader(filename);
			BufferedReader br = new BufferedReader(fr);
			
			record = new String();
			while((record = br.readLine()) != null)
			{
				count++;
				//System.out.println(record);
				
				// get the fields
				String[] fields = record.split(" ");

				// convert 
				shares = new Float(fields[1]);
				price = new Float(fields[2]);

				// printf
				System.out.printf("%s \t %5.0f \t %6.2f \n", fields[0], shares, price);

				// math
				total = total + shares * price;
			}
		} 
		catch(IOException e) 
		{
			System.out.println("goofed");
			e.printStackTrace();
		}

		System.out.println("\nTotal cost: " + total + "\n");
	}
}
