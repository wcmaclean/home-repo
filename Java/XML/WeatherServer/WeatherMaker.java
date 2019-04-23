/*
 * This class is a fake server, and exists only to create a Weather
 * object to write .xml files with new fake weather data.
 */

public class WeatherMaker extends Thread{

	/**
	 * @param args
	 */
	
	// constructor
	public WeatherMaker(){}
	
	// methods
	public void makeWeather(){
		Weather aWeather = new Weather();
	}
	public void run(){
		try{
			while(true){
				sleep(1000);
				System.out.println                      
                                    ("making weather");
				makeWeather();

			}
		}catch(Exception e){}
	}

	// run program	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WeatherMaker aWeatherMaker 
                       = new WeatherMaker();
		aWeatherMaker.start();
	}

}