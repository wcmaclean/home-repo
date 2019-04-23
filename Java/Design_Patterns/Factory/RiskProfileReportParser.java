import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.StringTokenizer;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.util.*;


class RiskProfileReportParser extends ReportParser{

/**
RiskProfileReportParser contains the meat for reading and analyzing
Risk Profile Reports. It extends ReportParser.
*/

	// default constructor
	RiskProfileReportParser(){}
	

	// constructor
	RiskProfileReportParser(String[] stuff){

		this.setReportType("RP");
		file1 = stuff[2];
		file2 = stuff[3];

		Vector vectrex = new Vector();
		Vector vectrola = new Vector();


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
			RiskProfileReportData aReport1;
			RiskProfileReportData aReport2;
			RiskProfileReportData aReport3;

			while(	((inputStuff1 = bin1.readLine())!=null) &
				((inputStuff2 = bin2.readLine())!=null)
			){
				Long tradeID;
				Double[] delta;
				String currency;

				// Get a couple report lines
				aReport1 = createARiskProfileReport(inputStuff1);
				aReport2 = createARiskProfileReport(inputStuff2);

				// reconcile report lines
				aReport3 = reconcileReportLines(aReport1, aReport2);

				// to vector
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

		// reshuffle 4 lines into 1
		for (int i=0;i<vectrex.size(); i=i+4){
			RiskProfileReportData meGetDelta1 = (RiskProfileReportData)vectrex.elementAt(i);
			RiskProfileReportData meGetDelta2 = (RiskProfileReportData)vectrex.elementAt(i+1);
			RiskProfileReportData meGetDelta3 = (RiskProfileReportData)vectrex.elementAt(i+2);
			RiskProfileReportData meGetDelta4 = (RiskProfileReportData)vectrex.elementAt(i+3);

			RiskProfileReportData aReportTemp = 
				new RiskProfileReportData(
					meGetDelta1.getTradeID(),
					meGetDelta1.getDelta1(),
					meGetDelta2.getDelta1(),
					meGetDelta3.getDelta1(),
					meGetDelta4.getDelta1(),
					meGetDelta1.getCurrency()					
			);
			vectrola.addElement(aReportTemp);
		} 

		// write
		ReportWriter aReportWriter = 
			ReportWriter.createReportWriter(this.getReportType(), vectrola);

	}// close RiskProfileReportParser

	public RiskProfileReportData createARiskProfileReport(String reportString){

		RiskProfileReportData aReport;

		Long tradeID=null;
		Double delta1=null;
		Double delta2=0.0;
		Double delta3=0.0;
		Double delta4=0.0;
		String bucket=null;
		String currency=null;

		StringTokenizer tolkien = new StringTokenizer(reportString, " ");
		while(tolkien.hasMoreTokens()){
			tradeID=Long.parseLong(tolkien.nextToken());
			bucket=(tolkien.nextToken());
			delta1=Double.parseDouble(tolkien.nextToken());
			currency=(tolkien.nextToken());
		}
		aReport = new RiskProfileReportData(tradeID, delta1, delta2, delta3, delta4, currency);
		aReport.printReport();
		return aReport;
	} // close createARiskProfileReport


	public RiskProfileReportData reconcileReportLines(	RiskProfileReportData aReport1, 
								RiskProfileReportData aReport2
	){

		RiskProfileReportData aReport=null;

		Long tradeID=aReport1.getTradeID();
		Double delta1= (aReport1.getDelta1()) - (aReport2.getDelta1());
		Double delta2= (aReport1.getDelta2()) - (aReport2.getDelta2());
		Double delta3= (aReport1.getDelta3()) - (aReport2.getDelta3());
		Double delta4= (aReport1.getDelta4()) - (aReport2.getDelta4());
		String currency=aReport1.getCurrency();

		System.out.println("Reconciled:");
		aReport = new RiskProfileReportData(tradeID, delta1, delta2, delta3, delta4, currency);
		aReport.printReport();
		System.out.println();
		return aReport;
	}


}//close RiskProfileReportParser


