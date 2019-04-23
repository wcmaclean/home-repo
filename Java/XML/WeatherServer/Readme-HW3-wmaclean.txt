Will MacLean
Homework 3

============================
WeatherServer-WorkingVersion
Instructions...
----------------------------

1. Compile Weather.java and WeatherMaker.java

2. Run WeatherMaker...
     java WeatherMaker

3. Open weather.xml in a browser
---------------
Description...
---------------
WeatherMaker is a threaded java executable that creates 
a Weather object.

The Weather object randomly generates fake weather data 
that it writes to weather.xml.

weather.xml accesses weather.xsl, which in turn reads
theWeather.xsd in creating a self-refreshing web page. 
Each refresh creates a new page with new weather data.

============================
WeatherServer-BotchedAttempt
Explanation...
----------------------------
Weather.java, weather.xml, weather.xsd, and weather.xsl
are the same is in the working version.

But I was trying to use a servlet to create the weather
object and generate the .xml - it didn't work right.

And I did manage to get a DOM parser which properly
read Weather.xml - but it only worked when run from 
the command line. I was trying to get it to parse the 
.xml file into a vector to pass back into the servlet. 
But I couldn't get it to work through the Tomcat.