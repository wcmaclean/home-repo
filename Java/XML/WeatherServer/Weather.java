import java.util.Calendar;
import java.util.Random;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.io.PrintWriter;
import java.io.File;

public class Weather {

	/**
	 * @param args
	 */
	
	// instance variables
	private String locationName;
	private String locationCode;
	private String dateTime;
	private int windSpeed;
	private String windDirection;
	private int barometricPressure;
	private int relativeHumidity;
	private int dewPointTemp;
	private int precipitationLast24Hours;
	private int currentHighLast24Hours;
	private int currentLowLast24Hours;
	private int snowfallLast24Hours;
	private int heatIndex;
	private int windChill;
	private String officialWarnings;
	private String officialWatches;
	
	// contructor
	Weather(){
		this.setLocationName();
		this.setLocationCode();
		this.setDateTime();
		this.setWindSpeed();
		this.setWindDirection();
		this.setBarometricPressure();
		this.setRelativeHumidity();
		this.setDewPointTemp();
		this.setPrecipitationLast24Hours();
		this.setCurrentHighLast24Hours();
		this.setCurrentLowLast24Hours();
		this.setHeatIndex();
		this.setWindChill();
		this.setOfficialWarnings();
		this.setOfficialWatches();

		System.out.println(this.toString());
		System.out.println(this.toXMLString());
		this.writeToXMLFile();
	}
	
	// accessors
	public String getLocationName(){return this.locationName;}
	public String getLocationCode(){return this.locationCode;}
	public String getDateTime(){return this.dateTime;}
	public int getWindSpeed(){return this.windSpeed;}
	public String getWindDirection(){return this.windDirection;}
	public int getBarometricPressure(){return this.barometricPressure;}
	public int getRelativeHumidity(){return this.relativeHumidity;}
	public int getDewPointTemp(){return this.dewPointTemp;}
	public int getPrecipitationLast24Hours(){return this.precipitationLast24Hours;}
	public int getCurrentHighLast24Hours(){return this.currentHighLast24Hours;}
	public int getCurrentLowLast24Hours(){return this.currentLowLast24Hours;}
	public int getSnowfallLast24Hours(){return this.snowfallLast24Hours;}
	public int getHeatIndex(){return this.heatIndex;}
	public int getWindChill(){return this.windChill;}
	public String getOfficialWarnings(){return this.officialWarnings;}
	public String getOfficialWatches(){return this.officialWatches;}
	
	// mutators
	public void setLocationName(){
		this.locationName="Chicago";
	}
	public void setLocationCode(){
		this.locationCode="CHI";
	}
	public void setDateTime(){
		Calendar today = Calendar.getInstance();
		today.setTimeInMillis(System.currentTimeMillis());
		this.dateTime = 
			String.valueOf(today.get(Calendar.MONTH)) + "/" +
			String.valueOf(today.get(Calendar.DAY_OF_MONTH)) + "/" +
			String.valueOf(today.get(Calendar.YEAR)) + " " +
			String.valueOf(today.get(Calendar.HOUR_OF_DAY)) + ":" +
			String.valueOf(today.get(Calendar.MINUTE)) + ":" +
			String.valueOf(today.get(Calendar.SECOND)) + ":" +
			String.valueOf(today.get(Calendar.MILLISECOND));
	}
	public void setWindSpeed(){
		this.windSpeed=randomNumberGenerator(45);
	}
	public void setWindDirection(){
		int aNumber=randomNumberGenerator(8);
		if(aNumber==0){this.windDirection="North";}
		else if(aNumber==1){this.windDirection="Northeast";}
		else if(aNumber==2){this.windDirection="East";}
		else if(aNumber==3){this.windDirection="Southeast";}
		else if(aNumber==4){this.windDirection="South";}
		else if(aNumber==5){this.windDirection="Southwest";}
		else if(aNumber==6){this.windDirection="West";}
		else if(aNumber==7){this.windDirection="Northwest";}
	}
	public void setBarometricPressure(){
		this.barometricPressure=randomNumberGenerator(98);
	}
	public void setRelativeHumidity(){
		this.relativeHumidity=randomNumberGenerator(56);
	}
	public void setDewPointTemp(){
		this.dewPointTemp=randomNumberGenerator(20);
	}
	public void setPrecipitationLast24Hours(){
		this.precipitationLast24Hours=randomNumberGenerator(12);
	}
	public void setCurrentHighLast24Hours(){
		this.currentHighLast24Hours=randomNumberGenerator(120);
	}
	public void setCurrentLowLast24Hours(){
		this.currentLowLast24Hours=
			this.getCurrentHighLast24Hours()
				- randomNumberGenerator(20);
	}
	public void setHeatIndex(){
		this.heatIndex=randomNumberGenerator(20);
	}
	public void setWindChill(){
		this.windChill=randomNumberGenerator(20);
	}
	public void setOfficialWarnings(){
		int aNumber=randomNumberGenerator(8);
		if(aNumber==0){this.officialWarnings="Potentially Nice Day Warning";}
		else if(aNumber==1){this.officialWarnings="Tornado Warning";}
		else if(aNumber==2){this.officialWarnings="Tropical Storm Warning";}
		else if(aNumber==3){this.officialWarnings="Desert Storm Warning";}
		else if(aNumber==4){this.officialWarnings="Nothing to Fear Warning";}
		else if(aNumber==5){this.officialWarnings="Sunny Day Warning";}
		else if(aNumber==6){this.officialWarnings="High Wind Warning";}
		else if(aNumber==7){this.officialWarnings="No warnings";}
	}
	public void setOfficialWatches(){
		int aNumber=randomNumberGenerator(8);
		if(aNumber==0){this.officialWatches="Nice weather watch";}
		else if(aNumber==1){this.officialWatches="Tornado watch";}
		else if(aNumber==2){this.officialWatches="Tropical storm watch";}
		else if(aNumber==3){this.officialWatches="Desert storm watch";}
		else if(aNumber==4){this.officialWatches="Nothing to Fear watch";}
		else if(aNumber==5){this.officialWatches="Rolex";}
		else if(aNumber==6){this.officialWatches="Timex";}
		else if(aNumber==7){this.officialWatches="Digital";}
	}
	
