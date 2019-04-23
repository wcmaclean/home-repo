# smackdown.rb
#
# Will MacLean
# CSPP 51060

require 'csv'

# store min and max
minMax = {
	'min' => 100000000.00,
	'minDateTime' => 'none yet',
	'max' => 0.00,
	'maxDateTime' => 'none yet',
	'startVal' => 0.00
}

# for reading CSV files
def readToList( filename )
	reader = CSV::parse(File.open(filename) {|f| f.read} )
	return reader
end

# for date-time keys
def getDateTime ( arr )
	return arr[2] + " " + arr[3]
end

# for name-price keys
def getNamePrice ( arr )
	return arr[0] + arr[2]
end

# read CSV files
portfolio = readToList( "dowportfolio.csv" )
stocks = readToList( "dowstocks.csv" )

# get starting values for stocks
portStartVals = {}
portNamePrice = {}
for i in portfolio
	nameKey = getNamePrice( i )
	portShares = i[1]
	portPrice = i[2]
	portStartVals[nameKey] = Float(portShares) * Float(portPrice)
	portNamePrice[nameKey] = nameKey
end

#print portStartVals
#print portNamePrice

# get individual dates and storage
dateTimeTotals = {}
dateTimeKeys = {}
dateTimeStocks = {}
for stockVal in stocks
	dateTime = getDateTime( stockVal )
	if (dateTimeTotals.has_key?(dateTime) == false)
		total = Float(minMax['startVal'])
		dateTimeTotals[dateTime] = 0
		dateTimeKeys[dateTime] = dateTime
		stockLines = {}
		for portVal in portfolio
			nameKey = getNamePrice( portVal )
			stockline = []
			name = portVal[0]
			shares = portVal[1]
			price = portVal[2]
			change = 0
			stockline = [name, shares, price, change]
			stockLines[nameKey] = stockline
			#print stockline
			#print " "
			#dateTimeStocks[dateTime][nameKey] = stockline
			#dateTimeStocks[dateTime] = stockLines[nameKey]
		end
		dateTimeStocks[dateTime] = stockLines
		#print "--"
	end
end

#print dateTimeKeys
#print portNamePrice

#for value in dateTimeStocks['8/31/2007 4:01pm']['MSFT71.21']
#	print value
#end

# search the file and fill in what we can
for stockVal in stocks
	stockName = stockVal[0]
	stockPrice = stockVal[1]
	stockDateTime = getDateTime(stockVal)
	for portVal in portfolio
		portName = portVal[0]
		portShares = portVal[1]
		portPurchase = portVal[2]
		if (stockName == portName)
			key = getNamePrice(portVal)
			change = Float(stockPrice) - Float(portPurchase)
			stockline = []
			name = stockName
			shares = portShares
			price = stockPrice
			stockline = [name, shares, price, change]
			dateTimeStocks[stockDateTime][key] = stockline
		end
		#print dateTimeStocks[stockDateTime]
	end
end


# calc the total for each day
for date in dateTimeKeys
	dateTot = 0
	dateTime = date[0]
	#print dateTimeStocks[dateTime]
	for key in portNamePrice
		keyName = key[0]
		#print dateTimeStocks[dateTime][keyName]
		#print dateTimeStocks[date][key]
		sharesLine = dateTimeStocks[dateTime][keyName]
		shares = Float(sharesLine[1])
		priceLine = dateTimeStocks[dateTime][keyName]
		price = Float(priceLine[2])
		dateTot = Float(dateTot) + shares * price
	dateTimeTotals[dateTime] = dateTot
	end
end


#line = dateTimeStocks['8/31/2007 4:01pm']['MSFT71.21']
#print line[0]

#print dateTimeTotals

# find the min and max
for value in dateTimeTotals
	testNum = Float(value[1])
	minNum = Float(minMax['min'])
	#print minNum
	maxNum = Float(minMax['max'])
	#print maxNum
	if (testNum < minNum)
		minMax['min'] = testNum
		minMax['minDateTime'] = value[0]
		#minList = dateTimeStocks[value]
	end
	if (testNum > maxNum)
		minMax['max'] = testNum
		minMax['maxDateTime'] = value[0]
		#maxList = dateTimeStocks[value]
	end
end

#print minMax

# print min
minNum = Float(minMax['min'])
minDate = minMax['minDateTime']
printf "\n==============="
printf "\n%s Values: $ %10.2f at %25s", 'Minimum', minNum, minDate 
printf "\n==============="
printf "\n%10s %10s %10s %10s", 'Name', 'Shares', 'Price', 'Change'
printf "\n" + "---------- " * 4
for key in portNamePrice
	keyName = key[0]
	#print dateTimeStocks[minDate][keyName]
	name = dateTimeStocks[minDate][keyName][0]
	shares = Integer(dateTimeStocks[minDate][keyName][1])
	price = Float(dateTimeStocks[minDate][keyName][2])
	change = Float(dateTimeStocks[minDate][keyName][3])
	printf "\n%10s %10d %10.2f %+10.2f", name, shares, price, change
end
print "\n"

maxNum = Float(minMax['max'])
maxDate = minMax['maxDateTime']
printf "\n==============="
printf "\n%s Values: $ %10.2f at %25s", 'Maximum', maxNum, maxDate 
printf "\n==============="
printf "\n%10s %10s %10s %10s", 'Name', 'Shares', 'Price', 'Change'
printf "\n" + "---------- " * 4
for key in portNamePrice
	keyName = key[0]
	#print dateTimeStocks[maxDate][keyName]
	name = dateTimeStocks[maxDate][keyName][0]
	shares = Integer(dateTimeStocks[maxDate][keyName][1])
	price = Float(dateTimeStocks[maxDate][keyName][2])
	change = Float(dateTimeStocks[maxDate][keyName][3])
	printf "\n%10s %10d %10.2f %+10.2f", name, shares, price, change
end
print "\n"