<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
 xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">


<xsl:template match="/">
 
<html>

<HEAD><TITLE>The Weather Service</TITLE></HEAD> 
<META HTTP-EQUIV="REFRESH" Content="10;URL=http://polonium.cs.uchicago.edu:8180/2wmaclean/jsp/weather.xml" />  
<body>

<H1>The Weather Service</H1>


 
     <xsl:for-each select="theWeather">

      <h2>Location</h2> <p> <xsl:value-of select="locationName"/> </p>
     </xsl:for-each>


 
     <xsl:for-each select="theWeather">
      <h2>Location Code</h2> <p> <xsl:value-of select="locationCode"/> </p>
     </xsl:for-each>


 
     <xsl:for-each select="theWeather/weather">
      <h2>Date and Time</h2> <p> <xsl:value-of select="dateTime"/> </p>
     </xsl:for-each>


 
     <xsl:for-each select="theWeather/weather">
      <h2>Wind Speed</h2> <p> <xsl:value-of select="windSpeed"/> </p>
     </xsl:for-each>


 
     <xsl:for-each select="theWeather/weather">
      <h2>Wind Direction</h2> <p> <xsl:value-of select="windDirection"/> </p>
     </xsl:for-each>


 
     <xsl:for-each select="theWeather/weather">
      <h2>Barometric Pressure</h2> <p> <xsl:value-of select="barometricPressure"/> </p>
     </xsl:for-each>


 
     <xsl:for-each select="theWeather/weather">
      <h2>Relative Humidity</h2> <p> <xsl:value-of select="relativeHumidity"/> </p>
     </xsl:for-each>


 
     <xsl:for-each select="theWeather/weather">
      <h2>Dew Point Temperature</h2> <p> <xsl:value-of select="dewPointTemp"/> </p>
     </xsl:for-each>


 
     <xsl:for-each select="theWeather/weather">
      <h2>Precipitation in the last 24 hours</h2> <p> <xsl:value-of select="precipitationLast24Hours"/> </p>
     </xsl:for-each>


 
     <xsl:for-each select="theWeather/weather">
      <h2>Current high in the last 24 hours</h2> <p> <xsl:value-of select="currentHighLast24Hours"/> </p>
     </xsl:for-each>


 
     <xsl:for-each select="theWeather/weather">
      <h2>Current low in the last 24 hours</h2> <p> <xsl:value-of select="currentLowLast24Hours"/> </p>
     </xsl:for-each>


 
     <xsl:for-each select="theWeather/weather">
      <h2>Snowfall in the last 24 hours</h2> <p> <xsl:value-of select="snowfallLast24Hours"/> </p>
     </xsl:for-each>


 
     <xsl:for-each select="theWeather/weather">
      <h2>Heat Index</h2> <p> <xsl:value-of select="heatIndex"/> </p>
     </xsl:for-each>

 
     <xsl:for-each select="theWeather/weather">
      <h2>Wind Chill</h2> <p> <xsl:value-of select="windChill"/> </p>
     </xsl:for-each>


 
     <xsl:for-each select="theWeather/weather">
      <h2>Official Warnings</h2> <p> <xsl:value-of select="officialWarnings"/> </p>
     </xsl:for-each>


 
     <xsl:for-each select="theWeather/weather">
      <h2>Official Watches</h2> <p> <xsl:value-of select="officialWatches"/> </p>
     </xsl:for-each>



</body>

</html>

</xsl:template>


</xsl:stylesheet>