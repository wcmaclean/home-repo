import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


abstract class ReportParser{

/**
ReportParser is an Abstract Factory containing only those elements
universal to reading and analyzing reports. It is to be instantiated
by more robust classes, to which it passes on information.
*/

	//instance variables
	BufferedReader 	bin1, 
			bin2;
	String	file1,
		file2;
	private String ReportType;

	//constructors

	public static ReportParser createReportParser(String[] stuff) {
		String aReportType = stuff[0];

	 	if (aReportType.equalsIgnoreCase("PNL")){
 			return new PNLReportParser(stuff);
		}else if (aReportType.equalsIgnoreCase("RP")) {
			return new RiskProfileReportParser(stuff);
		}else{
			System.out.println("Error: " + aReportType + " reports are not supported.");
			System.exit(0);
		}
		// not having an instantiable generic type to return, I'm doing this...
		return new PNLReportParser();
	}

	public PNLReportParser setPNLReportParser() {return new PNLReportParser();}
	public RiskProfileReportParser setRiskProfileReportParser() {return new RiskProfileReportParser();}

	// accessors
	public String getReportType(){
		return this.ReportType;
	}

	// mutators
	public void setReportType(String ReportType){
		this.ReportType = ReportType;
	}

}// close class ReportParser