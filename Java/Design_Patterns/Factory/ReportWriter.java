import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.util.Calendar;
import java.io.FileNotFoundException;
import java.util.*;

abstract class ReportWriter{

/**
ReportWriter is an abstract factory containing only those elements universal
to all report writers. It passes on the info to useful instantiable classes
to do the dirty work.
*/

	DataOutputStream outHere;
	Calendar today;
	String aFilename;
	PNLReportData someData;

	public static ReportWriter createReportWriter(String aReportType, Vector vectrex){

		if (aReportType.equalsIgnoreCase("PNL"))
			return new PNLReportWriter(vectrex);		
		else if (aReportType.equalsIgnoreCase("RP"))
			return new RiskProfileReportWriter(vectrex);
		else{
			System.out.println("Error: " + aReportType + " reports are not supported.");
			System.exit(0);
		}
		return new PNLReportWriter(vectrex);

	}

	// accessors
	public DataOutputStream getOutHere(){
		return this.outHere;
	}
	public Calendar getToday(){
		return this.today;
	}
	public String getAFilename(){
		return this.aFilename;
	}

	// mutators
	public void setToday(){
		Calendar today = Calendar.getInstance();
		today.setTimeInMillis(System.currentTimeMillis());
	}
	public void setAFilename(Calendar today){
		String aFilename;
		this.aFilename  = 	"report_diff_" + 
					String.valueOf(today.get(Calendar.MONTH)) + 
					String.valueOf(today.get(Calendar.DAY_OF_MONTH)) +
					String.valueOf(today.get(Calendar.YEAR)) +
					".xls";
	}
	public DataOutputStream setOutHere(String aFilename){
		try{
			DataOutputStream outHere = new DataOutputStream
				(new BufferedOutputStream
					(new FileOutputStream(aFilename)));
		}catch(FileNotFoundException fnfe){
			System.out.println(fnfe.getMessage());
		}
		return outHere;
	}



}//close PNLReportParser