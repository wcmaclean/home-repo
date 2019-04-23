import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.StringTokenizer;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.util.*;

class PNLReportParser extends ReportParser{

/**
PNLReportParser class knows most all you need to know to 
analyze and report on PNL reports.
*/


	// default constructor
	PNLReportParser(){}

	// constructor
	PNLReportParser(String[] args) {

		this.setReportType("PNL");
		file1 = args[1];
		file2 = args[2];

//		ReportWriter aReportWriter = 
//			ReportWriter.createReportWriter(this.getReportType());

//		PNLReportWriter aReportWriter = new PNLReportWriter();

		Vector vectrex = new Vector();


		try{
			bin1 = new BufferedReader
				(new InputStreamReader
					(new FileInputStream(file1)));
		}catch(FileNotFoundException fnfe){
			System.out.println(fnfe.getMessage());
		}
		// load bin2
		try{
			bin2 = new BufferedReader
				(new InputStreamReader
					(new FileInputStream(file2)));
		}catch(FileNotFoundException fnfe){
			System.out.println(fnfe.getMessage());
		}


		try{
			String inputStuff1;
			String inputStuff2;
			PNLReportData aReport1;
			PNLReportData aReport2;
			PNLReportData aReport3;

			while(	((inputStuff1 = bin1.readLine())!=null) &
				((inputStuff2 = bin2.readLine())!=null)
			){
				// Get a couple report lines
				aReport1 = createAPNLReport(inputStuff1);
				aReport2 = createAPNLReport(inputStuff2);

				// reconcile report lines
				aReport3 = reconcileReportLines(aReport1, aReport2);

				// to output
				//aReportWriter.writingData(aReport3);
				vectrex.addElement(aReport3);
			}
		}catch(IOException ioe){
			System.out.println(ioe.getMessage());
		}
		try{
			bin1.close();
		}catch(IOException ioe){
			System.out.println(ioe.getMessage());
		}
		//aReportWriter.closingFile();

		ReportWriter aReportWriter = 
			ReportWriter.createReportWriter(this.getReportType(), vectrex);




	}// close PNLReportParser - constructor


	public PNLReportData createAPNLReport(String reportString){

		PNLReportData aReport;

		Long tradeID=null;
		String Product=null;
		Double MTMBegin=null;
		Double MTMEnd=null;
		String currency=null;

		StringTokenizer tolkien = new StringTokenizer(reportString, " ");
		while(tolkien.hasMoreTokens()){
			tradeID=Long.parseLong(tolkien.nextToken());
			Product=(tolkien.nextToken());
			MTMBegin=Double.parseDouble(tolkien.nextToken());
			MTMEnd=Double.parseDouble(tolkien.nextToken());
			currency=(tolkien.nextToken());
		}
		aReport = new PNLReportData(tradeID, Product, MTMBegin, MTMEnd, currency);
		aReport.printReport();
		return aReport;
	} // close createAPNLReport


	public PNLReportData reconcileReportLines(PNLReportData aReport1, PNLReportData aReport2){

		PNLReportData aReport=null;

		Long tradeID=aReport1.getTradeID();
		String Product=aReport1.getProduct();
		Double MTMBegin= (aReport1.getMTMBegin()) - (aReport2.getMTMBegin());
		Double MTMEnd= (aReport1.getMTMEnd()) - (aReport2.getMTMEnd());
		String currency=aReport1.getCurrency();

		System.out.println("Reconciled:");
		aReport = new PNLReportData(tradeID, Product, MTMBegin, MTMEnd, currency);
		aReport.printReport();
		System.out.println();
		return aReport;
	}
}//close PNLReportParser
