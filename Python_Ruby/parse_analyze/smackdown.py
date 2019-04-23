# smackdown.py
#
# Will MacLean
# CSPP 51060

import csv

# dictionary for min, max, and dates
# find min and max		
minMax = {
	'min': 100000000.00,
	'minDateTime': 'none yet',
	'max': 0.00,
	'maxDateTime': 'none yet',
	'startVal': 0.00
}


# function to read CSV files into lists
def readToList( filename ):
	reader = csv.reader(open(filename, "rb"))
	list = []
	for row in reader:
		list.append(row)
	return list

# reading CSV files
portfolio = readToList( "dowportfolio.csv" )
stocks = readToList( "dowstocks.csv" )

def getDateTime( row ):
	dateSplit = row[2].split('"')
	date = dateSplit[0]
	timeSplit = row[3].split('"')
	time = timeSplit[0]
	dateTime = date + " " + time
	return dateTime

# for nameprice keys
def getNamePrice( i ):
	return i[0] + i[2]

# get some starting values for each stock in portfolio
portStartVals = {}
portNamePrice = {}
for value in portfolio:
	key = getNamePrice( value )
	portShares = value[1]
	portPrice = value[2]
	portStartVals[getNamePrice(value)] = float(portShares) * float(portPrice)
	portNamePrice[key] = key

# get individual dates, and storage
dateTimeTotals = {}
dateTimeKeys = {}
dateTimeStocks = {}
for value in stocks:
	dateTime = getDateTime( value )
	if (dateTimeTotals.has_key(dateTime) == False):
		total = float(minMax['startVal'])
		dateTimeTotals[dateTime] = 0 #total
		dateTimeKeys[dateTime] = dateTime
		stockLines = {}
		for portVal in portfolio:
			key = getNamePrice( portVal )
			stockline = []
			stockline.append(portVal[0])
			stockline.append(portVal[1])
			stockline.append(portVal[2])
			stockline.append('0')
			stockLines[key] = stockline
		dateTimeStocks[dateTime] = stockLines

# search the file and fill in what we've got
for stockVal in stocks:
	stockName = stockVal[0]
	stockPrice = stockVal[1]
	stockDateTime = getDateTime(stockVal)
	for portVal in portfolio:
		portName = portVal[0]
		portShares = portVal[1]
		portPurchase = portVal[2]
		if (cmp(stockName, portName) == False):
			key = getNamePrice(portVal)
			change = float(stockPrice) - float(portPurchase)
			stockline = []
			stockline.append(stockName)
			stockline.append(portShares)
			stockline.append(stockPrice)
			stockline.append(change)
			dateTimeStocks[stockDateTime][key] = stockline

# calc the total for each day
for date in dateTimeTotals:
	dateTot = 0
	for key in portNamePrice:
		#print dateTimeStocks[date][key]
		shares = float(dateTimeStocks[date][key][1])
		price = float(dateTimeStocks[date][key][2])
		dateTot = float(dateTot) + shares * price
	dateTimeTotals[date] = dateTot
		
#print dateTimeTotals

# find the min and max
for value in dateTimeTotals:
	if (float(dateTimeTotals[value]) < float(minMax['min'])):
		minMax['min'] = dateTimeTotals[value]
		minMax['minDateTime'] = value
		#minList = dateTimeStocks[value]
	if (float(dateTimeTotals[value]) > float(minMax['max'])):
		minMax['max'] = dateTimeTotals[value]
		minMax['maxDateTime'] = value
		#maxList = dateTimeStocks[value]

print dateTimeStocks[minMax['minDateTime']]['HPQ37.42']

def printValues( minOrMax, dayTotal, dateTime ):
	print "==============="
	print "%s Values: $ %10.2f at %25s" % ( minOrMax, dayTotal, dateTime )
	print "==============="
	print "%10s %10s %10s %10s" % ('Name', 'Shares', 'Price', 'Change')
	print "---------- " * 4
	for key in portNamePrice:
		list = []
		name = dateTimeStocks[dateTime][key][0]
		shares = int(dateTimeStocks[dateTime][key][1])
		price = float(dateTimeStocks[dateTime][key][2])
		change = float(dateTimeStocks[dateTime][key][3])
		print "%10s %10d %10.2f %+10.2f" % ( name, shares, price, change )

printValues( "Minimum", minMax['min'], minMax['minDateTime'] )
printValues( "Maximum", minMax['max'], minMax['maxDateTime'] )

#for value in dateTimeStocks['8/31/2007 4:01pm']['MSFT71.21']:
#	print value


