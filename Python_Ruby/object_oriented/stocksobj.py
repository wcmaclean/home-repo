# stocksobj.py
#
# Will MacLean
# CSPP 51060

import csv
import copy
import portreader
import tableformatter

# storage for min and max data
min = 'none'
minDate = 'none'
minDayList = {}
max = 'none'
maxDate = 'none'
maxDayList = {}

# creating a Stock class
class Stock(object):
	def __init__(self, name, shares, price):
		self.name = name
		self.shares = shares
		self.price = price
		self.value = float(price) * float(shares)
		self.change = 0.0
	def calcChangeValue(self, newPrice):
		temp = float(self.value)
		newVal = float(self.shares) * float(newPrice)
		self.change = float(newPrice) - float(self.price)
		self.value = newVal
		self.price = newPrice
	def printStock(self):
		print "%10s %10d %10.2f %+10.2f" % (self.name, int(self.shares), float(self.price), float(self.change) )

# function to read CSV files
def readToList( file ):
	reader = csv.reader(open(file, "rb"))
	list = []
	for row in reader:
		list.append(row)
	return list

# reading CSV files
#portfolio = readToList("dowportfolio.csv")
stocks = readToList("dowstocks.csv")

a_reader = portreader.my_reader("dowportfolio.rec")
portfolio = a_reader.read()

# function to build stock keys
def getStockKey( stock ):
	return stock[0] + stock[2]

# function to get dateTimes
def getDateTime( row ):
	dateSplit = row[2].split('"')
	date = dateSplit[0]
	timeSplit = row[3].split('"')
	time = timeSplit[0]
	dateTime = date + " " + time
	return dateTime

# creating a bunch of stocks
stockDict = {}
stockKeys = {}
stockNames = {}
for value in portfolio:
	aStock = Stock(value[0], value[1], value[2])
	aStockKey = getStockKey(value)
	stockDict[aStockKey] = aStock
	stockKeys[aStockKey] = aStockKey
	if (stockNames.has_key(value[0]) == False):
		stockNames[value[0]] = value[0]

# calcing total for day
def calcDay():
        tot = 0
        for key in stockKeys:
                tot = tot + float(stockDict[key].value)
        return tot

# find initial value
initVal = calcDay()
min = initVal
max = initVal

# update stockDict
def updateStockDict(name, newPrice):
	for key in stockKeys:
		testName = stockDict[key].name
		testName.strip
		name.strip
		if (cmp(testName, name) == False):
			#stockDict[key].calcChangeValue(price)
	                temp = float(stockDict[key].value)
	                newVal = float(stockDict[key].shares) * float(newPrice)
        	        stockDict[key].change = float(newPrice) - float(stockDict[key].price)
                	stockDict[key].value = newVal
                	stockDict[key].price = newPrice


# calcing the days
currentDateTime = getDateTime(stocks[0])
for value in stocks:
	name = value[0]
	if(stockNames.has_key(name) == True):
		price = value[1]
		dateTime = getDateTime(value)
		if (cmp(currentDateTime, dateTime) == False):
			updateStockDict(name, price)
		else:
			currentDateTime = dateTime
			total = calcDay()
			if (min > total):
				min = total
				minDate = dateTime
				minDayList = copy.deepcopy(stockDict)
			if (max < total):
				max = total
				maxDate = dateTime
				maxDayList = copy.deepcopy(stockDict) 

# function to print finals
def printFinals(minOrMax, tot, date, dayDict):
	print "==============="
	print "%s Values: $ %10.2f at %25s" % ( minOrMax, tot, date )
	print "==============="
	print "%10s %10s %10s %10s" % ('Name', 'Shares', 'Price', 'Change')
	print "---------- " * 4
	for key in dayDict:
		self = dayDict[key]
		self.printStock()

# print finals
printFinals("Minimum", min, minDate, minDayList)
printFinals("Maximum", max, maxDate, maxDayList)

# getting stuff out of minDay List
# now I know why I should stop complicating this
stockForTable = []
for key in stockKeys:
	newStock = []
	this = stockDict[key]
	newStock.append(this.name)
	newStock.append(this.shares)
	newStock.append(this.price)
	newStock.append(this.change)
	stockForTable.append(newStock)

# using table formatte classes
heads = ["Name", "Shares", "Price", "Change"]
texttable = tableformatter.TableFormatter(heads, stockForTable)
texttable.buildtable(heads, stockForTable)
htmltable = tableformatter.HtmlTableFormatter(heads, stockForTable)
htmltable.buildtable(heads, stockForTable)
csvtable = tableformatter.CsvTableFormatter(heads, stockForTable)
csvtable.buildtable(heads, stockForTable)

