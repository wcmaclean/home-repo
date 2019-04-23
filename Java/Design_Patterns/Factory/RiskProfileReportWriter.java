import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.util.Calendar;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

class RiskProfileReportWriter extends ReportWriter{

/**
RiskProfileReportWriter extends ReportWriter, and knows 
how to print to file information from Risk Profile Reports.
*/

	String aFilename;
	DataOutputStream outHere;


	// constructor
	RiskProfileReportWriter(Vector vectrex){

		System.out.println("Getting a RiskProfileReportWriter");

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


}// close class