	// useful methods
	public int randomNumberGenerator(int aNumber){
		Random generator = new Random();
		int randomNum = generator.nextInt(aNumber);
		return randomNum;
	}
	public String toString(){
		String aString = 
			"\nLocation Name: " + 
				this.getLocationName() +
			"\nLocation Code: " + 
				this.getLocationCode() +
			"\nDate and Time: " + 
				this.getDateTime() +
			"\nWind Speed: " + 
				this.getWindSpeed() +
			"\nWind Direction: " + 
				this.getWindDirection() +
			"\nBarometric Pressure: " + 
				this.getBarometricPressure() +
			"\nRelative Humidity: " + 
				this.getRelativeHumidity() +
			"\nDew Point Temp: " + 
				this.getDewPointTemp() +
			"\nPrecipitation in the last 24 hours: " +
				this.getPrecipitationLast24Hours() +
			"\nCurrent high in the last 24 hours: " +
				this.getCurrentHighLast24Hours() + 
			"\nCurrent low in the last 24 hours: " +
				this.getCurrentLowLast24Hours() +
			"\nSnowfall in the last 24 hours: " +
				this.getSnowfallLast24Hours() + 
			"\nHeat Index: " + 
				this.getHeatIndex() +
			"\nWind Chill: " +
				this.getWindChill() +
			"\nOfficial Warnings: " +
				this.getOfficialWarnings() +
			"\nOfficial Watches: " +
				this.getOfficialWatches() + "\n";
		return aString;
	}
	public String toXMLString(){
		String aString = 
			"<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
			"<?xml-stylesheet href=\"weather.xsl\"  type=\"text/xsl\"?> " + 
			"<theWeather xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:noNamespaceSchemaLocation=\"./theWeather.xsd\">" +
			"<locationName>"+this.getLocationName()+"</locationName>" +
			"<locationCode>"+this.getLocationCode()+"</locationCode>" +
			"<weather>" +
			"<dateTime>"+this.getDateTime()+"</dateTime>" +
			"<windSpeed>"+this.getWindSpeed()+"</windSpeed>" +
			"<windDirection>"+this.getWindDirection()+"</windDirection>" +
			"<barometricPressure>"+this.getBarometricPressure()+"</barometricPressure>" +
			"<relativeHumidity>"+this.getRelativeHumidity()+"</relativeHumidity>" +
			"<dewPointTemp>"+this.getDewPointTemp()+"</dewPointTemp>" +
			"<precipitationLast24Hours>"+this.getPrecipitationLast24Hours()+"</precipitationLast24Hours>" +
			"<currentHighLast24Hours>"+this.getCurrentHighLast24Hours()+"</currentHighLast24Hours>" +
			"<currentLowLast24Hours>"+this.getCurrentLowLast24Hours()+"</currentLowLast24Hours>" +
			"<snowfallLast24Hours>"+this.getSnowfallLast24Hours()+"</snowfallLast24Hours>" +
			"<heatIndex>"+this.getHeatIndex()+"</heatIndex>" +
			"<windChill>"+this.getWindChill()+"</windChill>" +
			"<officialWarnings>"+this.getOfficialWarnings()+"</officialWarnings>" +
			"<officialWatches>"+this.getOfficialWatches()+"</officialWatches>" +
			"</weather>" +
			"</theWeather>";
		return aString;
	}
	public void writeToXMLFile(){
		String aFilename  = "weather.xml";
		DataOutputStream outHere;
		System.out.println("Saving to .xml file...");
		System.out.println(aFilename);

		try{
			outHere = new DataOutputStream
				(new BufferedOutputStream
					(new FileOutputStream(aFilename)));
			try{
				//outHere.writeChars(this.toXMLString());
				PrintWriter out = new PrintWriter(new File(aFilename));
				out.println(this.toXMLString());
				out.close();
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
	public void writeToTextFile(){
		String aFilename  = "weather.txt";
		DataOutputStream outHere;
		System.out.println("Saving to .xml file...");
		System.out.println(aFilename);

		try{
			outHere = new DataOutputStream
				(new BufferedOutputStream
					(new FileOutputStream(aFilename)));
			try{
				outHere.writeChars(this.toString());
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Weather aWeather = new Weather();
		//System.out.println(aWeather.toString());
		//System.out.println(aWeather.toXMLString());
		//aWeather.writeToXMLFile();
		//aWeather.writeToTextFile();

	}
}