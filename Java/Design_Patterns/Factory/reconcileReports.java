import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class reconcileReports{

/**
reconcileReports is a facade, and knows nothing about specific 
reports.
*/

	public static void main(String[] args){
	
	ReportParser aReportParser = 
		ReportParser.createReportParser(args);

	}// close main
}// close class ReportReconciliationFacade