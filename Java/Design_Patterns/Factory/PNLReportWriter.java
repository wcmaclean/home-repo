import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.util.Calendar;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

class PNLReportWriter extends ReportWriter{

/**
PNLReportWriter knows what you need to know to print information
on a PNL report to a file.
*/

	String aFilename;
	DataOutputStream outHere;


	// constructor
	PNLReportWriter(Vector vectrex){

		System.out.println("Getting a PNLReportWriter");

		Calendar today = Calendar.getInstance();
		today.setTimeInMillis(System.currentTimeMillis());

		this.aFilename  = 	"report_diff_" + 
					String.valueOf(today.get(Calendar.MONTH)) + 
					String.valueOf(today.get(Calendar.DAY_OF_MONTH)) +
					String.valueOf(today.get(Calendar.YEAR)) +
					".xls";
		System.out.println(aFilename);

		try{
			outHere = new DataOutputStream
				(new BufferedOutputStream
					(new FileOutputStream(aFilename)));

			try{
				//outHere.writeBytes(aReport.toString()); 
				//outHere.writeChars("ugh");
				for (int i=0;i<vectrex.size(); i++){
					String temp = vectrex.elementAt(i).toString();
					outHere.writeChars(temp);
				} 
			}catch(IOException ioe){
				System.out.println(ioe.getMessage());			
			}

			try{
				outHere.close(); 
			}catch(IOException ioe){
				System.out.println(ioe.getMessage());			
			}

		}catch(FileNotFoundException fnfe){
			System.out.println(fnfe.getMessage());
		}
	}
/*	
	public void writingData(PNLReportData aReport){
System.out.println("trying to write: " + aReport);
		try{
			//outHere.writeBytes(aReport.toString()); 
			outHere.writeChars("ugh"); 
		}catch(IOException ioe){
			System.out.println(ioe.getMessage());			
		}
	}
*/
	public void writingData(PNLReportData aReport){
System.out.println("trying to write: " + aReport);
		try{
			this.outHere = new DataOutputStream
				(new BufferedOutputStream
					(new FileOutputStream(aFilename)));
			try{
				//outHere.writeBytes(aReport.toString()); 
				outHere.writeChars("ugh"); 
			}catch(IOException ioe){
				System.out.println(ioe.getMessage());			
		}
		}catch(FileNotFoundException fnfe){
			System.out.println(fnfe.getMessage());
		}
		try{
			outHere.close(); 
		}catch(IOException ioe){
			System.out.println(ioe.getMessage());			
		}
	}

	public void closingFile(){
		try{
			outHere.close(); 
		}catch(IOException ioe){
			System.out.println(ioe.getMessage());			
		}
	}


}// close class